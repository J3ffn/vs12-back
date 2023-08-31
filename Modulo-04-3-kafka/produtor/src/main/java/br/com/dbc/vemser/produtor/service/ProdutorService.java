package br.com.dbc.vemser.produtor.service;

import br.com.dbc.vemser.produtor.model.dto.MensagemDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.Arrays;
import java.util.UUID;

@RequiredArgsConstructor
@Log4j2
@Service
public class ProdutorService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Value(value = "${kafka.topic}")
    private String topic;

    public void sendMessageDTO(MensagemDTO mensagemDTO, String s) throws JsonProcessingException {
        this.sendMessageForUser(objectMapper.writeValueAsString(mensagemDTO), Integer.parseInt(s));
    }

    private void sendMessageForUser(String messageStr, Integer particao) {
        Message<String> message = MessageBuilder.withPayload(messageStr)
                .setHeader(KafkaHeaders. TOPIC, topic)
                .setHeader(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString())
                .setHeader(KafkaHeaders.PARTITION_ID, particao)
                .build();
        ListenableFuture<SendResult<String, String>> send = kafkaTemplate.send(message);
        send.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure (Throwable ex) {
                log.error("Erro ao enviar a msg!");
            }
            @Override
            public void onSuccess (SendResult<String, String> result) {
                log.info("Mensagem enviada!");
            }
        });
    }
}
