package com.example.mockserverspring.services;

import java.util.Map;

public interface RequestService {

    Object getResponseFrom(String method, String mockName, Map<String, Object> body, Map<String, String> params, String endPoint);

    Object getResponseFromQuery(String method, String mockName, Map<String, Object> body, Map<String, String> params, String endPoint);

}
