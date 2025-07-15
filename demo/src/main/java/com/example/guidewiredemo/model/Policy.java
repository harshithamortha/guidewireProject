package com.example.guidewiredemo.model;

public class Policy {
    private String policyNumber;
    private String insuredName;
    private String status;

    public Policy() {}

    public Policy(String policyNumber, String insuredName, String status) {
        this.policyNumber = policyNumber;
        this.insuredName = insuredName;
        this.status = status;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }
    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getInsuredName() {
        return insuredName;
    }
    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
