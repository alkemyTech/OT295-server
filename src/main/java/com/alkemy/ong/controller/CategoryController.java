package com.alkemy.ong.controller;

import com.alkemy.ong.domain.dto.CategoryBasicDTO;
import com.alkemy.ong.domain.dto.CategoryDTO;
import com.alkemy.ong.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryBasicDTO>> getAll(){
        List<CategoryBasicDTO> categories = categoryService.getAllCategories();
        return ResponseEntity.ok().body(categories);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getDetailsById(@PathVariable UUID id) {
        CategoryDTO categoryDTO = this.categoryService.getDetailsById(id);
        return ResponseEntity.ok(categoryDTO);
    }


}
