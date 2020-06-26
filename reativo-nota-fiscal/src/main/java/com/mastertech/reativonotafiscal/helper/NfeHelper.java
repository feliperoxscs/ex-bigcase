package com.mastertech.reativonotafiscal.helper;

public class NfeHelper {

    public static Double getValorOptante(Double valor) {
        return valor - ImpostoHelper.getValorIrrf(valor);
    }

    public static Double getValorNaoOptante(Double valor) {
        return valor - ImpostoHelper.getValorIrrf(valor) - ImpostoHelper.getValorCsll(valor) -
                ImpostoHelper.getValorConfins(valor);
    }
}
