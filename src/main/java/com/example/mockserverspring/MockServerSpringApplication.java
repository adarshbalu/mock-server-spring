package com.example.mockserverspring;

import com.example.mockserverspring.models.Mock;
import com.example.mockserverspring.models.Request;
import com.example.mockserverspring.repositories.MockRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class MockServerSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(MockServerSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(MockRepository repository){
		return args -> {
			List<Request> requests = new ArrayList<Request>() ;
			Mock mock = new Mock( "Name",
			requests
					);
			repository.insert(mock);
		};
	}

}
