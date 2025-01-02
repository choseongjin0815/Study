package com.example.firstproject.service;

import com.example.firstproject.dto.CommentDTO;
import com.example.firstproject.entity.Comment;
import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ArticleRepository articleRepository;

    public List<CommentDTO> comments(Long article_id) {
        //1.댓글 조회
        List<Comment> comments = commentRepository.findByArticleId(article_id);
        //2.엔티티 -> DTO 변환
        List<CommentDTO> dtos = new ArrayList<CommentDTO>();

        for(int i = 0; i < comments.size(); i++) {
            Comment c = comments.get(i);
            CommentDTO dto = CommentDTO.createCommentDTO(c);
            dtos.add(dto);

        }

        //3. 결과 반환
        return dtos;
    }
}
