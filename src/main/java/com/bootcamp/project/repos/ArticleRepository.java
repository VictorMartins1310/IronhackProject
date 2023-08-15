package com.bootcamp.project.repos;

import com.bootcamp.project.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
