package br.com.dbc.vemser.consumer.custom;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.AliasFor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@KafkaListener(topics = "${kafka.topic}")
public @interface ConsumerCustomListener {

//    @AliasFor(annotation = KafkaListener.class, attribute = "topics")
//    String[] topics() default "meu-primeiro-topico";

    @AliasFor(annotation = KafkaListener.class, attribute = "containerFactory")
    String containerFactory() default "strContainerFactory";

    @AliasFor(annotation = KafkaListener.class, attribute = "groupId")
    String groupId() default "group1";

    @AliasFor(annotation = KafkaListener.class, attribute = "errorHandler")
    String errorHandler() default "errorCustomHandler";

    @AliasFor(annotation = KafkaListener.class, attribute = "topicPartitions")
    TopicPartition[] topicPartitions() default {};

    @AliasFor(annotation = KafkaListener.class, attribute = "clientIdPrefix")
    String clientIdPrefix() default "";

}
