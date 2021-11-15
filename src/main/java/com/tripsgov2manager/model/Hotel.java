package com.tripsgov2manager.model;

import javax.persistence.*;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hotel")
    private Long id;

    private String nome;

    private String descricao;

    private Double preco;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    private Integer quartos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Integer getQuartos() {
        return quartos;
    }

    public void setQuartos(Integer quartos) {
        this.quartos = quartos;
    }

    @Override
    public String toString() {
        return "Hotel [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + ", categoria="
                + categoria + ", quartos=" + quartos + "]";
    }
}
