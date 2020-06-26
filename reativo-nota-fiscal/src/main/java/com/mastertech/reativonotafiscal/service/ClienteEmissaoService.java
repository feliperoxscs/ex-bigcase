package com.mastertech.reativonotafiscal.service;

import com.mastertech.notafiscal.dto.Emissao;
import com.mastertech.reativonotafiscal.exceptions.ClienteNotFoundException;
import com.mastertech.reativonotafiscal.model.ClienteEmissao;
import com.mastertech.reativonotafiscal.model.Nfe;
import com.mastertech.reativonotafiscal.repository.ClienteEmissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteEmissaoService {


    @Autowired
    private ClienteEmissaoRepository clienteEmissaoRepository;


    public void saveEmissao(Nfe nfe, Emissao emissao) {
        ClienteEmissao clienteEmissao = new ClienteEmissao();
        clienteEmissao.setIdentidade(emissao.getIdentidade());
        clienteEmissao.setValor(emissao.getValor());
        clienteEmissao.setNfe(nfe);
        clienteEmissao.setStatus("complete");
        clienteEmissaoRepository.save(clienteEmissao);
    }

    public List<ClienteEmissao> getEmissao(String identidade) {
        List<ClienteEmissao> clienteEmissaoByIdentidade =
                clienteEmissaoRepository.findClienteEmissaoByIdentidade(identidade);
        if (clienteEmissaoByIdentidade.size() == 0) {
            throw new ClienteNotFoundException();
        }
        return clienteEmissaoByIdentidade;
    }
}
