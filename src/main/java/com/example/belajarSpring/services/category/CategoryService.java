package com.example.belajarSpring.services.category;

import com.example.belajarSpring.models.dto.request.CategoryRequest;
import com.example.belajarSpring.models.dto.response.CategoryResponse;

public interface CategoryService {

    CategoryResponse createCategory(CategoryRequest request);
    CategoryResponse readCategory();
    CategoryResponse updateCategory(Long id, CategoryRequest request) throws Exception;
    CategoryResponse deleteCategory(Long id) throws Exception;

}
