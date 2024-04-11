package io.github.danchaves.msfrete.dtos;


import io.github.danchaves.msfrete.enums.MetodoPagamento;
import io.github.danchaves.msfrete.enums.StatusPagamento;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class FreteResponseDto {

    private Long id;

    private String nome;

    private String telefone;

    private String destino;

    private LocalDate data;

    private MetodoPagamento metodo;

    private Double valorTotal;

    private Double valorPago;

    private StatusPagamento status;

    private Double valorFaltando;

    private String observacao;

    public void setValorFaltando(){
        valorFaltando = valorTotal - valorPago;
    }
}
