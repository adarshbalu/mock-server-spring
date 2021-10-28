package com.example.mockserverspring.repositories;

import com.example.mockserverspring.models.Mock;
import com.example.mockserverspring.models.Request;

import java.util.Map;

public interface RequestQueryDao {

    Mock getMockFromName(String name);

    Request getRequest(String method, String mockName, Map<String, Object> body, Map<String, String> params, String endPoint);
}
