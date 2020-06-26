package com.mastertech.notafiscal.producer;

import com.mastertech.notafiscal.dto.Consulta;
import com.mastertech.notafiscal.dto.Emissao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ConsultaProducer {

    @Autowired
    private KafkaTemplate<String, Consulta> kafkaTemplate;


    public void enviaKafka(Consulta consulta) {
        kafkaTemplate.send("spec2-felipe-sarmento-2", consulta);
    }


}
