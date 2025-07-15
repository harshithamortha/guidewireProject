package com.example.guidewiredemo.controller;

import com.example.guidewiredemo.model.XmlTransformation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/xml-transform")
public class XmlTransformationController {

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public String transformXml(@RequestBody String inputXml) {
        // Simple demo transformation: wrap input in <transformed> tags
        String outputXml = "<transformed>" + inputXml + "</transformed>";
        return outputXml;
    }

    // Alternative JSON version if needed:
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public XmlTransformation transformXmlJson(@RequestBody XmlTransformation input) {
        String transformed = "<transformed>" + input.getInputXml() + "</transformed>";
        return new XmlTransformation(input.getInputXml(), transformed);
    }
}
