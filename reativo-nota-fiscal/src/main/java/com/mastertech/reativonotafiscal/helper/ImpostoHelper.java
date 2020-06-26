package com.mastertech.reativonotafiscal.helper;

import com.mastertech.reativonotafiscal.impostos.CSLL;
import com.mastertech.reativonotafiscal.impostos.Confins;
import com.mastertech.reativonotafiscal.impostos.IRRF;
import com.mastertech.reativonotafiscal.impostos.Imposto;

public class ImpostoHelper {

    public static Double getValorIrrf(Double valor) {
        Imposto imposto = new IRRF();
        return imposto.calcula(valor);
    }

    public static Double getValorCsll(Double valor) {
        Imposto imposto = new CSLL();
        return imposto.calcula(valor);
    }

    public static Double getValorConfins(Double valor) {
        Imposto imposto = new Confins();
        return imposto.calcula(valor);
    }
}
