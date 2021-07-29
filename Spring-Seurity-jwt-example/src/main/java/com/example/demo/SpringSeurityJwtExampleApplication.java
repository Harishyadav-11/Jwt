package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.UserRepo;
import com.example.demo.model.User;

@SpringBootApplication
public class SpringSeurityJwtExampleApplication {
	
	@Autowired
	private UserRepo repository;
	
	@PostConstruct
	public void initUsers() {
		List<User> users = Stream.of(
				new User(81,"Harish yadav","ParvathiDevi","hari@gmail.com"),
				new User(82,"Srinivasa yadav","Srinu123","srinu@gmail.com"),
				new User(83,"Jyothi yadav","Jyothi123","jyothi@gmail.com"),
				new User(84,"Bablu yadav","bablu","bablu@gmail.com")
				).collect(Collectors.toList());
		repository.saveAll(users);
				
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSeurityJwtExampleApplication.class, args);
	}

}
