package com.app.kafka_debezium.controller;

import com.app.kafka_debezium.model.Policy;
import com.app.kafka_debezium.service.PolicyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/policy")
public class PolicyController {

    private final PolicyService policyService;

    @PostMapping(value = "/add-policy")
    public ResponseEntity<Policy> addPolicy(@RequestBody Policy policy){
        return ResponseEntity.ok()
                .body(policyService.addPolicy(policy));
    }

    @PostMapping(value = "/update-policy/{id}")
    public ResponseEntity<Policy> updatePolicy(@PathVariable("id")Long id,@RequestBody Policy policy){
        return ResponseEntity.ok()
                .body(policyService.updatePolicy(id,policy));
    }

    @GetMapping(value = "/get-allpolicy")
    public ResponseEntity<List<Policy>> getAllPolicy(){
        return ResponseEntity.ok()
                .body(policyService.getAllPolicy());
    }
}
