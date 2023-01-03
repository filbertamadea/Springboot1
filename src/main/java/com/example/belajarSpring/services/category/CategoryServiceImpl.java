package com.example.belajarSpring.services.category;

import com.example.belajarSpring.models.dto.request.CategoryRequest;
import com.example.belajarSpring.models.dto.response.CategoryResponse;
import com.example.belajarSpring.models.entitiy.Category;
import com.example.belajarSpring.repositories.CategoryRepository;
import com.example.belajarSpring.validators.CategoryValidator;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryValidator categoryValidator;
    private Category category;
    private List<Category> categories;
    private CategoryResponse categoryResponse;

    @Override
    public CategoryResponse createCategory(CategoryRequest request) {
        if(request.getNamaKategori() == null){
            categoryResponse = new CategoryResponse(400, "Request tidak bisa dilakukan", null);
        } else {
            category = new Category();
            category.setNamaKategori(request.getNamaKategori());

            categoryRepository.save(category);

            categoryResponse = new CategoryResponse(HttpStatus.CREATED.value(), "sukses dibuat", category);
        }
        return categoryResponse;
    }

    @Override
    public CategoryResponse readCategory() {
        categories = categoryRepository.findAll();
        categoryResponse = new CategoryResponse(200, "Sukses", categories);
        return categoryResponse;
    }

    @Override
    public CategoryResponse updateCategory(Long id, CategoryRequest request) throws Exception {
        Optional<Category> categoryFind = categoryRepository.findById(id);

        category = categoryFind.get();
        category.setNamaKategori(request.getNamaKategori());

        categoryRepository.save(category);
        categoryResponse = new CategoryResponse(200, "sukses di-update", category);
        return categoryResponse;
    }

    @Override
    public CategoryResponse deleteCategory(Long id) throws Exception {
        Optional<Category> categoryFind = categoryRepository.findById(id);
        categoryValidator.validateCategoryNotFound(categoryFind);

        category = categoryFind.get();
        categoryValidator.validateCategoryIsDeleted(category);

        category.setDeleted(true);
        categoryRepository.save(category);
        categoryResponse = new CategoryResponse(200, "Category telah didelete", category);
        return categoryResponse;
    }
}
