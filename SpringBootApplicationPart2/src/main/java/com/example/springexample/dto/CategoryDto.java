package com.example.springexample.dto;

import com.example.springexample.entity.News;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private Long id;
    private String title;
    @JsonIgnore
    private List<News> news = new ArrayList<>();
}

