package com.example.springboot.service;

import java.util.Date;

import com.example.springboot.domain.Vacation;
import com.example.springboot.domain.VacationRequest;
import com.example.springboot.domain.VacationResponse;

public interface VacationService {
	
	VacationResponse createVacation(VacationRequest request, String username);
	
	Vacation getVacation(String username);
	
	VacationResponse updateVacation(Date startDate, int duration, String username);
	
	VacationResponse deleteVacation(String username);

}