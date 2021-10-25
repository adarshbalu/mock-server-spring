package com.example.mockserverspring.repositories.impl;

import com.example.mockserverspring.repositories.MockQueryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class MockQueryDaoImpl implements MockQueryDao {
    @Autowired
    private MongoTemplate mongoTemplate;
}
