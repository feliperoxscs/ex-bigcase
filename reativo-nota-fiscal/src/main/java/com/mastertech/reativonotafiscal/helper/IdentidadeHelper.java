package com.mastertech.reativonotafiscal.helper;

public class IdentidadeHelper {

    public static Boolean isPf(String identidade) {
        if (identidade.length() > 11){
            return false;
        }
        return true;
    }

}
