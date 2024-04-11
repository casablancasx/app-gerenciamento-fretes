package io.github.danchaves.msfrete.service;

import io.github.danchaves.msfrete.dtos.FreteRequestDto;
import io.github.danchaves.msfrete.dtos.FreteResponseDto;
import io.github.danchaves.msfrete.mapper.FreteMapper;
import io.github.danchaves.msfrete.models.Frete;
import io.github.danchaves.msfrete.repositories.FreteRepository;
import org.springframework.stereotype.Service;

@Service
public class FreteService {

    private final FreteRepository repository;

    public FreteService(FreteRepository repository) {
        this.repository = repository;
    }

    public FreteResponseDto insert(FreteRequestDto requestDto) {
        Frete entity = FreteMapper.INSTANCE.mapDtoToEntity(requestDto);
        repository.save(entity);
        return FreteMapper.INSTANCE.mapEntityToDto(entity);
    }
}
