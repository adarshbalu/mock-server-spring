package com.example.mockserverspring.repositories.impl;

import com.example.mockserverspring.repositories.MockQueryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MockQueryDaoImpl implements MockQueryDao {
    @Autowired
    private MongoTemplate mongoTemplate;
}
