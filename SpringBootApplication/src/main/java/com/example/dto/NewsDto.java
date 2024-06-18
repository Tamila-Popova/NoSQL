package com.example.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Setter
@Getter
@NoArgsConstructor
public class NewsDto {
    private Long id;
    private String title;
    private String text;
    private Instant date;
    public  NewsDto(Long id, String title, String text, Instant date){
        this.id = id;
        this.title=title;
        this.text=text;
        this.date=Instant.now();
    }
}
