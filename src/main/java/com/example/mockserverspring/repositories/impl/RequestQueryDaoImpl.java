package com.example.mockserverspring.repositories.impl;

import com.example.mockserverspring.models.Mock;
import com.example.mockserverspring.models.Request;
import com.example.mockserverspring.repositories.RequestQueryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class RequestQueryDaoImpl implements RequestQueryDao {
    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public Object getRequest(String method, String mockName, Map<String, Object> body, Map<String, String> params, String endPoint) {

        AggregationOperation checkMockName = Aggregation.match(Criteria.where("name").is(mockName));

        AggregationOperation unwind = Aggregation.unwind("requests");
        AggregationOperation replaceRoot = Aggregation.replaceRoot("requests");
        AggregationOperation matchMethod = Aggregation.match(Criteria.where("requests.method").is(method).andOperator(
                Criteria.where("requests.endPoint").is(endPoint),
                Criteria.where("requests.body").is(body),
                Criteria.where("requests.params").is(params)
        ));
        Aggregation aggregation = Aggregation.newAggregation(checkMockName, unwind, matchMethod, replaceRoot);
        List<Request> requests = mongoTemplate.aggregate(aggregation, mongoTemplate.getCollectionName(Mock.class), Request.class).getMappedResults();

        if (requests.isEmpty()) {
            return null;
        } else {
            return requests.get(0).getResponse();
        }
    }
}
