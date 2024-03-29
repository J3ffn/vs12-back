package br.com.dbc.vemser.produtor.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;

@RequiredArgsConstructor

@Configuration
public class KafkaProducerConfig {

    public final KafkaProperties kafkaProperties;

    @Value("${kafka.topic}")
    public String kafkaTopic;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        var configs = new HashMap<String, Object>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        return new KafkaAdmin(configs);
    }

    @Bean
    public KafkaAdmin.NewTopics  topics() {
        return new KafkaAdmin.NewTopics(
                TopicBuilder.name(kafkaTopic).partitions(3).replicas(1).build()
        );
    }

}
