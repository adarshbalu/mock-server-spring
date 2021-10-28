package com.example.mockserverspring.models;

import org.springframework.data.annotation.Id;

import java.util.Map;


public class Request {

    @Id
    private String id;
    private int status;
    private String method;
    private String endPoint;
    private String mockName;
    private Map<String, Object> response;
    private Map<String, Object> body;
    private Map<String, String> params;

    public Request() {
    }

    public Request(int status, String method, String endPoint, String mockName, Map<String, Object> response, Map<String, Object> body, Map<String, String> params) {
        this.status = status;
        this.method = method;
        this.endPoint = endPoint;
        this.mockName = mockName;
        this.response = response;
        this.body = body;
        this.params = params;
    }

    public Request(String method, String endPoint, String mockName, Map<String, Object> body, Map<String, String> params) {
        this.body = body;
        this.params = params;
        this.method = method;
        this.endPoint = endPoint;
        this.mockName = mockName;
    }

    public Request(String id, int status, String method, String endPoint, String mockName, Map<String, Object> response, Map<String, Object> body, Map<String, String> params) {
        this.id = id;
        this.status = status;
        this.method = method;
        this.endPoint = endPoint;
        this.mockName = mockName;
        this.response = response;
        this.body = body;
        this.params = params;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Map<String, Object> getResponse() {
        return response;
    }

    public void setResponse(Map<String, Object> response) {
        this.response = response;
    }

    public Map<String, Object> getBody() {
        return body;
    }

    public void setBody(Map<String, Object> body) {
        this.body = body;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }
}
