package com.example.springexample.controller;

import com.example.springexample.dto.CategoryDto;
import com.example.springexample.services.CategoryCRUDService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryCRUDService categoryCRUDService;

    @GetMapping("/{id}")
    public CategoryDto getById(@PathVariable Long id) {
        return categoryCRUDService.getById(id);
    }

    @GetMapping
    public Collection<CategoryDto> getAll() {
        return categoryCRUDService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryDto create(@RequestBody CategoryDto categoryDto) {
        categoryCRUDService.create(categoryDto);
        return categoryDto;
    }

    @PutMapping("/{id}")
    public CategoryDto update(@PathVariable Long id, @RequestBody CategoryDto categoryDto) {
        categoryCRUDService.update(id, categoryDto);
        return categoryDto;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        categoryCRUDService.deleteById(id);
    }
}
