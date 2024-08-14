package com.example.backend123blogg.services.impl;

import com.example.backend123blogg.dtos.admin.CategoryCreateDto;
import com.example.backend123blogg.dtos.admin.CategoryHomeDto;
import com.example.backend123blogg.dtos.admin.CategoryUpdateDto;
import com.example.backend123blogg.models.Category;
import com.example.backend123blogg.repository.CategoryRepository;
import com.example.backend123blogg.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class CategoryServiceImpl implements CategoryService {


    private CategoryRepository categoryRepository;
    private ModelMapper modelMapper;

    @Override
    public void createCategory(CategoryCreateDto categoryCreateDto) {
        Category category = new Category();
        category.setName(categoryCreateDto.getName());
        categoryRepository.save(category);
    }

    @Override
    public void updateCategory(CategoryUpdateDto categoryUpdateDto,Long id) {
        Category category=categoryRepository.findById(id).orElseThrow();
        category.setName(categoryUpdateDto.getName());
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        Category category=categoryRepository.findById(id).orElseThrow();
        categoryRepository.deleteById(id);
    }

    @Override
    public CategoryUpdateDto findUpdateCategory(Long id) {
        Category category=categoryRepository.findById(id).orElseThrow();
        CategoryUpdateDto result=modelMapper.map(category, CategoryUpdateDto.class);
        return result;
    }

    @Override
    public List<CategoryHomeDto> getHomeCategories() {
        List<CategoryHomeDto> categories=categoryRepository.findAll().stream().map(category->modelMapper.map(category,CategoryHomeDto.class)).toList();
        return categories;
    }

    @Override
    public Category findCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow();
    }


}
