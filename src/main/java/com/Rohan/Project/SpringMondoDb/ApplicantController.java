package com.Rohan.Project.SpringMondoDb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Rohan.Project.SpringMondoDb.Models.Applicants;
import com.Rohan.Project.SpringMondoDb.Services.ApplicantServices;

@RestController
@RequestMapping("/api")
public class ApplicantController {
	@Autowired
	 private ApplicantServices appServ;
	
	@GetMapping("/allapplicants")
	public List<Applicants> allapp(Applicants obj)
	{
	 return appServ.getAllApplicants();	
	}

}
