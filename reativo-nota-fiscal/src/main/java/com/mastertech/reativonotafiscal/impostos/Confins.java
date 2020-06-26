package com.mastertech.reativonotafiscal.impostos;

public class Confins implements Imposto {

    private static Double COFINS = 0.0065;

    @Override
    public Double calcula(Double valor) {
        return valor * COFINS;
    }
}
