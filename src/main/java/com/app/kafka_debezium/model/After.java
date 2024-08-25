package com.app.kafka_debezium.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class After {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("policy_number")
    private String policyNumber;
    @JsonProperty("policy_holder")
    private String policyHolder;
    @JsonProperty("start_date")
    private Long startDate;
    @JsonProperty("end_date")
    private Long endDate;
}
