package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Employment;
import com.example.demo.Repository.IEmploymentRepository;

@Service
public class EmploymentService {

    @Autowired
    private IEmploymentRepository iEmploymentRepository;

    public Employment create(Employment employment){
        return iEmploymentRepository.save(employment);
    }
    
}