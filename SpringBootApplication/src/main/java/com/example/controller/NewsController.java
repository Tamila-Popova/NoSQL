package com.example.controller;

import com.example.dto.NewsDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.services.NewsCRUDService;

import javax.swing.event.HyperlinkEvent;
import java.awt.desktop.SystemEventListener;
import java.util.Collection;

@RestController
@RequestMapping("/api/news")
public class NewsController {
    private final NewsCRUDService newsCRUDService;

    public NewsController(NewsCRUDService newsCRUDService) {
        this.newsCRUDService = newsCRUDService;
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        if(newsCRUDService.getById(id) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Новость с ID " + id + " не найдена");
        }
        newsCRUDService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(newsCRUDService.getById(id));
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
    public ResponseEntity deleteById(@PathVariable Long id) {
        if(newsCRUDService.getById(id) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Новость с ID " + id + " не найдена");
        }
        newsCRUDService.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}

