package io.github.danchaves.msemail.domain;

import io.github.danchaves.msemail.enums.MetodoPagamento;
import io.github.danchaves.msemail.enums.StatusPagamento;

import java.time.LocalDate;

public class Frete {

    private Long id;

    private String destino;

    private LocalDate data;

    private MetodoPagamento metodo;

    private Double valorTotal;

    private Double valorPago;

    private StatusPagamento status;

    private String observacao;

    private Cliente cliente;
}
