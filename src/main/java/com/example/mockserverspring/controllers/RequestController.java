package com.example.mockserverspring.controllers;

import com.example.mockserverspring.services.RequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@ResponseBody
@RequestMapping(path = "/api")
public class RequestController {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    @Autowired
    private RequestService requestService;

    @RequestMapping(value = "/**", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> handleRequest(
            final HttpServletRequest request,
            @RequestParam(required = false) Map<String, String> allParams,
            @RequestBody(required = false) Map<String, Object> body) {

        if (allParams == null) {
            allParams = new HashMap<String, String>();
        }
        if (body == null) {
            body = new HashMap<String, Object>();
        }
        final String method = request.getMethod();

        final String requestEndpoint = request.getRequestURI();
        final String mockName = requestEndpoint.split("/api/")[1].split("/")[0];

        final String endPoint = requestEndpoint.split("/")[3];
        final Object response = requestService.getResponseFrom(method, mockName, body, allParams, endPoint);
        if (response == null) {
            final Map<String, Object> error = new HashMap<String, Object>();
            final Map<String, Object> code = new HashMap<String, Object>();
            code.put("name", "mockRequestNotFoundError");
            code.put("message", "Double check your method and the request path and try again.");
            code.put("header", "No matching requests");
            error.put("error", code);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }

    }

}
