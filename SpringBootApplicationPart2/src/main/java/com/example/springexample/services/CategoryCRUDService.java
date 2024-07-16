package com.example.springexample.services;

import com.example.springexample.dto.CategoryDto;
import com.example.springexample.entity.Category;
import com.example.springexample.exceptions.NotFoundException;
import com.example.springexample.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class CategoryCRUDService implements CRUDService<CategoryDto> {
    private final CategoryRepository categoryRepository;

    @Override
    public CategoryDto getById(Long id) throws NotFoundException {
        log.info("Get by Id " + id);
        if (categoryRepository.existsById(id)) {
            Category category = categoryRepository.findById(id).orElseThrow();
            return mapToDto(category);
        } else {
            throw new NotFoundException("Категория с Id " + id + " не найдена!");
        }
    }

    @Override
    public Collection<CategoryDto> getAll() {
        log.info("Get all");
        return categoryRepository.findAll().stream().map(CategoryCRUDService::mapToDto).toList();
    }

    @Override
    public void create(CategoryDto categoryDto) {
        log.info("Create");
        categoryRepository.save(mapToEntity(categoryDto));
    }

    @Override
    public void update(Long categoryId, CategoryDto categoryDto) {
        log.info("Update");
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (category.isPresent()) {
            Category existingCategory = category.get();
            existingCategory.setTitle(categoryDto.getTitle());
            categoryRepository.save(existingCategory);
        }
    }

    public void deleteById(Long id) {
        log.info("Delete by Id " + id);
        if (categoryRepository.findById(id).isPresent()) {
            categoryRepository.deleteById(id);
        } else {
            throw new NotFoundException("Категория с Id " + id + " не найдена!");
        }
    }

    public static CategoryDto mapToDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setTitle(category.getTitle());
        categoryDto.setNews(category.getNews());
        return categoryDto;
    }

    public static Category mapToEntity(CategoryDto categoryDto) {
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setTitle(categoryDto.getTitle());
        category.setNews(categoryDto.getNews());
        return category;
    }
}
