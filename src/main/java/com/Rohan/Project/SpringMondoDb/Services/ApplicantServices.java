package com.Rohan.Project.SpringMondoDb.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Rohan.Project.SpringMondoDb.Models.Applicants;
import com.Rohan.Project.SpringMondoDb.Repository.ApplicantRepository;

@Service
public class ApplicantServices {
	@Autowired
	 private ApplicantRepository appRepo;
	 
	 public List<Applicants> getAllApplicants()
	 {
	  return appRepo.findAll();
	 }
	 
	public Applicant addNewApplicant(Applicant a)
 	{
 	 	Calendar cal=Calendar.getInstance();
  		a.setApplydate(cal.getTime().toString());
  		return apprepo.save(a);
	}
	 
}
