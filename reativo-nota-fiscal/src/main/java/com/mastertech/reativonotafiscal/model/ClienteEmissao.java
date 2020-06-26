package com.mastertech.reativonotafiscal.model;

import javax.persistence.*;

@Entity
public class ClienteEmissao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String identidade;

    private String status;

    private Double valor;

    @ManyToOne
    private Nfe nfe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Nfe getNfe() {
        return nfe;
    }

    public void setNfe(Nfe nfe) {
        this.nfe = nfe;
    }
}
