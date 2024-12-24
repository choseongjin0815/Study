package com.example.firstproject.api;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleApiController {
    @Autowired
    private ArticleRepository articleRepository;
    //GET
    @GetMapping("/api/articles")
    public List<Article> index() {
        return articleRepository.findAll();
    }
    @GetMapping("/api/articles/{id}")
    public Article show(@PathVariable Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    //POST
    @PostMapping("/api/articles")
    public Article create(@RequestBody ArticleForm dto) {
        Article article = dto.toEntity();
        return articleRepository.save(article);

    }
    //PATCH
    @PatchMapping("/api/articles/{id}")
    public ResponsArticle update(@RequestBody ArticleForm dto, @PathVariable Long id) {
        Article article = dto.toEntity();
        Article target = articleRepository.findById(id).orElse(null);
        if(target==null || id != article.getId()) {
            return Re`
        }
        return articleRepository.save(article);
    }
    //DELETE
}
