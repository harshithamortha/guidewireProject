package com.example.guidewiredemo;

import com.example.guidewiredemo.controller.XmlTransformationController;
import com.example.guidewiredemo.model.XmlTransformation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class XmlTransformationControllerTests {

    private XmlTransformationController controller;

    @BeforeEach
    void setUp() {
        controller = new XmlTransformationController();
    }

    @Test
    void testTransformXmlReturnsTransformedXml() {
        String input = "<foo>bar</foo>";
        String output = controller.transformXml(input);
        assertEquals("<transformed><foo>bar</foo></transformed>", output);
    }

    @Test
    void testTransformXmlJson() {
        XmlTransformation input = new XmlTransformation("<a>1</a>", null);
        XmlTransformation result = controller.transformXmlJson(input);

        assertEquals("<a>1</a>", result.getInputXml());
        assertEquals("<transformed><a>1</a></transformed>", result.getOutputXml());
    }
}
