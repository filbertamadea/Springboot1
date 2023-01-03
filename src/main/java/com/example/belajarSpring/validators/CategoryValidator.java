package com.example.belajarSpring.validators;

import com.example.belajarSpring.models.entitiy.Category;
import com.example.belajarSpring.models.entitiy.User;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CategoryValidator {
    public void validateCategoryNotFound(Optional<Category> categoryFind) throws Exception {
        if (categoryFind.isEmpty()) {
            throw new Exception("Category is not found!");
        }
    }

    public void validateCategoryIsDeleted(Category category) throws Exception {
        if (category.getDeleted()) {
            throw new Exception("Category is already deleted!");
        }
    }
}
