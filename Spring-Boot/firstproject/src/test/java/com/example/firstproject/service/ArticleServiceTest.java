package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ArticleServiceTest {
    @Autowired
    ArticleService articleService;
    @Test
    void index() {
        //1. 예상 데이터
        Article a = new Article(1L, "가가가가" , "1111");
        Article b = new Article(2L, "나나나나" , "2222");
        Article c = new Article(3L, "다다다다" , "3333");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(a,b,c));
        //2. 실제 데이터
        List<Article> articles = articleService.index();
        //3. 비교 및 검증
        assertEquals(expected.toString(), articles.toString());
    }

    @Test
    void showSuccessExistId() {
        //1. 예상 데이터
        Long id = 1L;
        Article expected = new Article(id, "가가가가", "1111");
        //2. 실제 데이터
        Article article = articleService.show(id);

        //3. 비교 및 검증
        assertEquals(expected.toString(), article.toString());
    }
    @Test
    void showFailNotExistId(){
        //1.예상 데이터
        Long id = -1L;
        Article expected = null;

        //2. 실제 데이터
        Article article = articleService.show(id);
        //3.비교 및 검증
        assertEquals(expected, article);
    }
    @Transactional
    @Test
    void createSuccess() {
        //1예상데이터
        String title = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(null, title, content);
        Article expected = new Article(4L, title, content);
        //2.실제데이터
        Article article = articleService.create(dto);
        //3.비교및검증
        assertEquals(expected.toString(), article.toString());
    }
    @Transactional
    @Test
    void createFailIncludeId() {
        //1.예상 데이터
        Long id = 4L;
        String title = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = null;
        //2실제 데이터
        Article article = articleService.create(dto);
        //3.비교 및 검증
        assertEquals(expected, article);
    }

    @Test
    @Transactional
    void updateSuccess() {
        //1.예상 데이터
        String title = "updateTitle";
        String content = "updateContent";
        Long id = 3L;
        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = new Article(id, title, content);
        //2.실제 데이터
        Article article = articleService.update(id, dto);
        if(article == null) {
            System.out.println("null");
        }
        //3.비교 및 검증
        assertEquals(expected.toString(), article.toString());
    }
    @Test
    @Transactional
    void updateSuccessIdAndTitle() {
        //1.예상데이터
        Long id = 1L;
        String title = "업데이트";
        String content = null;
        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = new Article(id, title, "1111");

        //2.실제 데이터
        Article article = articleService.update(id, dto);
        //3. 비교 및 검증
        assertEquals(expected.toString(), article.toString());
    }
    @Test
    @Transactional
    void updateFail() {
        //1.예상데이터
        Long id = -1L;
        String title = "업데이트 실패할듯";
        String content = "실패";
        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = null;
        //2.실제 데이터
        Article article =  articleService.update(id, dto);
        //3. 비교 및 검증
        assertEquals(expected, article);

    }
    @Test
    @Transactional
    void deleteSuccess() {
        //1.예상 데이터
        Long id = 1L;
        Article expected = new Article(id,"가가가가", "1111");
        //2. 실제 데이터
        Article article = articleService.delete(id);
        //3.비교 및 검증
        assertEquals(expected.toString(), article.toString());


    }

    @Test
    @Transactional
    void deleteFail() {
        //1.예상데이터
        Long id = -1L;
        Article expected = null;
        //2.실제 데이터
        Article article = articleService.delete(id);

        assertEquals(expected, article);
    }
}
