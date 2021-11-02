package com.example.mockserverspring.services.impl;

import com.example.mockserverspring.models.Mock;
import com.example.mockserverspring.models.Request;
import com.example.mockserverspring.repositories.MockRepository;
import com.example.mockserverspring.repositories.RequestQueryDao;
import com.example.mockserverspring.services.RequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RequestServiceImpl implements RequestService {


    private final Logger LOGGER = LoggerFactory.getLogger(getClass());


    @Autowired
    private RequestQueryDao requestQueryDao;

    @Autowired
    private MockRepository mockRepository;


    @Override
    public Object getResponseFrom(String method, String mockName, Map<String, Object> body, Map<String, String> params, String endPoint) {
        Mock mock = mockRepository.findByName(mockName);
        Map<String, Object> response = new HashMap<String, Object>();

        for (int i = 0; i < mock.getRequests().toArray().length; i++) {
            Request request = mock.getRequests().get(i);
            if (request.getMethod().equals(method) && request.getEndPoint().equals(endPoint) && request.getParams().equals(params) && request.getBody().equals(body)) {
                response = request.getResponse();
                return response;
            }
        }
        return null;
    }

    @Override
    public Object getResponseFromQuery(String method, String mockName, Map<String, Object> body, Map<String, String> params, String endPoint) {
        return requestQueryDao.getRequest(method, mockName, body, params, endPoint);
    }
}
