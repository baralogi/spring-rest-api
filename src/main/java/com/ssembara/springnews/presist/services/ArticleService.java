package com.ssembara.springnews.presist.services;

import java.util.List;

import com.ssembara.springnews.presist.models.Article;
import com.ssembara.springnews.presist.repositories.ArticleRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ArticleService {

    private ArticleRepository repo;

    public List<Article> getAll() {
        return repo.findAll();
    }

}
