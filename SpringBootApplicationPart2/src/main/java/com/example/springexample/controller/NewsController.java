package com.example.springexample.controller;

import com.example.springexample.dto.NewsDto;
import com.example.springexample.services.NewsCRUDService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/news")
@RequiredArgsConstructor
public class NewsController {
    private final NewsCRUDService newsCRUDService;

    @GetMapping("/{id}")
    public NewsDto getById(@PathVariable Long id) {
        return newsCRUDService.getById(id);
    }

    @GetMapping
    public Collection<NewsDto> getAll() {
        return newsCRUDService.getAll();
    }

    @GetMapping("/category/{id}")
    public Collection<NewsDto> getNewsByCategory(@PathVariable Long id) {
        return newsCRUDService.getNewsByCategory(id);
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
    public void deleteById(@PathVariable Long id) {
        newsCRUDService.deleteById(id);
    }
}
