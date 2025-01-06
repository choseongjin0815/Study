package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.dto.CommentDTO;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CommentService commentService;
    @GetMapping("/articles/new")
    public String newAticleForm() {
        return "/articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
        //DTO로 들어온 값
        log.info(form.toString());
        //System.out.println(form.toString());
        //Entity로 들어온 값
        Article article = form.toEntity();
        log.info(article.toString());
        //System.out.println(article.toString());
        //리포지토리로 DB에 저장한 값
        Article saved = articleRepository.save(article);
        log.info(saved.toString());
        //System.out.println(saved.toString());
        //리다이렉트 주소
        return "redirect:/articles/" + saved.getId();
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model) {
        log.info("id = " + id);
        //1.id를 조회해 데이터 가져오기
        //Optional<Article> articleEntity = articleRepository.findById(id);
        Article articleEntity = articleRepository.findById(id).orElse(null);
        List<CommentDTO> commentDTOs = commentService.comments(id);
        //2.모델에 데이터를 등록
        model.addAttribute("article", articleEntity);
        model.addAttribute("commentsDtos", commentDTOs);
        //3. 뷰 페이지 반환하기
        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model) {
        //1.모든 데이터를 가져오기
        ArrayList<Article> articleEntityList = articleRepository.findAll();
        //2.모델에 데이터 등록하기
        model.addAttribute("articleList", articleEntityList);
        //3.뷰 페이지 설정하기
        return "/articles/index";
    }

    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        //수정할 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);

        //모델에 데아터 등록하기
        model.addAttribute("article", articleEntity);

        return "articles/edit";

    }

    @PostMapping("/articles/update")
    public String update(ArticleForm form){
        log.info(form.toString());
        //1.DTO를 Entity로 변환하기
        Article articleEntity = form.toEntity();
        log.info(articleEntity.toString());
        //2.Entity를 DB에 저장하기
        //2-1 DB에서 기존 데이터 가져오기
        Article target = articleRepository.findById(articleEntity.getId()).orElse(null);
        //2-2 기존 데이터 값을 갱신하기
        if(target != null) {
            articleRepository.save(articleEntity);
        }
        return "redirect:/articles/" + articleEntity.getId();
    }

    @GetMapping("/articles/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr){
        log.info("삭제 요청이 들어왔습니다.");
        //1.삭제할 대상 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);
        //2.대상 엔티티 삭제하기
        if(articleEntity != null) {
            articleRepository.delete(articleEntity);
            rttr.addFlashAttribute("msg", "삭제완료");
        }
        //3.결과 페이지로 리다이렉트하기
        return "redirect:/articles";
    }

}
