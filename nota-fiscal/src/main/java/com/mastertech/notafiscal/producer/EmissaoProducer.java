package com.mastertech.notafiscal.producer;

import com.mastertech.notafiscal.dto.Emissao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmissaoProducer {

    @Autowired
    private KafkaTemplate<String, Emissao> kafkaTemplate;


    public void enviaKafka(Emissao emissao) {
        System.out.println(emissao);
        kafkaTemplate.send("spec2-felipe-sarmento-1", emissao);
    }


}
