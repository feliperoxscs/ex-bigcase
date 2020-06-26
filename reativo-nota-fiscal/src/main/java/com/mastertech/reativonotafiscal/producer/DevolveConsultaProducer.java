package com.mastertech.reativonotafiscal.producer;

import com.mastertech.reativonotafiscal.model.ClienteEmissao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DevolveConsultaProducer {

    @Autowired
    private KafkaTemplate<String, List<ClienteEmissao>> kafkaTemplate;


    public void enviaKafka(List<ClienteEmissao> clienteEmissao) {
        kafkaTemplate.send("spec2-felipe-sarmento-3", clienteEmissao);
    }
}
