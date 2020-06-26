package com.mastertech.reativonotafiscal.dto;


import java.time.LocalDateTime;

public class NfeLog {

    private String data;
    private String tipoAcao;
    private String identidade;
    private Double valor;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTipoAcao() {
        return tipoAcao;
    }

    public void setTipoAcao(String tipoAcao) {
        this.tipoAcao = tipoAcao;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
