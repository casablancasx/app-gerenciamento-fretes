package io.github.danchaves.msfrete.models;

import io.github.danchaves.msfrete.enums.MetodoPagamento;
import io.github.danchaves.msfrete.enums.StatusPagamento;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_frete")
public class Frete {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String destino;

    private LocalDate data;

    @Enumerated(EnumType.STRING)
    private MetodoPagamento metodo;

    private Double total;

    private Double pagamentoInicial;

    private StatusPagamento status;

    @Column(columnDefinition = "TEXT")
    private String observacao;

}
