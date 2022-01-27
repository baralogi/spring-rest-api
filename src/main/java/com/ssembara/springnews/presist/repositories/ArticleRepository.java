package com.ssembara.springnews.presist.repositories;

import com.ssembara.springnews.presist.models.Article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

}
