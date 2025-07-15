package com.example.guidewiredemo.model;

public class XmlTransformation {
    private String inputXml;
    private String outputXml;

    public XmlTransformation() {}

    public XmlTransformation(String inputXml, String outputXml) {
        this.inputXml = inputXml;
        this.outputXml = outputXml;
    }

    public String getInputXml() {
        return inputXml;
    }

    public void setInputXml(String inputXml) {
        this.inputXml = inputXml;
    }

    public String getOutputXml() {
        return outputXml;
    }

    public void setOutputXml(String outputXml) {
        this.outputXml = outputXml;
    }
}
