package br.com.dbc.vemser.consumer.service;

import br.com.dbc.vemser.consumer.custom.ConsumerCustomListener;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Log4j2

@Service

public class ConsumerService {

    private final ObjectMapper objectMapper;

    @ConsumerCustomListener(clientIdPrefix = "primeiroTopico")
    public void consume(@Payload String message,
                        @Header(KafkaHeaders.RECEIVED_KEY) String key,
                        @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        log.info("Offset -> '{}'", offset);
        log.info("Key -> '{}'", key);
        log.info("Consumed Object message -> '{}'  ", message);
    }

    @ConsumerCustomListener(groupId = "group2",
            clientIdPrefix = "segundoTopico",
            topicPartitions = {@TopicPartition(topic = "${kafka.topic}", partitions = {"1", "2"})}
    )
    public void consumirParticao(@Payload String message,
                                 @Header(KafkaHeaders.RECEIVED_KEY) String key,
                                 @Header(KafkaHeaders.OFFSET) Long offset,
                                 @Header(KafkaHeaders.RECEIVED_KEY) Integer partitionId,
                                 @Header(KafkaHeaders.RECEIVED_TOPIC) String topic
    ) throws JsonProcessingException {
        log.info("Offset -> {}", offset);
        log.info("Key -> '{}' ", key);
        log.info("Partition -> {}", partitionId);
        log.info("Topic -> '{}'", topic);
        log.info("Msg -> '{}'   ", message);
    }

}
