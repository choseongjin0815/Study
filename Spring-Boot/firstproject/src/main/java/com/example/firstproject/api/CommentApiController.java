package com.example.firstproject.api;

import com.example.firstproject.dto.CommentDTO;
import com.example.firstproject.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentApiController {
    @Autowired
    private CommentService commentService;

    //댓글 조회
    @GetMapping("/api/articles/{article_id}/comments")
    public ResponseEntity<List<CommentDTO>> comments(@PathVariable Long article_id) {
        //서비스에 위임
        List<CommentDTO> dtos = commentService.comments(article_id);
        //결과값 응답
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }
    //댓글 생성

    //댓글 수정

    //댓글 삭제
}
