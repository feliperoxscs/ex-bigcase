package com.mastertech.reativonotafiscal.consumer;

import com.mastertech.notafiscal.dto.Consulta;
import com.mastertech.notafiscal.dto.Emissao;
import com.mastertech.reativonotafiscal.dto.NfeLog;
import com.mastertech.reativonotafiscal.model.ClienteEmissao;
import com.mastertech.reativonotafiscal.model.Nfe;
import com.mastertech.reativonotafiscal.producer.DevolveConsultaProducer;
import com.mastertech.reativonotafiscal.producer.LogsProducer;
import com.mastertech.reativonotafiscal.service.ClienteEmissaoService;
import com.mastertech.reativonotafiscal.service.NfeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class NotaFiscalConsumer {

    @Autowired
    private NfeService nfeService;

    @Autowired
    private ClienteEmissaoService clienteEmissaoService;

    @Autowired
    private DevolveConsultaProducer devolveConsultaProducer;

    @Autowired
    private LogsProducer logsProducer;

    @KafkaListener(topics = "spec2-felipe-sarmento-1", groupId = "snoopy")
    public void getEmissao(@Payload Emissao emissao) {
        Nfe nfe = nfeService.emitirNota(emissao);
        clienteEmissaoService.saveEmissao(nfe, emissao);
        logsProducer.enviaKafka(setValuesLogEmissao(emissao));
    }

    @KafkaListener(topics = "spec2-felipe-sarmento-2", groupId = "snoopy")
    public void getConsulta(@Payload Consulta consulta) {
        List<ClienteEmissao> clienteEmissao = clienteEmissaoService.getEmissao(consulta.getIdentidade());
        devolveConsultaProducer.enviaKafka(clienteEmissao);
        logsProducer.enviaKafka(setValuesLogConsulta(consulta));
    }

    private NfeLog setValuesLogEmissao(Emissao emissao) {
        NfeLog nfeLog = new NfeLog();
        nfeLog.setData(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        nfeLog.setIdentidade(emissao.getIdentidade());
        nfeLog.setValor(emissao.getValor());
        nfeLog.setTipoAcao("Emissão");
        return nfeLog;
    }

    private NfeLog setValuesLogConsulta(Consulta consulta) {
        NfeLog nfeLog = new NfeLog();
        nfeLog.setTipoAcao("Consulta");
        nfeLog.setIdentidade(consulta.getIdentidade());
        nfeLog.setData(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        return nfeLog;
    }


}
