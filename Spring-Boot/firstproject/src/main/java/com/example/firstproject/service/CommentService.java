package com.example.firstproject.service;

import com.example.firstproject.dto.CommentDTO;
import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Comment;
import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.repository.CommentRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.List;
@Service
@Slf4j
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ArticleRepository articleRepository;

    public List<CommentDTO> comments(Long article_id) {
//        //1.댓글 조회
//        List<Comment> comments = commentRepository.findByArticleId(article_id);
//        //2.엔티티 -> DTO 변환
//        List<CommentDTO> dtos = new ArrayList<CommentDTO>();
//
//        for(int i = 0; i < comments.size(); i++) {
//            Comment c = comments.get(i);
//            CommentDTO dto = CommentDTO.createCommentDTO(c);
//            dtos.add(dto);
//
//        }

        //3. 결과 반환
        return commentRepository.findByArticleId(article_id)
                .stream()
                .map(comment -> CommentDTO.createCommentDTO(comment))
                .collect(Collectors.toList());
    }

    @Transactional
    public CommentDTO create(Long article_id, CommentDTO dto) {
        //1.게시글 조회 및 예외 발생
        Article article = articleRepository.findById(article_id)
                .orElseThrow(()->new IllegalArgumentException(("댓글 생성 실패" + "대상 게시글이 없습니다.")));
        //2.댓글 엔티티 생성
        Comment comment = Comment.createComment(dto, article);
        //3.댓글 엔티티를 DB에 저장
        Comment created = commentRepository.save(comment);
        //4.DTO로 변환해 반환
        return CommentDTO.createCommentDTO(created);

    }

    @Transactional
    public CommentDTO update(Long id, CommentDTO dto) {
        //1.댓글 조회 및 예외 발생
        Comment target = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("없는 id입니다."));
        //2.댓글 수정
        target.patch(dto);
        //3.DB로 갱신
        Comment updated = commentRepository.save(target);
        //4.댓글 엔티티를 DTO로 변환 및 반환
        return CommentDTO.createCommentDTO(updated);
    }

    public CommentDTO delete(Long id) {
        //1.댓글 조회 및 예외 발생
        Comment target = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("댓글 삭제 실패 ! 없는 id입니다."));
        //2.댓글 삭제
        commentRepository.delete(target);
        log.info(target.toString());
        log.info("test");
        //3.삭제 댓글을 DTO로 변환 및 반환
        return CommentDTO.createCommentDTO(target);
    }
}
