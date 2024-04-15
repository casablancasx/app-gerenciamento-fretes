package io.github.danchaves.msfrete.service;

import io.github.danchaves.msfrete.dtos.FreteRequestDto;
import io.github.danchaves.msfrete.dtos.FreteResponseDto;
import io.github.danchaves.msfrete.infra.exceptions.ResourceNotFoundException;
import io.github.danchaves.msfrete.mapper.FreteMapper;
import io.github.danchaves.msfrete.models.Frete;
import io.github.danchaves.msfrete.repositories.FreteRepository;
import io.github.danchaves.msfrete.service.interfaces.IsetStatus;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FreteService {

    private final IsetStatus isetStatus;
    private final FreteRepository repository;

    public FreteService(IsetStatus isetStatus, FreteRepository repository) {
        this.isetStatus = isetStatus;
        this.repository = repository;
    }

    public FreteResponseDto insert(FreteRequestDto requestDto) {
        Frete entity = FreteMapper.INSTANCE.mapDtoToEntity(requestDto);
        isetStatus.setStaus(entity);
        repository.save(entity);
        return FreteMapper.INSTANCE.mapEntityToDto(entity);
    }

    public Page<FreteResponseDto> findAll(int pagina, int itens) {
        Page<Frete> pageEntity = repository.findAll(PageRequest.of(pagina,itens));
        return FreteMapper.INSTANCE.mapPageEntityToPageDto(pageEntity);
    }

    public void delete(Long id) {
        Frete entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("id não encontrado"));
        repository.delete(entity);
    }



}
