package com.example.guidewiredemo.controller;

import com.example.guidewiredemo.model.SoapMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api/soap-messages")
public class SoapController {

    private final Map<String, SoapMessage> store = new ConcurrentHashMap<>();

    public SoapController() {
        store.put("1", new SoapMessage("1", "<GetPolicy>...</GetPolicy>", "<Policy>...</Policy>"));
        store.put("2", new SoapMessage("2", "<GetClaim>...</GetClaim>", "<Claim>...</Claim>"));
    }

    @GetMapping
    public Collection<SoapMessage> getAll() {
        return store.values();
    }

    @GetMapping("/{id}")
    public SoapMessage get(@PathVariable String id) {
        SoapMessage msg = store.get(id);
        if (msg == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "SOAP message not found");
        return msg;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SoapMessage create(@RequestBody SoapMessage msg) {
        if (store.containsKey(msg.getId())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "ID exists");
        }
        store.put(msg.getId(), msg);
        return msg;
    }

    @PutMapping("/{id}")
    public SoapMessage update(@PathVariable String id, @RequestBody SoapMessage updated) {
        if (!store.containsKey(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "SOAP message not found");
        }
        updated.setId(id);
        store.put(id, updated);
        return updated;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        if (!store.containsKey(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "SOAP message not found");
        }
        store.remove(id);
    }

}
