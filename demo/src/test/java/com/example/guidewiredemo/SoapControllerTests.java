package com.example.guidewiredemo;

import com.example.guidewiredemo.controller.SoapController;
import com.example.guidewiredemo.model.SoapMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class SoapControllerTests {

    private SoapController controller;

    @BeforeEach
    void setUp() {
        controller = new SoapController();
    }

    @Test
    void testGetAll() {
        Collection<SoapMessage> all = controller.getAll();
        assertEquals(2, all.size());
    }

    @Test
    void testGetById() {
        SoapMessage msg = controller.get("1");
        assertEquals("<GetPolicy>...</GetPolicy>", msg.getRequest());
    }

    @Test
    void testGetNonExistingThrows() {
        assertThrows(ResponseStatusException.class, () -> controller.get("999"));
    }

    @Test
    void testCreateAndGet() {
        SoapMessage msg = new SoapMessage("10", "<TestReq/>", "<TestResp/>");
        controller.create(msg);
        SoapMessage loaded = controller.get("10");
        assertEquals("<TestResp/>", loaded.getResponse());
    }

    @Test
    void testCreateDuplicateThrows() {
        SoapMessage msg = new SoapMessage("1", "<Dup/>", "<DupResp/>");
        assertThrows(ResponseStatusException.class, () -> controller.create(msg));
    }

    @Test
    void testUpdate() {
        SoapMessage update = new SoapMessage("1", "<Changed/>", "<NewResp/>");
        SoapMessage res = controller.update("1", update);
        assertEquals("<Changed/>", res.getRequest());
        assertEquals("<NewResp/>", res.getResponse());
    }

    @Test
    void testUpdateNonExistingThrows() {
        SoapMessage update = new SoapMessage("404", "<None/>", "<None/>");
        assertThrows(ResponseStatusException.class, () -> controller.update("404", update));
    }

    @Test
    void testDelete() {
        controller.delete("1");
        assertThrows(ResponseStatusException.class, () -> controller.get("1"));
    }

    @Test
    void testDeleteNonExistingThrows() {
        assertThrows(ResponseStatusException.class, () -> controller.delete("404"));
    }
}
