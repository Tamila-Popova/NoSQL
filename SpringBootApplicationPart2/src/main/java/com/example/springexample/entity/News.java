package com.example.springexample.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "news")
@Data
public class News {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "text")
    private String text;
    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;
    @CreationTimestamp
    @Column(name = "creation_date")
    private LocalDateTime date;
}
