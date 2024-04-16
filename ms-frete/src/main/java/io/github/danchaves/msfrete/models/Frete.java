package io.github.danchaves.msfrete.models;

import io.github.danchaves.msfrete.enums.MetodoPagamento;
import io.github.danchaves.msfrete.enums.StatusPagamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_frete")
public class Frete {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String destino;

    @Column(nullable = false)
    private LocalDate data;

    @Enumerated(EnumType.STRING)
    private MetodoPagamento metodo;

    @Column(nullable = false)
    private Double valorTotal;

    @Column(nullable = false)
    private Double valorPago;


    @Enumerated(EnumType.STRING)
    private StatusPagamento status;

    @Column(columnDefinition = "TEXT")
    private String observacao;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "clientegt_id", nullable = false)
    private Cliente cliente;

}
