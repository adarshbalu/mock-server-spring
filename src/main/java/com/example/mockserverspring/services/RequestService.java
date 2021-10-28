package com.example.mockserverspring.services;

import java.util.Map;

public interface RequestService {
    Object getResponse(String name);

    Object getResponseFrom(String method, String mockName, Map<String, Object> body, Map<String, String> params, String endPoint);
}
