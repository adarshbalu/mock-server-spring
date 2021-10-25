package com.example.mockserverspring.repositories;

import com.example.mockserverspring.models.Mock;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MockRepository  extends MongoRepository<Mock,Integer> {
    Optional<Mock> findById(Integer id);
}
