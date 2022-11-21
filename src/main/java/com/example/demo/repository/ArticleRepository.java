package com.example.demo.repository;

import com.example.demo.model.Article;
import com.example.demo.service.SimpleSlugService;
import com.example.demo.service.SlugService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class ArticleRepository {
    private List<Article> articles = new ArrayList<>();
    private final SlugService slugService;

    public ArticleRepository(@Qualifier("advancedSlugService") SlugService slugService){
        this.slugService = slugService;
        Map<Integer,String> articles = Map.of(
                1,"Hello, World!",
                2,"Spring Initializr",
                3,"Spring Dependency Injection"
        );
        for(Map.Entry<Integer,String> entry : articles.entrySet()){
            this.articles.add(new Article(
                    entry.getKey(),
                    entry.getValue(),
                    slugService.slugify(entry.getValue()),"TEST CONTENT",LocalDateTime.now()
            ));
        }
    }

    public List<Article> findAll() {
        return articles;
    }

    public Article findById(Integer id) {
        return articles.stream().filter(a -> a.id().equals(id)).findFirst().orElse(null);
    }

    /*public ArticleRepository() {
        articles = List.of(
                new Article(1,"Hello, World!","Welcome to my new Blog!", LocalDateTime.now()),
                new Article(2,"Spring Initializr","Get started with Spring Boot at start.spring.io",LocalDateTime.now()),
                new Article(3,"Spring Dependency Injection","An Introduction to Dependency Injection in Spring",LocalDateTime.now())
        );
    }*/



}
