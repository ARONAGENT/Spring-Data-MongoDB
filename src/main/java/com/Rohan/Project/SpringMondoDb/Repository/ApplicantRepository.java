package com.Rohan.Project.SpringMondoDb.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Rohan.Project.SpringMondoDb.Models.Applicants;

public interface ApplicantRepository extends MongoRepository<Applicants, Integer>{

}
