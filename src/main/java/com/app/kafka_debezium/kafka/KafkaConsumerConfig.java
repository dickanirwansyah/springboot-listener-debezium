package com.app.kafka_debezium.kafka;

import com.app.kafka_debezium.deserializer.PolicyDeserializer;
import com.app.kafka_debezium.model.Policy;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Policy> kafkaListenerContainerFactory(ConsumerFactory<String,Policy> consumerFactory){
        ConcurrentKafkaListenerContainerFactory<String,Policy> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        return factory;
    }

    @Bean
    public ConsumerFactory<String, Policy> consumerFactory (){
        Map<String, Object> map = new HashMap<>();
        map.put("bootstrap.servers","localhost:29092");
        map.put("key.deserializer", StringDeserializer.class);
        map.put("value.deserializer", PolicyDeserializer.class);
        map.put("auto.offset.reset", "earliest");
        return new DefaultKafkaConsumerFactory<>(map);
    }
}
