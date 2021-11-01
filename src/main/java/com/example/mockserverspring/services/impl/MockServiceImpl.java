package com.example.mockserverspring.services.impl;

import com.example.mockserverspring.models.Mock;
import com.example.mockserverspring.models.Request;
import com.example.mockserverspring.repositories.MockRepository;
import com.example.mockserverspring.services.MockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MockServiceImpl implements MockService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    @Autowired
    private MockRepository mockRepository;

    @Override
    public List<Mock> getAllMockServer() {
        return mockRepository.findAll();
    }

    @Override
    public Mock createNewMockServer(Mock mock) {
        UUID uuid = UUID.randomUUID();
        mock.setId(uuid.toString());
        uuid = UUID.randomUUID();
        mock.getRequests().get(0).setId(uuid.toString());
        mock.getRequests().get(0).setMockName(mock.getName());
        return mockRepository.save(mock);
    }

    @Override
    public Mock addNewRequest(Request request, String id) throws Exception {
        Mock mockServer = mockRepository.findById(id).orElseThrow(() -> new Exception("Mock server not found for this id :: " + id));
        List<Request> allRequests = mockServer.getRequests();
        UUID uuid = UUID.randomUUID();
        request.setId(uuid.toString());
        request.setMockName(mockServer.getName());
        allRequests.add(request);
        mockServer.setRequests(allRequests);
        return mockRepository.save(mockServer);

    }

    @Override
    public void deleteMock(String id) {
        mockRepository.deleteById(id);
    }

    @Override
    public void deleteRequest(String id, String requestId) throws Exception {
        Mock mockServer = mockRepository.findById(id).orElseThrow(() -> new Exception("Mock server not found for this id :: " + id));
        List<Request> allRequests = mockServer.getRequests();
        for (Request r : allRequests) {
            if (r.getId().equals(requestId)) {
                allRequests.remove(r);
                LOGGER.info("Deleted");
                break;
            }
        }
        mockServer.setRequests(allRequests);
        mockRepository.save(mockServer);
    }

    @Override
    public Mock getMock(String id) throws Exception {
        return mockRepository.findById(id).orElseThrow(() -> new Exception("Mock server not found for this id :: " + id));
    }
}
