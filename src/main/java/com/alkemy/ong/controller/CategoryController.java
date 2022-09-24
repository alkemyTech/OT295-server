package com.alkemy.ong.controller;

import com.alkemy.ong.domain.dto.CategoryBasicDTO;
import com.alkemy.ong.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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


}
