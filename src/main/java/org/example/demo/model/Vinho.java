package org.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vinho {
    private Long id;
    private String nome;
    private String tipo;
    private int safra;
    private double preco;
}
