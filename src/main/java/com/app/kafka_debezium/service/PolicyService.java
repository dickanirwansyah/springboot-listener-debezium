package com.app.kafka_debezium.service;

import com.app.kafka_debezium.model.Policy;
import com.app.kafka_debezium.repository.PolicyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PolicyService {

    private final PolicyRepository policyRepository;

    public Policy addPolicy(Policy policy){
        log.info("addPolicy = [{}]",policy);
        policy.setStartDate(LocalDateTime.now());
        LocalDateTime endDate = LocalDateTime.of(2029, 1, 30, 23, 59, 59, 999999999);
        policy.setEndDate(endDate);
        return policyRepository.save(policy);
    }

    public List<Policy> getAllPolicy(){
        log.info("getAllPolicy..");
        return policyRepository.findAll();
    }

    public Policy updatePolicy(Long id,Policy policy){
        log.info("updatePolicy ID = [{}], policy = [{}]",id, policy);
        Policy currentPolicy = policyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Policy id is not found !"));
        currentPolicy.setId(id);
        currentPolicy.setPolicyHolder(policy.getPolicyHolder());
        currentPolicy.setPolicyNumber(policy.getPolicyNumber());
        currentPolicy.setStartDate(currentPolicy.getStartDate());
        currentPolicy.setEndDate(currentPolicy.getEndDate());
        return policyRepository.save(currentPolicy);
    }

}
