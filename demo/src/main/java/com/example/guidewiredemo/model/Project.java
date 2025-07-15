package com.example.guidewiredemo.model;

import java.util.List;

public class Project {
    private String id;
    private String title;
    private String description;
    private List<String> techStack;
    private String detailsUrl;

    public Project() {}

    public Project(String id, String title, String description, List<String> techStack, String detailsUrl) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.techStack = techStack;
        this.detailsUrl = detailsUrl;
    }
      public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTechStack() {
        return techStack;
    }
    public void setTechStack(List<String> techStack) {
        this.techStack = techStack;
    }

    public String getDetailsUrl() {
        return detailsUrl;
    }
    public void setDetailsUrl(String detailsUrl) {
        this.detailsUrl = detailsUrl;
    }
}
