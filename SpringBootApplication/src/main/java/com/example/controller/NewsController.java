package com.example.controller;

import com.example.dto.NewsDto;
import com.example.exception.NewsNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.services.NewsCRUDService;

import java.util.Collection;

@RestController
@RequestMapping("/api/news")
public class NewsController {
    private final NewsCRUDService newsCRUDService;

    public NewsController(NewsCRUDService newsCRUDService) {
        this.newsCRUDService = newsCRUDService;
    }

    @GetMapping("/{id}")
    public NewsDto getById(@PathVariable Long id) throws NewsNotFoundException {
        NewsDto dto = newsCRUDService.getById(id);
        if (dto != null) {
            return dto;
        } else {
            throw new NewsNotFoundException("Новость с Id " + id + " не найдена!");
        }
    }

    @GetMapping
    public Collection<NewsDto> getAll() {
        return newsCRUDService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NewsDto create(@RequestBody NewsDto newsDto) {
        newsCRUDService.create(newsDto);
        return newsDto;
    }

    @PutMapping("/{id}")
    public NewsDto update(@PathVariable Long id, @RequestBody NewsDto newsDto) {
        newsCRUDService.update(id, newsDto);
        return newsDto;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws NewsNotFoundException {
        NewsDto dto = newsCRUDService.getById(id);
        if (dto != null) {
            newsCRUDService.deleteById(id);
        } else {
            throw new NewsNotFoundException("Новость с Id " + id + " не найдена!");
        }
    }
}


