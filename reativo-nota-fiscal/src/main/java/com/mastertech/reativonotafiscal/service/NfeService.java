package com.mastertech.reativonotafiscal.service;

import com.mastertech.reativonotafiscal.client.ReceitaClient;
import com.mastertech.notafiscal.dto.Emissao;
import com.mastertech.reativonotafiscal.dto.ReceitaResponse;
import com.mastertech.reativonotafiscal.helper.IdentidadeHelper;
import com.mastertech.reativonotafiscal.helper.ImpostoHelper;
import com.mastertech.reativonotafiscal.helper.NfeHelper;
import com.mastertech.reativonotafiscal.model.Nfe;
import com.mastertech.reativonotafiscal.repository.NotaFiscalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NfeService {


    @Autowired
    private NotaFiscalRepository notaFiscalRepository;

    @Autowired
    private ReceitaClient receitaClient;

    public Nfe emitirNota(Emissao emissao) {
        Nfe nfe = new Nfe();
        nfe.setValorInicial(emissao.getValor());
        nfe.setValorIRRF(ImpostoHelper.getValorIrrf(emissao.getValor()));
        if (IdentidadeHelper.isPf(emissao.getIdentidade())) {
            nfe.setValorFinal(emissao.getValor());
            nfe.setValorCSLL(0.0);
            nfe.setValorCofins(0.0);
        }
        else {
            ReceitaResponse receitaResponse = receitaClient.getCapitalSocial(emissao.getIdentidade());
            if (receitaResponse.getCapitalSocial() < 1000000) {
                nfe.setValorFinal(NfeHelper.getValorOptante(emissao.getValor()));
            }
            else {
                nfe.setValorFinal(NfeHelper.getValorNaoOptante(emissao.getValor()));
                nfe.setValorCSLL(ImpostoHelper.getValorCsll(emissao.getValor()));
                nfe.setValorCofins(ImpostoHelper.getValorConfins(emissao.getValor()));
            }
        }
        notaFiscalRepository.save(nfe);
        return nfe;
    }
}
