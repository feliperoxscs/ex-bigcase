package com.mastertech.reativonotafiscal.impostos;

public class IRRF implements Imposto {

    private static Double IRRF = 0.015;

    @Override
    public Double calcula(Double valor) {
        return valor * IRRF;
    }
}
