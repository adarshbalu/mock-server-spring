package com.example.mockserverspring.repositories;

import com.example.mockserverspring.models.Mock;
import com.example.mockserverspring.models.Request;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RequestRepository extends MongoRepository<Mock, String> {
    @Query(value = "{'name': ?1,'requests':{'$elemMatch':{'method': ?0,'mockName': ?1 , 'endPoint': ?4 }}}"
            , fields = "{'requests.$.':1}"
    )
    List<Request> getRequest(String method, String mockName, Map<String, Object> body, Map<String, String> params, String endPoint);

}
