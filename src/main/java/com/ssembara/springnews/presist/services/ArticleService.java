package com.ssembara.springnews.presist.services;

import java.util.List;
import java.util.Optional;

import com.ssembara.springnews.application.requests.v1.article.ArticleStore;
import com.ssembara.springnews.application.requests.v1.article.ArticleUpdate;
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

    public void storeArticle(ArticleStore storeArticle) {
        var newArticle = new Article();
        newArticle.setTitle(storeArticle.getTitle());
        newArticle.setDescription(storeArticle.getDescription());
        // newArticle.setAuthor(storeArticle.getAuthor());

        repo.save(newArticle);
    }

    public Optional<Article> showArticle(Long id) throws Exception {
        return repo.findById(id);
    }

    public void updateArticle(Long id, ArticleUpdate updateArticle) throws Exception {
        var oldArticle = repo.findById(id).orElseThrow(() -> new Exception("data not found"));
        oldArticle.setTitle(updateArticle.getTitle());
        oldArticle.setDescription(updateArticle.getDescription());

        repo.save(oldArticle);
    }

    public void destroyArticle(Long id) throws Exception {
        repo.deleteById(id);
    }
}
