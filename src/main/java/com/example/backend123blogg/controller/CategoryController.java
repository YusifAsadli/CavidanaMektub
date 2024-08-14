package com.example.backend123blogg.controller;

import com.example.backend123blogg.dtos.admin.CategoryCreateDto;
import com.example.backend123blogg.dtos.admin.CategoryHomeDto;
import com.example.backend123blogg.dtos.admin.CategoryUpdateDto;
import com.example.backend123blogg.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CategoryController {

private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/dashboard/category")
    public String dashboardCategory(Model model) {
        List<CategoryHomeDto> data=categoryService.getHomeCategories();
        model.addAttribute("categories", data);
        return"/dashboard/category/inxdex";
    }
    @GetMapping("/dashboard/category/create")
    public String createCategory(Model model) {
        return "/dashboard/category/create";
    }
    @PostMapping("/dashboard/category/create")
    public String createCategory(CategoryCreateDto categoryCreateDto) {
    categoryService.createCategory(categoryCreateDto);
    return "redirect:/dashboard/category";
    }
    @GetMapping("/dashboard/category/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
    return "/dashboard/category/delete";
    }
    @PostMapping("/dashboard/category/delete/{id}")
    public String RemoveCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return "redirect:/dashboard/category";
    }
    @GetMapping("/dashboard/category/update/{id}")
    public String updateCategory(@PathVariable Long id, Model model) {
        CategoryUpdateDto category = categoryService.findUpdateCategory(id);
        model.addAttribute("category", category);
        return "/dashboard/category/update";
    }
    @PostMapping("/dashboard/category/update/{id}")
    public String updateCategory(@PathVariable Long id, CategoryUpdateDto categoryUpdateDto) {
        categoryService.updateCategory(categoryUpdateDto,id);
        return "redirect:/dashboard/category";

    }

}













