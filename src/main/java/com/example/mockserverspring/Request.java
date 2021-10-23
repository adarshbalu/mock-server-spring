package com.example.mockserverspring;

import java.util.HashMap;

public class Request {
    private int id;
    private int status;
    private String method;
    private String endPoint;
    private String mockName;
    private HashMap<String,Object> response;
    private HashMap<String,Object> body;
    private HashMap<String,Object> params;
}
