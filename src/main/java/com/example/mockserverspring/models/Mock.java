package com.example.mockserverspring.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Mock {
    //    @Transient
//    public static final String SEQUENCE_NAME = "mocks_sequence";
    @Id
    private String id;

    @Indexed(unique = true) // For unique name of mock server
    private String name;

    //    @DBRef
    private List<Request> requests;

    public Mock(String name, List<Request> requests) {
        this.name = name;
        this.requests = requests;
    }

    public Mock() {
    }

    public Mock(String id, String name, List<Request> requests) {
        this.id = id;
        this.name = name;
        this.requests = requests;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
