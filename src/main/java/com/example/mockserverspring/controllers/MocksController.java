package com.example.mockserverspring.controllers;


import com.example.mockserverspring.models.Mock;
import com.example.mockserverspring.models.Request;
import com.example.mockserverspring.services.MockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/mocks")
public class MocksController {

    @Autowired
    private MockService mockService;

    // GET request to /mocks route - return all mock-servers in the db
    @GetMapping
    public List<Mock> getAllMocks() {
        return mockService.getAllMockServer();
    }

    // GET request to /mocks/{id} - returns mock associated with the provided id
    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/{id}")
    public Mock getMock(@PathVariable String id) {
        try {
            return mockService.getMock(id);
        } catch (Exception e) {
            return null;
        }
    }

    // POST request to /mocks route - Add new mock-server to the db
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Mock addNewMock(@RequestBody Mock mock) {
        return mockService.createNewMockServer(mock);
    }

    // PUT request to /mocks to add new request to mock-server
    @ResponseBody
    @RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.PUT,
            value = "/{id}"
    )
    public List<Request> addNewRequest(
            @PathVariable String id,
            @RequestBody Request request) {
        try {
            return mockService.addNewRequest(request, id);
        } catch (Exception e) {
            return null;
        }
    }


    // DELETE request to /mocks/{id}  to remove mocks with the provided id
    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE
    )
    public String deleteMock(@PathVariable String id) {
        try {
            mockService.deleteMock(id);
            return "Deleted";
        } catch (Exception e) {
            return null;
        }
    }

    // DELETE request to /mocks/{id}/{requestID}  to remove requests mocks with the provided id
    @RequestMapping(
            value = "/{id}/{requestID}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.DELETE
    )
    public String deleteRequest(@PathVariable String id, @PathVariable(name = "requestID") String requestId) {
        try {
            mockService.deleteRequest(id, requestId);
            return "Deleted request";
        } catch (Exception e) {
            return null;
        }
    }
}
