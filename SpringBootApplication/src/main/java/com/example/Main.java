package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);
        System.out.println("Hello");
        String[] beanNames = context.getBeanDefinitionNames();
        System.out.println("кол-во бинов " + beanNames.length);
    }
}
