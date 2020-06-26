package com.mastertech.logsnfe.consumer;

import com.mastertech.reativonotafiscal.dto.NfeLog;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

@Component
public class LogsConsumer {


    @KafkaListener(topics = "spec2-felipe-sarmento-5", groupId = "snoopy")
    public void getLogs(@Payload NfeLog nfeLog) throws IOException{
        if (nfeLog.getTipoAcao().equalsIgnoreCase("Emissão")){
            writeFileEmissao(nfeLog);
        }
        else {
            writeFileConsulta(nfeLog);
        }
    }


    private void writeFileEmissao(NfeLog nfeLog) throws IOException {
        FileWriter fileWriter = new FileWriter("logs.txt", true);
        fileWriter.write("[");
        fileWriter.write(nfeLog.getData());
        fileWriter.write("] ");
        fileWriter.write("[");
        fileWriter.write(nfeLog.getTipoAcao());
        fileWriter.write("]: ");
        fileWriter.write(nfeLog.getIdentidade());
        fileWriter.write(" acaba de pedir a emissão de uma NF no valor de R$ "+nfeLog.getValor() + "!\n");
        fileWriter.flush();
        fileWriter.close();
    }

    private void writeFileConsulta(NfeLog nfeLog) throws IOException {
        FileWriter fileWriter = new FileWriter("logs.txt", true);
        fileWriter.write("[");
        fileWriter.write(nfeLog.getData());
        fileWriter.write("] ");
        fileWriter.write("[");
        fileWriter.write(nfeLog.getTipoAcao());
        fileWriter.write("]: ");
        fileWriter.write(nfeLog.getIdentidade());
        fileWriter.write(" acaba de pedir os dados das suas notas fiscais.\n");
        fileWriter.flush();
        fileWriter.close();
    }
}
