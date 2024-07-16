package com.example.springexample.services;

import com.example.springexample.dto.NewsDto;
import com.example.springexample.entity.Category;
import com.example.springexample.entity.News;
import com.example.springexample.exceptions.NotFoundException;
import com.example.springexample.repositories.CategoryRepository;
import com.example.springexample.repositories.NewsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class NewsCRUDService implements CRUDService<NewsDto> {

    private final NewsRepository repository;
    private final CategoryRepository categoryRepository;

    @Override
    public NewsDto getById(Long id) throws NotFoundException {
        log.info("Get by Id " + id);
        if (repository.getById(id) != null) {
            News news = repository.findById(id).orElseThrow();
            return mapToDto(news);
        } else {
            throw new NotFoundException("Новость с Id " + id + " не найдена!");
        }
    }

    @Override
    public Collection<NewsDto> getAll() {
        log.info("Get all");
        return repository.findAll().stream().map(NewsCRUDService::mapToDto).collect(Collectors.toList());
    }

    @Override
    public void create(NewsDto newsDto) {
        log.info("Create");
        boolean categoryUnique = true;
        for (Category category : categoryRepository.findAll()) {
            if (category.getTitle().equals(newsDto.getCategory())) {
                categoryUnique = false;
                News news = mapToEntity(newsDto);
                news.setCategory(category);
                repository.save(news);
                break;
            }
        }
        if (categoryUnique) {
            Category myCategory = new Category();
            myCategory.setTitle(newsDto.getCategory());
            categoryRepository.save(myCategory);
            News news = mapToEntity(newsDto);
            news.setCategory(myCategory);
            repository.save(news);
        }
    }

    @Override
    public void update(Long newsId, NewsDto newsDto) {
        log.info("Update");
        Optional<News> news = repository.findById(newsId);
        if(news.isPresent()){
            boolean categoryUnique = true;
            for (Category category : categoryRepository.findAll()) {
                if (category.getTitle().equals(newsDto.getCategory())) {
                    categoryUnique = false;
                    News existingNews = news.get();
                    existingNews.setTitle(newsDto.getTitle());
                    existingNews.setCategory(category);
                    existingNews.setText(newsDto.getText());
                    repository.save(existingNews);
                    break;
                }
            }
            if (categoryUnique) {
                Category myCategory = new Category();
                myCategory.setTitle(newsDto.getCategory());
                categoryRepository.save(myCategory);
                News existingNews = news.get();
                existingNews.setTitle(newsDto.getTitle());
                existingNews.setCategory(myCategory);
                existingNews.setText(newsDto.getText());
                repository.save(existingNews);
            }

        }
    }

    public Collection<NewsDto> getNewsByCategory(Long categoryId) {
        List<NewsDto> newsList = new ArrayList<>();
        for (News news : repository.findAll()) {
            if (news.getCategory().getId() == categoryId.intValue()) {
                newsList.add(mapToDto(news));
            }
        }
        return newsList;
    }

    public void deleteById(Long id) throws NotFoundException {
        log.info("Delete by Id " + id);
        if (repository.getById(id) != null) {
            repository.deleteById(id);
        } else {
            throw new NotFoundException("Новость с Id " + id + " не найдена!");
        }
    }

    public static NewsDto mapToDto(News news) {
        NewsDto newsDto = new NewsDto();
        newsDto.setId(news.getId());
        newsDto.setText(news.getText());
        newsDto.setTitle(news.getTitle());
        newsDto.setDate(news.getDate());
        newsDto.setCategory(news.getCategory().getTitle());
        return newsDto;
    }

    public static News mapToEntity(NewsDto newsDto) {
        News news = new News();
        news.setId(newsDto.getId());
        news.setText(newsDto.getText());
        news.setTitle(newsDto.getTitle());
        news.setDate(newsDto.getDate());
        return news;
    }
}
