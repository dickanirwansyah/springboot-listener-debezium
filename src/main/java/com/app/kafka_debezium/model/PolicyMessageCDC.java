package com.app.kafka_debezium.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PolicyMessageCDC {

    @JsonProperty("before")
    private Before before;
    @JsonProperty("after")
    private After after;
    @JsonProperty("source")
    private Source source;
    @JsonProperty("op")
    private String op;
    @JsonProperty("tn_ms")
    private Long tnMs;
    @JsonProperty("transaction")
    private Object transaction;
}
