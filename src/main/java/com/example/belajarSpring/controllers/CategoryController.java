package com.example.belajarSpring.controllers;


import ch.qos.logback.core.encoder.EchoEncoder;
import com.example.belajarSpring.models.dto.request.CategoryRequest;
import com.example.belajarSpring.models.dto.response.CategoryResponse;
import com.example.belajarSpring.repositories.CategoryRepository;
import com.example.belajarSpring.services.category.CategoryService;
import com.example.belajarSpring.validators.CategoryValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CategoryValidator categoryValidator;
    private CategoryResponse categoryResponse;

    @Autowired
    private CategoryRepository categoryRepository;


    @GetMapping
    public ResponseEntity<?> getCategory() {
        try {
            categoryResponse = categoryService.readCategory();
            return ResponseEntity.ok().body(categoryResponse);
        } catch (Exception e) {
            e.printStackTrace();
            categoryResponse = new CategoryResponse(500, e.getMessage(), null);
            return ResponseEntity.status(categoryResponse.getStatus()).body(categoryResponse);
        }
    }
    @PostMapping
    public ResponseEntity<?> addCategory(@RequestBody CategoryRequest request){
        try{
            categoryResponse = categoryService.createCategory(request);
            return ResponseEntity.status(categoryResponse.getStatus()).body(categoryResponse);
        } catch (Exception e){
            e.printStackTrace();
            categoryResponse = new CategoryResponse(500, e.getLocalizedMessage(), null);
            return ResponseEntity.status(categoryResponse.getStatus()).body(categoryResponse);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @RequestBody CategoryRequest request){
        try {
            categoryResponse = categoryService.updateCategory(id, request);
            return ResponseEntity.status(categoryResponse.getStatus()).body(categoryResponse);
        } catch (Exception e) {
            e.printStackTrace();
            categoryResponse = new CategoryResponse(500, e.getMessage(), null);
            return ResponseEntity.status(categoryResponse.getStatus()).body(categoryResponse);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id){
        try{
            categoryResponse = categoryService.deleteCategory(id);
            return ResponseEntity.ok().body(categoryResponse);
        } catch (Exception e){
            e.printStackTrace();
            categoryResponse = new CategoryResponse(500, e.getMessage(), null);
            return ResponseEntity.status(categoryResponse.getStatus()).body(categoryResponse);
        }
    }
}
