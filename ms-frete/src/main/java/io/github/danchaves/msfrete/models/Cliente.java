package io.github.danchaves.msfrete.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String email;

    @Column(nullable = false)
    private String telefone;


    @OneToMany(cascade=CascadeType.ALL, orphanRemoval = true, mappedBy = "cliente")
    private List<Frete> fretes;
}
