package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {



    public Long id;
    public String title;
    public String content;

    public Article toEntity() {
        return new Article(id, title, content);
    }
}
