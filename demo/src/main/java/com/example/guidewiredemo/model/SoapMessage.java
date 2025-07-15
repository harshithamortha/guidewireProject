package com.example.guidewiredemo.model;

public class SoapMessage {
    private String id;
    private String request;
    private String response;

    public SoapMessage() {}

    public SoapMessage(String id, String request, String response) {
        this.id = id;
        this.request = request;
        this.response = response;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getRequest() { return request; }
    public void setRequest(String request) { this.request = request; }

    public String getResponse() { return response; }
    public void setResponse(String response) { this.response = response; }
}
