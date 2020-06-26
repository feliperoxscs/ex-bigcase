package com.mastertech.reativonotafiscal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReceitaResponse {

    @JsonProperty("capital_social")
    private Double capitalSocial;

    public Double getCapitalSocial() {
        return capitalSocial;
    }

    public void setCapitalSocial(Double capitalSocial) {
        this.capitalSocial = capitalSocial;
    }
}
