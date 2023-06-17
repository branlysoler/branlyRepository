package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Records.CategoryRecord;
import com.example.demo.Service.CategoryService;

@RestController
@RequestMapping("api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CategoryRecord categoryRecord){
        final CategoryRecord categoryCreated = categoryService.create(categoryRecord);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryCreated);
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        final List<CategoryRecord> categoryRecords = categoryService.findAll();
        return ResponseEntity.ok(categoryRecords);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<CategoryRecord> categoryRecords = categoryService.findById(id);
        return ResponseEntity.ok(categoryRecords);
    }
    
}