package com.example.controller;

import com.example.dto.InfoDto;
import com.example.dto.NewsDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<InfoDto> getById(@PathVariable Long id) {
        String message = "Новость с ID " + id + " не найдена";
        InfoDto infoDto = new InfoDto(message);
        if(newsCRUDService.getById(id) == null){
            return new ResponseEntity(infoDto, HttpStatus.NOT_FOUND);
        }
        newsCRUDService.getById(id);
        return new ResponseEntity(newsCRUDService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public Collection<NewsDto> getAll() {
        return newsCRUDService.getAll();
    }

    @PostMapping
    public ResponseEntity create(@RequestBody NewsDto newsDto) {
        newsCRUDService.create(newsDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newsDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody NewsDto newsDto) {
        newsCRUDService.update(id, newsDto);
        return ResponseEntity.status(HttpStatus.OK).body(newsDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<InfoDto> deleteById(@PathVariable Long id) {
        String message = "Новость с ID " + id + " не найдена";
        InfoDto infoDto = new InfoDto(message);
        if(newsCRUDService.getById(id) == null){
            return new ResponseEntity(infoDto, HttpStatus.NOT_FOUND);
        }
        newsCRUDService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

