package br.com.dbc.vemser.produtor.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.UUID;

@RequiredArgsConstructor
@Log4j2
@Service
public class ProdutorService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Value(value = "${kafka.topic}")
    private String topic;

    public void sendMessage(String mensagem) {
        this.send(mensagem, 0);
    }

    private void send(String messageStr, Integer particao) {
        MessageBuilder<String> stringMessageBuilder = MessageBuilder.withPayload(messageStr)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .setHeader(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString());
        if (particao != null) {
            stringMessageBuilder
                    .setHeader(KafkaHeaders.PARTITION_ID, particao);
        }
        Message<String> message = stringMessageBuilder.build();

        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(message);

        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info(" Log de mensagem enviada ::: {} ", messageStr);
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error(" Erro ao enviar a mensagem ::: {}", messageStr, ex);
            }
        });
    }

}
