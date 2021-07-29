package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AuthRequest;
import com.example.demo.util.JwtUtil;

@RestController
public class WelcomeController {
	
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@GetMapping("/")
	public String welcome() {
		return "Welcome Harish Yadav!!";	
	}
	//we used spring security it is applied for all the end points we need to disable to this authenticate end point
	//So we need to make changes got config class and override configurer method
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			//it is responsible for authenticating the user details
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
		);
		} catch(Exception ex) {
			throw new Exception("Invalid username/password");
		}
		return jwtUtil.generateToken(authRequest.getUserName());
		
	}

}
