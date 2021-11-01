package com.example.mockserverspring.repositories.impl;

import com.example.mockserverspring.repositories.RequestQueryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RequestQueryDaoImpl implements RequestQueryDao {
    @Autowired
    private MongoTemplate mongoTemplate;

//    @Override
//    public Mock getMockFromName(String name) {
//        Query query = new Query();
//        query.addCriteria(where("name").is(name));
//        return mongoTemplate.findOne(query, Mock.class);
//
//    }
//
//    @Override
//    public Object getRequest(String method, String mockName, Map<String, Object> body, Map<String, String> params, String endPoint) {
//
//        Criteria findMockCriteria = where("name").is(mockName);
//        Criteria findRequestCriteria = where("requests").elemMatch(
//                where("endPoint").is(endPoint)
//        ).andOperator(where("method").is(method));
//        BasicQuery query = new BasicQuery(findRequestCriteria.getCriteriaObject());
//
//        return mongoTemplate.findOne(query, Mock.class);
//    }
}
