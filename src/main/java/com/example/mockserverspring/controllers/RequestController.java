package com.example.mockserverspring.controllers;

import com.example.mockserverspring.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping(path = "/api")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @RequestMapping(value = "/**", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Object handleRequest(
            final HttpServletRequest request,
            @RequestParam(required = false) Map<String, String> allParams,
            @RequestBody(required = false) Map<String, Object> body) {

        final String method = request.getMethod().toLowerCase(Locale.ROOT);
        final String requestEndpoint = request.getRequestURI();
        final String mockName = requestEndpoint.split("/api/")[1].split("/")[0];
        final String endPoint = requestEndpoint.split("/")[3];


        return requestService.getResponseFrom(method, mockName, body, allParams, endPoint);

    }

}
