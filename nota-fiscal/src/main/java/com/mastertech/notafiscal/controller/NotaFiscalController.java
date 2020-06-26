package com.mastertech.notafiscal.controller;

import com.mastertech.notafiscal.consumer.ConsultaConsumer;
import com.mastertech.notafiscal.dto.Consulta;
import com.mastertech.reativonotafiscal.model.ClienteEmissao;
import com.mastertech.notafiscal.dto.Emissao;
import com.mastertech.notafiscal.dto.EmissaoResponse;
import com.mastertech.notafiscal.producer.ConsultaProducer;
import com.mastertech.notafiscal.producer.EmissaoProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotaFiscalController {

    @Autowired
    private ConsultaConsumer consultaConsumer;

    @Autowired
    private EmissaoProducer emissaoProducer;

    @Autowired
    private ConsultaProducer consultaProducer;

    @PostMapping("/nfe/emitir")
    public EmissaoResponse emitirNota(@RequestBody Emissao emissao) {
        emissaoProducer.enviaKafka(emissao);
        EmissaoResponse emissaoResponse = new EmissaoResponse();
        emissaoResponse.setStatus("pending");
        return emissaoResponse;
    }

    @GetMapping("/nfe/consultar/{identidade}")
    public List<ClienteEmissao> consultaNotas(@PathVariable String identidade){
        consultaProducer.enviaKafka(new Consulta(identidade));
        return consultaConsumer.getClienteEmissaoList();
    }
}
