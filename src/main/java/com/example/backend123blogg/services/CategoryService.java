package com.example.backend123blogg.services;

import com.example.backend123blogg.dtos.admin.CategoryCreateDto;
import com.example.backend123blogg.dtos.admin.CategoryHomeDto;
import com.example.backend123blogg.dtos.admin.CategoryUpdateDto;
import com.example.backend123blogg.models.Category;

import java.util.List;

public interface CategoryService {
void createCategory(CategoryCreateDto categoryCreateDto);
void updateCategory(CategoryUpdateDto categoryUpdateDto,Long id);
void deleteCategory(Long id);
CategoryUpdateDto findUpdateCategory(Long id);
List<CategoryHomeDto> getHomeCategories();
Category findCategoryById(Long id);
}
