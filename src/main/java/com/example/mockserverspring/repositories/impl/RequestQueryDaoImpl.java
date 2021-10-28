package com.example.mockserverspring.repositories.impl;

import com.example.mockserverspring.models.Mock;
import com.example.mockserverspring.models.Request;
import com.example.mockserverspring.repositories.RequestQueryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class RequestQueryDaoImpl implements RequestQueryDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Mock getMockFromName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        return mongoTemplate.findOne(query, Mock.class);

    }

    @Override
    public Request getRequest(String method, String mockName, Map<String, Object> body, Map<String, String> params, String endPoint) {
        Query query = new Query();
//        query.addCriteria(Criteria.where("method").is("get"));
//        query.addCriteria(Criteria.where("mockName").is("tester"));
        Mock mockServer = getMockFromName(mockName);
        Request req = new Request(method, mockName, endPoint, body, params);

//        query.addCriteria(Criteria.where("requests"));
        List<Request> requests = mockServer.getRequests();

//        query.addCriteria(Criteria.where("endPoint").is("api"));
//        query.addCriteria(Criteria.where("body").is(body));
//        query.addCriteria(Criteria.where("params").is(params));
        return requests.get(0);
    }
}
