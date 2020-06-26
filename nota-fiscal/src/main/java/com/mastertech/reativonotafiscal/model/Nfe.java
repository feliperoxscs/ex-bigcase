package com.mastertech.reativonotafiscal.model;


public class Nfe {

    private Long id;
    private Double valorInicial;
    private Double valorIRRF;
    private Double valorCSLL;
    private Double valorCofins;
    private Double valorFinal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(Double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public Double getValorIRRF() {
        return valorIRRF;
    }

    public void setValorIRRF(Double valorIRRF) {
        this.valorIRRF = valorIRRF;
    }

    public Double getValorCSLL() {
        return valorCSLL;
    }

    public void setValorCSLL(Double valorCSLL) {
        this.valorCSLL = valorCSLL;
    }

    public Double getValorCofins() {
        return valorCofins;
    }

    public void setValorCofins(Double valorCofins) {
        this.valorCofins = valorCofins;
    }

    public Double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(Double valorFinal) {
        this.valorFinal = valorFinal;
    }
}
