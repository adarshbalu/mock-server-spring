package com.example.mockserverspring;


import com.example.mockserverspring.models.Mock;
import com.example.mockserverspring.repositories.MockRepository;
import com.example.mockserverspring.repositories.RequestRepository;
import com.example.mockserverspring.utils.HelperUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

@EnableMongoRepositories
@SpringBootApplication
public class MockServerSpringApplication {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    @Autowired
    private MockRepository mockRepository;
    
    @Autowired
    private RequestRepository requestRepository;

    public static void main(String[] args) {
        SpringApplication.run(MockServerSpringApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            LOGGER.info("Started");
            mockRepository.save(HelperUtil.supplySingleMock());

            List<Mock> mocksList = mockRepository.findAll();
            if (mocksList.size() == 0) {
                LOGGER.info("Database empty");
                mockRepository.save(HelperUtil.supplySingleMock());
            } else {
                LOGGER.info("Database not empty");
            }
        };
    }

}
