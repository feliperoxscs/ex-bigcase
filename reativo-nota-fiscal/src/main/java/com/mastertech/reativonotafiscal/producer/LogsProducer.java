package com.mastertech.reativonotafiscal.producer;

import com.mastertech.reativonotafiscal.dto.NfeLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class LogsProducer {


    @Autowired
    private KafkaTemplate<String, NfeLog> kafkaTemplate;

    public void enviaKafka(NfeLog nfeLog) {
        kafkaTemplate.send("spec2-felipe-sarmento-5", nfeLog);
    }
}
