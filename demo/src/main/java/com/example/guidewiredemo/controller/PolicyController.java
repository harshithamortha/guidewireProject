package com.example.guidewiredemo.controller;

import com.example.guidewiredemo.model.Policy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    private final Map<String, Policy> policyStore = new ConcurrentHashMap<>();

    
    public PolicyController() {
        policyStore.put("PC-1001", new Policy("PC-1001", "Alice Johnson", "Active"));
        policyStore.put("PC-1002", new Policy("PC-1002", "Bob Smith", "Cancelled"));
        policyStore.put("PC-1003", new Policy("PC-1003", "Carol White", "Active"));
    }

    @GetMapping
    public Collection<Policy> getAllPolicies() {
        return policyStore.values();
    }

    @GetMapping("/{policyNumber}")
    public Policy getPolicy(@PathVariable String policyNumber) {
        Policy policy = policyStore.get(policyNumber);
        if (policy == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Policy not found");
        }
        return policy;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Policy createPolicy(@RequestBody Policy policy) {
        if (policyStore.containsKey(policy.getPolicyNumber())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Policy already exists");
        }
        policyStore.put(policy.getPolicyNumber(), policy);
        return policy;
    }

    @PutMapping("/{policyNumber}")
    public Policy updatePolicy(@PathVariable String policyNumber, @RequestBody Policy updatedPolicy) {
        if (!policyStore.containsKey(policyNumber)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Policy not found");
        }
        updatedPolicy.setPolicyNumber(policyNumber);
        policyStore.put(policyNumber, updatedPolicy);
        return updatedPolicy;
    }

    @DeleteMapping("/{policyNumber}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePolicy(@PathVariable String policyNumber) {
        if (!policyStore.containsKey(policyNumber)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Policy not found");
        }
        policyStore.remove(policyNumber);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Map<String, String>> handleResponseStatus(ResponseStatusException ex) {
        String msg = ex.getReason() != null ? ex.getReason() : "Something went wrong";
        return ResponseEntity
                .status(ex.getStatusCode())
                .body(Map.of("message", msg));
    }
}
