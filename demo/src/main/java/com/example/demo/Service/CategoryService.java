package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Mappers.CategoryMapper;
import com.example.demo.Records.CategoryRecord;
import com.example.demo.Repository.ICategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    public CategoryRecord create(CategoryRecord categoryRecord) {
        return categoryMapper.entityToDTO(iCategoryRepository.save(categoryMapper.dtoToEntity(categoryRecord)));
    }

    public List<CategoryRecord> findAll() {
        return categoryMapper.entityToDTO(iCategoryRepository.findAll());
    }

    public Optional<CategoryRecord> findById(Long id) {
        return iCategoryRepository.findById(id).map(categoryMapper::entityToDTO);
    }

}