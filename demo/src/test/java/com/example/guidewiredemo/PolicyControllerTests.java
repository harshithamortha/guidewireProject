package com.example.guidewiredemo;

import com.example.guidewiredemo.controller.PolicyController;
import com.example.guidewiredemo.model.Policy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class PolicyControllerTests {
    private PolicyController controller;

    @BeforeEach
    void setUp() {
        controller = new PolicyController();
    }

    @Test
    void testGetAllPolicies() {
        Collection<Policy> policies = controller.getAllPolicies();
        assertEquals(3, policies.size());
    }

    @Test
    void testGetPolicyByNumber() {
        Policy p = controller.getPolicy("PC-1001");
        assertEquals("Alice Johnson", p.getInsuredName());
        assertEquals("Active", p.getStatus());
    }

    @Test
    void testCreateAndGetPolicy() {
        Policy newP = new Policy("PC-9999", "Test User", "Active");
        controller.createPolicy(newP);

        Policy result = controller.getPolicy("PC-9999");
        assertEquals("Test User", result.getInsuredName());
        assertEquals("Active", result.getStatus());
    }

    @Test
    void testCreateDuplicatePolicyThrows() {
        Policy dup = new Policy("PC-1001", "Someone Else", "Active");
        assertThrows(ResponseStatusException.class, () -> controller.createPolicy(dup));
    }

    @Test
    void testUpdatePolicy() {
        Policy update = new Policy("PC-1001", "Updated Name", "Renewed");
        Policy updated = controller.updatePolicy("PC-1001", update);

        assertEquals("Updated Name", updated.getInsuredName());
        assertEquals("Renewed", updated.getStatus());
    }

    @Test
    void testUpdateNonExistingPolicyThrows() {
        Policy update = new Policy("PC-8888", "Nobody", "Cancelled");
        assertThrows(ResponseStatusException.class, () -> controller.updatePolicy("PC-8888", update));
    }

    @Test
    void testDeletePolicy() {
        controller.deletePolicy("PC-1002");
        assertThrows(ResponseStatusException.class, () -> controller.getPolicy("PC-1002"));
    }

    @Test
    void testDeleteNonExistingPolicyThrows() {
        assertThrows(ResponseStatusException.class, () -> controller.deletePolicy("PC-7777"));
    }
}
