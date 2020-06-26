package com.mastertech.notafiscal.consumer;

import com.mastertech.reativonotafiscal.model.ClienteEmissao;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConsultaConsumer {

    private List<ClienteEmissao> clienteEmissaoList = new ArrayList<ClienteEmissao>();

    @KafkaListener(topics = "spec2-felipe-sarmento-3", groupId = "snoopy")
    public void getMessage(@Payload List<ClienteEmissao> clienteEmissoes) {
        clienteEmissaoList = clienteEmissoes;
    }

    public List<ClienteEmissao> getClienteEmissaoList() {
        return clienteEmissaoList;
    }
}
