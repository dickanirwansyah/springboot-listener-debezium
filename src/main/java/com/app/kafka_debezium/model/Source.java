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
public class Source {

    @JsonProperty("version")
    private String version;
    @JsonProperty("connector")
    private String connector;
    @JsonProperty("name")
    private String name;
    @JsonProperty("ts_ms")
    private Long tsMs;
    @JsonProperty("snapshot")
    private String snapshot;
    @JsonProperty("db")
    private String db;
    @JsonProperty("sequence")
    private String sequence;
    @JsonProperty("schema")
    private String schema;
    @JsonProperty("table")
    private String table;
    @JsonProperty("txId")
    private Long txId;
    @JsonProperty("lsn")
    private Long lsn;
    @JsonProperty("xmin")
    private Object xmin;
}
