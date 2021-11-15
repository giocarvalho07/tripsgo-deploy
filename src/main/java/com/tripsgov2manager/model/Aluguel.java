package com.tripsgov2manager.model;

import javax.persistence.*;

@Entity
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aluguel")
    private Long id;


    private String data;

    private String datafim;

    @Enumerated(EnumType.STRING)
    private Pagamento pagamento;


    private Integer quartos;


    public Aluguel() {
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getData() {
        return data;
    }


    public void setData(String data) {
        this.data = data;
    }


    public String getDatafim() {
        return datafim;
    }


    public void setDatafim(String datafim) {
        this.datafim = datafim;
    }


    public Pagamento getPagamento() {
        return pagamento;
    }


    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }


    public Integer getQuartos() {
        return quartos;
    }


    public void setQuartos(Integer quartos) {
        this.quartos = quartos;
    }


    @Override
    public String toString() {
        return "Aluguel [id=" + id + ", data=" + data + ", datafim=" + datafim + ", pagamento=" + pagamento
                + ", quartos=" + quartos + "]";
    }
}
