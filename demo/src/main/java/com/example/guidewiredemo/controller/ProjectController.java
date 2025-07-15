package com.example.guidewiredemo.controller;

import com.example.guidewiredemo.model.Project;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final List<Project> projects = List.of(
    new Project(
        "policycenter-rest-api-integration",
        "PolicyCenter REST API Integration",
        "Developed a robust REST API integration with Guidewire PolicyCenter to automate policy data retrieval, addressing delays and manual errors faced by insurers.",
        List.of("Guidewire InsuranceSuite", "RESTful API", "Java 17", "Spring Boot"),
        "/policycenter-rest-api-integration.html"
    ),
    new Project(
        "enterprise-soap-web-service-integration",
        "Enterprise SOAP Web Service Integration",
        "Engineered SOAP web service client in Java Spring Boot enabling seamless communication with legacy insurance systems, reducing integration complexity.",
        List.of("SOAP", "Java 17", "Spring Boot", "XML"),
        "/enterprise-soap-web-service-integration.html"
    ),
    new Project(
        "xml-data-processing-transformation",
        "XML Data Processing & Transformation",
        "Created an XML processing module utilizing XSLT and Java libraries to automate data transformations, enhancing data accuracy and operational efficiency.",
        List.of("XML", "XSLT", "Java 17", "Spring Boot"),
        "/xml-data-processing.html"
    )
);


    @GetMapping
    public List<Project> getAllProjects() {
        return projects;
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable String id) {
        return projects.stream()
                       .filter(p -> p.getId().equals(id))
                       .findFirst()
                       .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}