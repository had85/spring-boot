package com.example.springboot.creator;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.springboot.domain.RegistrationRequest;
import com.example.springboot.domain.Role;
import com.example.springboot.domain.User;
import com.example.springboot.domain.UserRequest;
import com.example.springboot.domain.Vacation;
import com.example.springboot.domain.VacationRequest;
import com.example.springboot.service.PasswordGeneratorService;

@Component
public class ConversionUtils {
	
	@Autowired
	private PasswordGeneratorService passwordGenerator;	
	
	public User convertRegistrationRequest(RegistrationRequest request) {		
		
		request.setUsername(request.getUsername().trim());
        request.setPassword(request.getPassword().trim());
		
		String passwordSalt   = passwordGenerator.createPasswordSalt();
		String hashedPassword = passwordGenerator.provideHashedPassword(request.getPassword(), passwordSalt);		
		
		Role role = Role.builder()
				    .name(request.getRole())
				    .build();
		
		User user = User.builder()
					.username(request.getUsername())
					.password(request.getPassword())
				    .passwordSalt(passwordSalt)
				    .hashedPassword(hashedPassword)					
					.address(request.getAddress())
					.name(request.getName())
					.email(request.getEmail())
					.role(role)
					.registrationTime(new Date())
					.build();	
		
		return user;
	}
	
	public User convertUserRequest(UserRequest request, String username) {
		
		User user = User.builder()
				    .username(username)
					.address(request.getAddress())
					.name(request.getName())
					.email(request.getEmail())
					.build();	
		
		return user;
	}	
	
	public Vacation convertVacationRequest(VacationRequest request, String username) {
		
		Vacation vacation = Vacation.builder()
					       .startDate(request.getStartDate())
					       .duration(request.getDuration())
					       .approval(request.getApproval())
					       .username(username)
					       .build();	
		
		return vacation;
	}
}
