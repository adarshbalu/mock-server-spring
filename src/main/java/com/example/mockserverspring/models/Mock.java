package com.example.mockserverspring.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Mock {
    @Id
    private int id;

    @Indexed(unique = true) // For unique name of mock server
    private String name;

    private List<Request> requests;

    public Mock(String name, List<Request> requests) {
        this.name = name;
        this.requests = requests;
    }

    public Mock(int id, String name, List<Request> requests) {
        this.id = id;
        this.name = name;
        this.requests = requests;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }
}
