package io.github.danchaves.msemail.domain;


import io.github.danchaves.msemail.enums.MetodoPagamento;
import io.github.danchaves.msemail.enums.StatusPagamento;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class Cliente {

    private Long id;

    private String nome;

    private String email;

    private String telefone;


    private List<Frete> fretes;
}
