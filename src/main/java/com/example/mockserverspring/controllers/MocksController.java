package com.example.mockserverspring.controllers;


import com.example.mockserverspring.models.Mock;
import com.example.mockserverspring.models.Request;
import com.example.mockserverspring.services.MockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path="/api")
public class MocksController {

    @Autowired
    private MockService mockService;
    //Get request to /mocks route
//    @GetMapping(path="/mocks")
//    public List<Mock> getAllMocks(){
//
//    }
}
