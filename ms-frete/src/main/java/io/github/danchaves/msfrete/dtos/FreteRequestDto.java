package io.github.danchaves.msfrete.dtos;


import io.github.danchaves.msfrete.enums.MetodoPagamento;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class FreteRequestDto {

    private String nome;

    private String email;

    private String telefone;

    private String destino;

    private LocalDate data;

    private MetodoPagamento metodo;

    private Double valorTotal;

    private Double valorPago;

    private String observacao;

}
