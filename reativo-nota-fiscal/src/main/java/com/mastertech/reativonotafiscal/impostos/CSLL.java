package com.mastertech.reativonotafiscal.impostos;

public class CSLL implements Imposto {

    private static Double CSLL = 0.03;

    @Override
    public Double calcula(Double valor) {
        return valor * CSLL;
    }
}
