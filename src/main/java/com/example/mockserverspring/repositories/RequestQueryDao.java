package com.example.mockserverspring.repositories;

import java.util.Map;

public interface RequestQueryDao {
    Object getRequest(String method, String mockName, Map<String, Object> body, Map<String, String> params, String endPoint);

}
