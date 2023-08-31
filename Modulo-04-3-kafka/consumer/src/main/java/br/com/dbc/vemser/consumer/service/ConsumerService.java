package br.com.dbc.vemser.consumer.service;

import br.com.dbc.vemser.consumer.dto.MensagemDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
@Log4j2

@Service
public class ConsumerService {

    private final ObjectMapper objectMapper;

    private final DateTimeFormatter dateFMT = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    @KafkaListener(
        topicPartitions = {@TopicPartition (topic = "${kafka.topic}", partitions = {"0"})},
        clientIdPrefix = "AA_Geral"
    )
    public void consumerWhatsApp(@Payload String mensagem,
                                 @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Long partition) throws JsonProcessingException {
        MensagemDTO mensagemDTO = objectMapper.readValue(mensagem, MensagemDTO.class);
        log.info(dateFMT.format(mensagemDTO.getDataCriacao()) + " : [" + mensagemDTO.getUsuario() + "]" + " : {}", mensagemDTO.getMensagem());
    }

    @KafkaListener(
        topicPartitions = {@TopicPartition (topic = "${kafka.topic}", partitions = {"10"})},
        clientIdPrefix = "Privado"
    )
    public void consumerWhatsAppPrivado(@Payload String mensagem,
                                        @Header (KafkaHeaders.RECEIVED_PARTITION_ID) Long partition) throws JsonProcessingException {
        MensagemDTO mensagemDTO = objectMapper.readValue(mensagem, MensagemDTO.class);
        log.info(dateFMT.format(mensagemDTO.getDataCriacao()) + " : [" + mensagemDTO.getUsuario() + "] (PRIVADO)" + " : {}", mensagemDTO.getMensagem());
    }

}
