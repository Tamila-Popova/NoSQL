package com.example.services;

import com.example.dto.NewsDto;
import com.example.exception.NewsNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collection;
import java.util.TreeMap;

@Service
public class NewsCRUDService implements CRUDService<NewsDto> {
    private final TreeMap<Long, NewsDto> storage = new TreeMap<>();

    @Override
    public NewsDto getById(Long id) throws NewsNotFoundException {
       NewsDto dto = storage.get(id);
        if (dto != null) {
            return dto;
        } else {
            throw new NewsNotFoundException("Новость с Id " + id + " не найдена!");
        }
    }

    @Override
    public Collection<NewsDto> getAll() {
        return storage.values();
    }

    @Override
    public void create(NewsDto news) {
        long nextId = (storage.isEmpty() ? 0 : storage.lastKey()) + 1;
        news.setId(nextId);
        news.setDate(Instant.now());
        storage.put(nextId, news);
    }

    @Override
    public void update(Long id, NewsDto item) {
        if (!storage.containsKey(id)) {
            return;
        }
        item.setDate(Instant.now());
        storage.put(id, item);
    }

        public void deleteById(Long id) throws NewsNotFoundException {
            NewsDto dto = storage.get(id);
            if (dto != null) {
                storage.remove(id);
            } else {
                throw new NewsNotFoundException("Новость с Id " + id + " не найдена!");
            }
    }
}
