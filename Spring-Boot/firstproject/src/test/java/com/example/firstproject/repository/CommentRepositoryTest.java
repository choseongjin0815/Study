package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class CommentRepositoryTest {
    @Autowired
    CommentRepository commentRepository;

    @Test
    @DisplayName("특정 게시글의 모든 댓글 조회")
    void findByArticleId() {
       /*case 1 : 4번 게시글의 모든 댓글 조회*/
        {
            //1.입력 데이터 준비
            Long articleId = 4L;
            //2.실제 데이터
            List<Comment> comments = commentRepository.findByArticleId(articleId);
            //3.예상 데이터
            Article article = new Article(4L, "당신의 인생 영화는?", "댓글 고");
            Comment a = new Comment(1L, article, "Park", "굿 윌 헌팅");
            Comment b = new Comment(2L, article, "John", "멋진 영화! 다시 보고 싶다.");
            Comment c = new Comment(3L, article, "Alice", "영화의 메시지가 인상적이었다.");

            List<Comment> expected = Arrays.asList(a, b, c);
            //4. 비교 및 검증
            assertEquals(expected.toString(), comments.toString(), "4번 글의 모든 댓글을 출력!");
        }

        /*case 2 : 1번 게시글의 모든 댓글 조회*/
        {
            //1.입력 데이터 준비
            Long articleId = 1L;
            //2.실제 데이터
            List<Comment> comments = commentRepository.findByArticleId(articleId);
            //3.예상 데이터
            Article article = new Article(1L, "가가가가", "1111");
            List<Comment> expected = Arrays.asList();

            //4. 비교 및 검증
            assertEquals(expected.toString(), comments.toString(), "1번 댓글은 없음");
        }
        /*case 3 : 9번 게시글의 모든 댓글 조회*/
        {
            //1.입력데이터 준비
            Long id = 9L;
            //2.실제데이터
            List<Comment> comments = commentRepository.findByArticleId(id);
            //3.예상 데이터
            Article article = null;
            List<Comment> expected = Arrays.asList();
            //4.비교 및 검증
            assertEquals(comments.toString(), expected.toString(), "9번 게시글의 댓글 조회");
        }

        /*case 4 : 999번 게시글의 모든 댓글 조회*/
        {
            //1.입력데이터 준비
            Long id = 999L;
            //2.실제데이터
            List<Comment> comments = commentRepository.findByArticleId(id);
            //3.예상 데이터
            Article article = null;
            List<Comment> expected = Arrays.asList();
            //4.비교 및 검증
            assertEquals(comments.toString(), expected.toString(), "999번 게시글의 댓글 조회");
        }
        /*case 5 : -1번 게시글의 모든 댓글 조회*/
        {
            //1.입력데이터 준비
            Long id = -1L;
            //2.실제데이터
            List<Comment> comments = commentRepository.findByArticleId(id);
            //3.예상 데이터
            Article article = null;
            List<Comment> expected = Arrays.asList();
            //4.비교 및 검증
            assertEquals(comments.toString(), expected.toString(), "-1번 게시글의 댓글 조회");
        }

    }

    @Test
    @DisplayName("특정 닉네임의 모든 게시글 조회")
    void findByNickname() {
        /*case 1 : "Park"의 모든 댓글 조회*/
        {
            //1.입력데이터 준비
            String nickname = "Park";
            //2.실제데이터
            List<Comment> comments = commentRepository.findByNickname(nickname);
            //3.예상데이터
            Comment a = new Comment(1L, new Article(4L, "당신의 인생 영화는?", "댓글 고"), nickname, "굿 윌 헌팅");
            List<Comment> expected = Arrays.asList(a);
            //4.비교및검증
            assertEquals(comments.toString(), expected.toString(), "Park의 모든 댓글 출력");
        }

        /*case 2 "Tom"의 모든 댓글 조회*/
        {
            //1.입력데이터
            String nickname = "Tom";
            //2.실제 데이터
            List<Comment> comments = commentRepository.findByNickname(nickname);
            //3.예상데이터
            Article article = new Article(5L, "당신의 소울 푸드는?", "댓글 고고");
            Comment a = new Comment(6L, article, "Tom", "이 영화는 꼭 봐야 한다.");
            List<Comment> expected = Arrays.asList(a);
            //4.비교 및 검증
            assertEquals(expected.toString(), comments.toString(), "Tom의 모든 댓글 조회");
        }
        /*case 3 null의 모든 댓글 조회*/
        {
            //1.입력데이터
            String nickname = null;
            //2.실제 데이터
            List<Comment> comments = commentRepository.findByNickname(nickname);
            //3.예상데이터
            List<Comment> expected = Arrays.asList();
            //4.비교 및 검증
            assertEquals(expected.toString(), comments.toString(), "null의 모든 댓글 조회");
        }

        /*case 4 ""의 모든 댓글 조회*/
        {
            //1.입력데이터
            String nickname = "";
            //2.실제 데이터
            List<Comment> comments = commentRepository.findByNickname(nickname);
            //3.예상데이터
            List<Comment> expected = Arrays.asList();
            //4.비교 및 검증
            assertEquals(expected.toString(), comments.toString(), "\"\"의 모든 댓글 조회");
        }
    }
}