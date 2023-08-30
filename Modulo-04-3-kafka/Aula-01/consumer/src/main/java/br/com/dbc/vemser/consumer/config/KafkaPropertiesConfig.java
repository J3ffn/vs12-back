package br.com.dbc.vemser.consumer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaPropertiesConfig {

    @Value("${kafka.topic}")
    private String kafkaTopic;

    public String getKafkaTopic() {
        return kafkaTopic;
    }

}
