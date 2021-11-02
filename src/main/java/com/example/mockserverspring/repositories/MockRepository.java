package com.example.mockserverspring.repositories;

import com.example.mockserverspring.models.Mock;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MockRepository extends MongoRepository<Mock, String> {
    Mock findByName(String mockName);

    void deleteById(String id);
    
    @Query("{ 'name' : ?0 }")
    List<Mock> findMockByName(String name);
}
