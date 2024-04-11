package io.github.danchaves.msfrete.mapper;

import io.github.danchaves.msfrete.dtos.FreteRequestDto;
import io.github.danchaves.msfrete.dtos.FreteResponseDto;
import io.github.danchaves.msfrete.models.Frete;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FreteMapper {

    FreteMapper INSTANCE = Mappers.getMapper(FreteMapper.class);

    @Mapping(source = "nome", target = "cliente.nome")
    @Mapping(source = "email", target = "cliente.email")
    @Mapping(source = "telefone", target = "cliente.telefone")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    Frete mapDtoToEntity(FreteRequestDto freteRequestDto);

    @Mapping(source = "cliente.nome" , target = "nome")
    @Mapping(source = "cliente.telefone" , target = "telefone")
    @Mapping(target = "valorFaltando", ignore = true)
    FreteResponseDto mapEntityToDto(Frete frete);
}
