package com.app.kafka_debezium.deserializer;

import com.app.kafka_debezium.model.PolicyMessageCDC;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;

@Slf4j
public class PolicyDeserializer implements Deserializer<PolicyMessageCDC> {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Deserializer.super.configure(configs, isKey);
    }

    @Override
    public PolicyMessageCDC deserialize(String payload, byte[] bytes) {
        log.info("kafka process deserializer from payload = [{}]",payload);
        try{
            return objectMapper.readValue(bytes, PolicyMessageCDC.class);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public PolicyMessageCDC deserialize(String topic, Headers headers, byte[] data) {
        return Deserializer.super.deserialize(topic, headers, data);
    }

    @Override
    public PolicyMessageCDC deserialize(String topic, Headers headers, ByteBuffer data) {
        return Deserializer.super.deserialize(topic, headers, data);
    }

    @Override
    public void close() {
        Deserializer.super.close();
    }
}
