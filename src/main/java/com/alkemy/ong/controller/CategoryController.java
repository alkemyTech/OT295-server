package com.alkemy.ong.controller;

import com.alkemy.ong.domain.dto.CategoryBasicDTO;
import com.alkemy.ong.domain.dto.CategoryDTO;
import com.alkemy.ong.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDTO> save(@Valid @RequestBody CategoryDTO category){
        CategoryDTO categorySaved = categoryService.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(categorySaved);

    }

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
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        this.categoryService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
