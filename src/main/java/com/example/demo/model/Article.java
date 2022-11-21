package com.example.demo.model;

import java.time.LocalDateTime;

public record Article(
        Integer id,
        String title,
        String slug,
        String content,
        LocalDateTime publishedOn
) {
}
