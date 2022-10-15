package com.alkemy.ong.controller;

import com.alkemy.ong.domain.dto.CategoryBasicDTO;
import com.alkemy.ong.domain.dto.CategoryDTO;
import com.alkemy.ong.domain.response.CategoryResponsePage;
import com.alkemy.ong.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<CategoryDTO> save(@Valid @RequestBody CategoryDTO category){
        CategoryDTO categorySaved = categoryService.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(categorySaved);

    }

    @PreAuthorize("hasAnyRole('ROLE_USER'),('ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<List<CategoryBasicDTO>> getAll(){
        List<CategoryBasicDTO> categories = categoryService.getAllCategories();
        return ResponseEntity.ok().body(categories);
    }

    @PreAuthorize("hasAnyRole('ROLE_USER'),('ROLE_ADMIN')")
    @GetMapping("/page/{page}")
    public ResponseEntity<CategoryResponsePage> getAll(@PathVariable Integer page){
        CategoryResponsePage categories = categoryService.getAllCategories(page);
        return ResponseEntity.ok().body(categories);
    }

    @PreAuthorize("hasAnyRole('ROLE_USER'),('ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getDetailsById(@PathVariable UUID id) {
        CategoryDTO categoryDTO = this.categoryService.getDetailsById(id);
        return ResponseEntity.ok(categoryDTO);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        this.categoryService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> update(@PathVariable UUID id, @RequestBody CategoryDTO category) {
        CategoryDTO result = this.categoryService.update(id, category);
        return ResponseEntity.ok().body(result);
    }


}
