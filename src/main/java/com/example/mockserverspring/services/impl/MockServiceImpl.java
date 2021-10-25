package com.example.mockserverspring.services.impl;

import com.example.mockserverspring.repositories.MockRepository;
import com.example.mockserverspring.services.MockService;
import org.springframework.beans.factory.annotation.Autowired;

public class MockServiceImpl implements MockService {
    @Autowired
   private MockRepository mockRepository;
}
