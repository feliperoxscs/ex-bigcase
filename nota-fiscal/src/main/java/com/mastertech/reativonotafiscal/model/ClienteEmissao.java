package com.mastertech.reativonotafiscal.model;

public class ClienteEmissao {

    private String identidade;

    private String status;

    private Double valor;

    private Nfe nfe;

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
