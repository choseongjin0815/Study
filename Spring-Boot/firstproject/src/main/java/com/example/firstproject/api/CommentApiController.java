package com.example.firstproject.api;

import com.example.firstproject.dto.CommentDTO;
import com.example.firstproject.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/api/articles/{article_id}/comments")
    public ResponseEntity<CommentDTO> create(@PathVariable Long article_id,
                                             @RequestBody CommentDTO dto) {
        //서비스에 위임
        CommentDTO createdDTO = commentService.create(article_id, dto);
        //결과 응답

        return ResponseEntity.status(HttpStatus.OK).body(createdDTO);
    }
    //댓글 수정
    @PatchMapping("/api/comments/{id}")
    public ResponseEntity<CommentDTO> update(@PathVariable Long id,
                                             @RequestBody CommentDTO dto) {
        //서비스에 위임
        CommentDTO updatedDTO = commentService.update(id, dto);
        //결과 응답

        return ResponseEntity.status(HttpStatus.OK).body(updatedDTO);
    }
    //댓글 삭제
    @DeleteMapping("/api/comments/{id}")
    public ResponseEntity<CommentDTO> delete(@PathVariable Long id) {
        //서비스에 위임
        CommentDTO deletedDTO = commentService.delete(id);
        //결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(deletedDTO);
    }
}
