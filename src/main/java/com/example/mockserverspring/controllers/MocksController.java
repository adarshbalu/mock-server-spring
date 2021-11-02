package com.example.mockserverspring.controllers;


import com.example.mockserverspring.models.Mock;
import com.example.mockserverspring.models.Request;
import com.example.mockserverspring.services.MockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/mocks")
public class MocksController {

    @Autowired
    private MockService mockService;

    // GET request to /mocks route - return all mock-servers in the db
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<Object> getAllMocks() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(mockService.getAllMockServer());
        } catch (Exception e) {
            final Map<String, Object> code = new HashMap<String, Object>();
            code.put("message", "failed to get mock-server list");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(code);
        }
    }

    // GET request to /mocks/{id} - returns mock associated with the provided id
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/{id}")
    public ResponseEntity<Object> getMock(@PathVariable String id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(mockService.getMock(id));
        } catch (Exception e) {
            final Map<String, Object> code = new HashMap<String, Object>();
            code.put("message", "failed to get mock server");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(code);

        }
    }

    // POST request to /mocks route - Add new mock-server to the db
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addNewMock(@RequestBody Mock mock) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(mockService.createNewMockServer(mock));
        } catch (Exception e) {
            final Map<String, Object> error = new HashMap<String, Object>();
            final Map<String, Object> code = new HashMap<String, Object>();
            code.put("name", "mockServerExitsError");
            code.put("message", "Mock server with the same name already exits");
            code.put("header", "No matching requests");
            error.put("error", code);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    // PUT request to /mocks to add new request to mock-server
    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseBody
    @RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.PUT,
            value = "/{id}"
    )
    public ResponseEntity<Object> addNewRequest(
            @PathVariable String id,
            @RequestBody Request request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(mockService.addNewRequest(request, id));
        } catch (Exception e) {
            final Map<String, Object> error = new HashMap<String, Object>();
            final Map<String, Object> code = new HashMap<String, Object>();
            code.put("name", "mockRequestCreateError");
            code.put("message", "Could not add request");
            code.put("header", "");
            error.put("error", code);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }


    // DELETE request to /mocks/{id}  to remove mocks with the provided id
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE
    )
    public ResponseEntity<Object> deleteMock(@PathVariable String id) {
        try {
            mockService.deleteMock(id);
            final Map<String, Object> code = new HashMap<String, Object>();
            code.put("message", "deleted");
            return ResponseEntity.status(HttpStatus.OK).body(code);
        } catch (Exception e) {
            final Map<String, Object> code = new HashMap<String, Object>();
            code.put("message", "error deleting mocker server");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(code);
        }
    }

    // DELETE request to /mocks/{id}/{requestID}  to remove requests mocks with the provided id
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(
            value = "/{id}/{requestID}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.DELETE
    )
    public ResponseEntity<Object> deleteRequest(@PathVariable String id, @PathVariable(name = "requestID") String requestId) {
        try {
            mockService.deleteRequest(id, requestId);
            final Map<String, Object> code = new HashMap<String, Object>();
            code.put("message", "deleted request");
            return ResponseEntity.status(HttpStatus.OK).body(code);

        } catch (Exception e) {
            final Map<String, Object> code = new HashMap<String, Object>();
            code.put("message", "error deleting request");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(code);
        }
    }
}
