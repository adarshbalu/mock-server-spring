package com.example.mockserverspring.services.impl;

import com.example.mockserverspring.repositories.RequestQueryDao;
import com.example.mockserverspring.repositories.RequestRepository;
import com.example.mockserverspring.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private RequestQueryDao requestQueryDao;

    @Override
    public Object getResponse(String name) {
        return "requestRepository.getResponse(name)";
    }

    @Override
    public Object getResponseFrom(String method, String mockName, Map<String, Object> body, Map<String, String> params, String endPoint) {
        return requestQueryDao.getRequest(method, mockName, body, params, endPoint);
    }
}
