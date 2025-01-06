package com.example.firstproject.entity;

import com.example.firstproject.dto.CommentDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Entity
@Getter
@ToString
@AllArgsConstructor
@Slf4j
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 자동으로 1씩 증가
    private Long id; //대표키

    @ManyToOne
    @JoinColumn(name="article_id")
    private Article article; //해당 댓글의 부모 게시글

    @Column
    private String nickname; // 댓글을 단 사람

    @Column
    private String body; // 댓글 본문

    public static Comment createComment(CommentDTO dto, Article article) {
        //예외 발생
        if(dto.getId() != null) {

            throw new IllegalArgumentException("댓글 생성 실패 댓글의 id가 없어야 합니다.");
        }
        log.info(article.toString());
        log.info(dto.toString());
        if(dto.getArticleId() != article.getId()) {
            log.info("댓글의 게시글 id" , dto.getArticleId());
            log.info("게시글 id", article.getId());
            throw new IllegalArgumentException("댓글 생성 실패 게시글의 id가 잘못 되었습니다.");
        }
        //엔티티 생성 및 반환
        return new Comment(
                dto.getId(),
                article,
                dto.getNickname(),
                dto.getBody()
        );
    }

    public void patch(CommentDTO dto) {
        //예외 발생
        if(this.id != dto.getId()) throw new IllegalArgumentException("댓글 수정 실패! 잘못된 id가 입력되었습니다.");
        //객체 갱신
        if(dto.getNickname() != null) {
            this.nickname = dto.getNickname();
        }
        if(dto.getBody() != null) {
            this.body = dto.getBody();
        }
    }
}
