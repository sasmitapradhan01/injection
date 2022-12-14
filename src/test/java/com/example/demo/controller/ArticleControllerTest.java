package com.example.demo.controller;

import com.example.demo.model.Article;
import com.example.demo.repository.ArticleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@WebMvcTest(ArticleController.class)
class ArticleControllerTest {

    ArticleController controller;

    @MockBean
    ArticleRepository repository;

    List<Article> articles = new ArrayList<>();

    @BeforeEach
    void setUp(){
        controller = new ArticleController(repository);
        articles = List.of(new Article(1,"Hello World!","hello-world","Welcome to my Blog!", LocalDateTime.now()));
    }

    @Test
    void shouldReturnAllArticles() {
        when(repository.findAll()).thenReturn(articles);
        assertEquals(3,controller.findAll().spliterator().getExactSizeIfKnown());
    }

    @Test
    void shouldReturnArticleByIdWithValidBy() {
        when(repository.findById(1)).thenReturn(articles.get(0));
        Article article = controller.findById(1);
        assertNotNull(article);
    }

}