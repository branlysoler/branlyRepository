package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Employment;
import com.example.demo.Service.EmploymentService;

@RestController
@RequestMapping("api/employments")
public class EmploymentController {

    @Autowired
    private EmploymentService employmentService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Employment employment){
        final Employment employmentCreated = employmentService.create(employment);
        return ResponseEntity.status(HttpStatus.CREATED).body(employmentCreated);
    }
    
}