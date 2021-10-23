package com.example.mockserverspring;

import java.util.List;

public class Mock {
    private int id;
    private String name;
    private List<Integer> requests;

    public Mock(int id, String name, List<Integer> requests) {
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

    public List<Integer> getRequests() {
        return requests;
    }

    public void setRequests(List<Integer> requests) {
        this.requests = requests;
    }
}
