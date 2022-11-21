package com.example.demo.controller;

import com.example.demo.model.Article;
import com.example.demo.repository.ArticleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    private final ArticleRepository articles;

    public ArticleController(ArticleRepository articles){
        this.articles = articles;
    }

    @GetMapping
    public List<Article> findAll() {
        return articles.findAll();
    }

    @GetMapping("/{id}")
    public Article findById(@PathVariable Integer id){
        return  articles.findById(id);
    }
}

