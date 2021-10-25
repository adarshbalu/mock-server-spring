package com.example.mockserverspring.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;


public class Request {
    @Id
    private int id;

    public Request(int status, String method, String endPoint, String mockName, HashMap<String, Object> response, HashMap<String, Object> body, HashMap<String, Object> params) {
        this.status = status;
        this.method = method;
        this.endPoint = endPoint;
        this.mockName = mockName;
        this.response = response;
        this.body = body;
        this.params = params;
    }

    public Request(int id, int status, String method, String endPoint, String mockName, HashMap<String, Object> response, HashMap<String, Object> body, HashMap<String, Object> params) {
        this.id = id;
        this.status = status;
        this.method = method;
        this.endPoint = endPoint;
        this.mockName = mockName;
        this.response = response;
        this.body = body;
        this.params = params;
    }

    private int status;
    private String method;
    private String endPoint;
    private String mockName;
    private HashMap<String,Object> response;
    private HashMap<String,Object> body;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getMockName() {
        return mockName;
    }

    public void setMockName(String mockName) {
        this.mockName = mockName;
    }

    public HashMap<String, Object> getResponse() {
        return response;
    }

    public void setResponse(HashMap<String, Object> response) {
        this.response = response;
    }

    public HashMap<String, Object> getBody() {
        return body;
    }

    public void setBody(HashMap<String, Object> body) {
        this.body = body;
    }

    public HashMap<String, Object> getParams() {
        return params;
    }

    public void setParams(HashMap<String, Object> params) {
        this.params = params;
    }

    private HashMap<String,Object> params;
}
