package com.example.mockserverspring.services;

import com.example.mockserverspring.models.Mock;
import com.example.mockserverspring.models.Request;

import java.util.List;


public interface MockService {

    List<Mock> getAllMockServer();

    Mock createNewMockServer(Mock mock);

    Mock addNewRequest(Request request, String id) throws Exception;

    void deleteMock(String id);

    void deleteRequest(String id, String requestId) throws Exception;

    Mock getMock(String id) throws Exception;
}
