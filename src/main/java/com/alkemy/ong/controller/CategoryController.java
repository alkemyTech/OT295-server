package com.alkemy.ong.controller;

import com.alkemy.ong.domain.response.CategoryBasicResponse;
import com.alkemy.ong.domain.response.CategoryResponse;
import com.alkemy.ong.domain.response.CategoryResponsePage;
import com.alkemy.ong.exception.ErrorResponse;
import com.alkemy.ong.service.CategoryService;
import io.swagger.annotations.*;
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
    @ApiOperation(value = "Create a category and return it.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "CREATED - The category was successfully created",
                    response = CategoryResponse.class),
            @ApiResponse(code = 400, message = "INVALID_ARGUMENT - Certain arguments "
                    + "cannot be empty or null.",
                    response = ErrorResponse.class),
            @ApiResponse(code = 403, message = "PERMISSION_DENIED - Forbidden.",
                    response = ErrorResponse.class)})
    @ApiImplicitParam(name = "Authorization", value = "Access Token",
            required = true,
            allowEmptyValue = false,
            paramType = "header",
            dataTypeClass = String.class,
            example = "Bearer access_token")
    public ResponseEntity<CategoryResponse> save(@Valid @RequestBody CategoryResponse category) {
        CategoryResponse categorySaved = categoryService.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(categorySaved);
    }

    @PreAuthorize("hasAnyRole('ROLE_USER'),('ROLE_ADMIN')")
    @GetMapping(produces = {"application/json"})
    @ApiOperation(value = "Return the list of Categories")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK - The list of comments.",
                    response = CategoryBasicResponse.class),
            @ApiResponse(code = 403, message = "PERMISSION_DENIED - Forbidden.",
                    response = ErrorResponse.class)})
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "Authorization",
                    value = "Access Token",
                    required = true,
                    allowEmptyValue = false,
                    paramType = "header",
                    dataTypeClass = String.class,
                    example = "Bearer access_token")})
    public ResponseEntity<List<CategoryBasicResponse>> getAll() {
        List<CategoryBasicResponse> categories = categoryService.getAllCategories();
        return ResponseEntity.ok().body(categories);
    }

    @PreAuthorize("hasAnyRole('ROLE_USER'),('ROLE_ADMIN')")
    @GetMapping(value = "/page/{page}", produces = {"application/json"})
    @ApiOperation(value = "Returns the list of categories for multiple pages")
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
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "page", value = "Page of the list",
                    required = true,
                    paramType = "query",
                    dataTypeClass = String.class,
                    example = "0"),
            @ApiImplicitParam(name = "size",
                    value = "Size of the page",
                    required = false,
                    paramType = "query",
                    dataTypeClass = String.class,
                    example = "10"),
            @ApiImplicitParam(name = "Authorization",
                    value = "Access Token",
                    required = true,
                    allowEmptyValue = false,
                    paramType = "header",
                    dataTypeClass = String.class,
                    example = "Bearer access_token")})
    public ResponseEntity<CategoryResponsePage> getAll(@PathVariable Integer page) {
        CategoryResponsePage categories = categoryService.getAllCategories(page);
        return ResponseEntity.ok().body(categories);
    }

    @PreAuthorize("hasAnyRole('ROLE_USER'),('ROLE_ADMIN')")
    @GetMapping(value = "/{id}", produces = {"application/json"})
    @ApiOperation(value = "Get a category's details.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK - The category was found and it return their details",
                    response = CategoryResponse.class),
            @ApiResponse(code = 403, message = "PERMISSION_DENIED - Forbidden.",
                    response = ErrorResponse.class)})
    @ApiImplicitParam(name = "Authorization", value = "Access Token",
            required = true,
            allowEmptyValue = false,
            paramType = "header",
            dataTypeClass = String.class,
            example = "Bearer access_token")
    public ResponseEntity<CategoryResponse> getDetailsById(@PathVariable UUID id) {
        CategoryResponse categoryResponse = this.categoryService.getDetailsById(id);
        return ResponseEntity.ok(categoryResponse);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(value = "/{id}", produces = {"application/json"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete a category passed by id.")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "NO_CONTENT - The category was successfully deleted"),
            @ApiResponse(code = 403, message = "PERMISSION_DENIED - Forbidden.",
                    response = ErrorResponse.class),
            @ApiResponse(code = 404, message = "NOT_FOUND - Member not found.",
                    response = ErrorResponse.class)})
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id",
                    value = "Id of the category we want to delete",
                    required = true, allowEmptyValue = false,
                    paramType = "path", dataTypeClass = String.class,
                    example = "1"),
            @ApiImplicitParam(name = "Authorization",
                    value = "Access Token",
                    required = true,
                    allowEmptyValue = false,
                    paramType = "header",
                    dataTypeClass = String.class,
                    example = "Bearer access_token")})
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        this.categoryService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(value = "/{id}", produces = {"application/json"},
            consumes = {"application/json"})
    @ApiOperation(value = "Update a category passed by id.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK - The category was successfully updated"),
            @ApiResponse(code = 400, message = "INVALID_ARGUMENT - Certain arguments "
                    + "cannot be empty or null.",
                    response = ErrorResponse.class),
            @ApiResponse(code = 403, message = "PERMISSION_DENIED - Forbidden.",
                    response = ErrorResponse.class),
            @ApiResponse(code = 404, message = "NOT_FOUND - Member not found.",
                    response = ErrorResponse.class)})
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id",
                    value = "Id of the category we want to update",
                    required = true, allowEmptyValue = false,
                    paramType = "path", dataTypeClass = String.class,
                    example = "1"),
            @ApiImplicitParam(name = "Authorization",
                    value = "Access Token",
                    required = true,
                    allowEmptyValue = false,
                    paramType = "header",
                    dataTypeClass = String.class,
                    example = "Bearer access_token")})
    public ResponseEntity<CategoryResponse> update(@PathVariable UUID id, @RequestBody CategoryResponse category) {
        CategoryResponse result = this.categoryService.update(id, category);
        return ResponseEntity.ok().body(result);
    }


}
