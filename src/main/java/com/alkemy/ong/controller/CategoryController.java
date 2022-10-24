package com.alkemy.ong.controller;

import com.alkemy.ong.domain.request.CategoryRequest;
import com.alkemy.ong.domain.response.CategoryBasicResponse;
import com.alkemy.ong.domain.response.CategoryResponse;
import com.alkemy.ong.domain.response.CategoryResponsePage;
import com.alkemy.ong.exception.ErrorResponse;
import com.alkemy.ong.service.CategoryService;
import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Api(tags = "Category Endpoints", value = "CategoryEndpoints")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(produces = {"application/json"},
            consumes = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a category and return it.",description = "This endpoint creation of category")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "CREATED - The category was successfully created",
                    response = CategoryResponse.class),
            @ApiResponse(code = 400, message = "INVALID_ARGUMENT - Certain arguments "
                    + "cannot be empty or null.",
                    response = ErrorResponse.class),
            @ApiResponse(code = 403, message = "PERMISSION_DENIED - Forbidden.",
                    response = ErrorResponse.class)})
    public ResponseEntity<CategoryResponse> save(@Valid @RequestBody CategoryRequest category) {
        CategoryResponse categorySaved = categoryService.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(categorySaved);
    }

    @PreAuthorize("hasAnyRole('ROLE_USER'),('ROLE_ADMIN')")
    @GetMapping(produces = {"application/json"})
    @Operation(summary = "Return the list of Categories",description = "This endpoint get all a categories")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK - The list of comments.",
                    response = CategoryBasicResponse.class),
            @ApiResponse(code = 403, message = "PERMISSION_DENIED - Forbidden.",
                    response = ErrorResponse.class)})
    public ResponseEntity<List<CategoryBasicResponse>> getAll() {
        List<CategoryBasicResponse> categories = categoryService.getAllCategories();
        return ResponseEntity.ok().body(categories);
    }

    @PreAuthorize("hasAnyRole('ROLE_USER'),('ROLE_ADMIN')")
    @GetMapping(value = "/page/{page}", produces = {"application/json"})
    @Operation(summary = "Returns the list of categories for multiple pages",description = "This endpoint page all of categories")
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "OK - The list of categories. "
                            + "The size of the page is the one passed in the parameters",
                    response = CategoryResponsePage.class, responseHeaders = {
                    @ResponseHeader(name = "Link",
                            description = "Link of the previous page and another for the next page",
                            response = String.class)}),
            @ApiResponse(code = 403, message = "PERMISSION_DENIED - Forbidden.",
                    response = ErrorResponse.class)})
    public ResponseEntity<CategoryResponsePage> getAll(@PathVariable @Schema(example = "1") Integer page) {
        CategoryResponsePage categories = categoryService.getAllCategories(page);
        return ResponseEntity.ok().body(categories);
    }

    @PreAuthorize("hasAnyRole('ROLE_USER'),('ROLE_ADMIN')")
    @GetMapping(value = "/{id}", produces = {"application/json"})
    @Operation(summary = "Get a category's details.",description = "This endpoint get category's details")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK - The category was found and it return their details",
                    response = CategoryResponse.class),
            @ApiResponse(code = 403, message = "PERMISSION_DENIED - Forbidden.",
                    response = ErrorResponse.class)})
    public ResponseEntity<CategoryResponse> getDetailsById(@PathVariable @Schema(example = "3fa85f64-5717-4562-b3fc-2c963f66afa6") UUID id) {
        CategoryResponse categoryResponse = this.categoryService.getDetailsById(id);
        return ResponseEntity.ok(categoryResponse);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(value = "/{id}", produces = {"application/json"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a category passed by id.",description = "This endpoint get category's id")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "NO_CONTENT - The category was successfully deleted"),
            @ApiResponse(code = 403, message = "PERMISSION_DENIED - Forbidden.",
                    response = ErrorResponse.class),
            @ApiResponse(code = 404, message = "NOT_FOUND - Member not found.",
                    response = ErrorResponse.class)})
    public ResponseEntity<Void> delete(@PathVariable @Schema(example = "3fa85f64-5717-4562-b3fc-2c963f66afa6") UUID id) {
        this.categoryService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(value = "/{id}", produces = {"application/json"},
            consumes = {"application/json"})
    @Operation(summary = "Update a category passed by id.",description = "This endpoint update category's")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK - The category was successfully updated"),
            @ApiResponse(code = 400, message = "INVALID_ARGUMENT - Certain arguments "
                    + "cannot be empty or null.",
                    response = ErrorResponse.class),
            @ApiResponse(code = 403, message = "PERMISSION_DENIED - Forbidden.",
                    response = ErrorResponse.class),
            @ApiResponse(code = 404, message = "NOT_FOUND - Member not found.",
                    response = ErrorResponse.class)})
    public ResponseEntity<CategoryResponse> update(@PathVariable @Schema(example = "3fa85f64-5717-4562-b3fc-2c963f66afa6") UUID id, @RequestBody CategoryRequest category) {
        CategoryResponse result = this.categoryService.update(id, category);
        return ResponseEntity.ok().body(result);
    }


}
