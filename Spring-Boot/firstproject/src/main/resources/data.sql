INSERT INTO article(title, content) VALUES('가가가가', '1111');
INSERT INTO article(title, content) VALUES('나나나나', '2222');
INSERT INTO article(title, content) VALUES('다다다다', '3333');

-- 게시글 추가 --
INSERT INTO article(title, content) VALUES('당신의 인생 영화는?', '댓글 고');
INSERT INTO article(title, content) VALUES('당신의 소울 푸드는?', '댓글 고고');
INSERT INTO article(title, content) VALUES('당신의 취미는?', '댓글 고고고');
--댓글 추가 --
-- article_id = 4에 대한 댓글들
INSERT INTO comment(article_id, nickname, body) VALUES (4, 'Park', '굿 윌 헌팅');
INSERT INTO comment(article_id, nickname, body) VALUES (4, 'John', '멋진 영화! 다시 보고 싶다.');
INSERT INTO comment(article_id, nickname, body) VALUES (4, 'Alice', '영화의 메시지가 인상적이었다.');

-- article_id = 5에 대한 댓글들
INSERT INTO comment(article_id, nickname, body) VALUES (5, 'Mike', '정말 멋진 작품!');
INSERT INTO comment(article_id, nickname, body) VALUES (5, 'Sara', '조연들의 연기가 너무 좋았다.');
INSERT INTO comment(article_id, nickname, body) VALUES (5, 'Tom', '이 영화는 꼭 봐야 한다.');

-- article_id = 6에 대한 댓글들
INSERT INTO comment(article_id, nickname, body) VALUES (6, 'David', '영화가 너무 감동적이었다.');
INSERT INTO comment(article_id, nickname, body) VALUES (6, 'Emma', '주인공 연기가 대단했다.');
INSERT INTO comment(article_id, nickname, body) VALUES (6, 'Lucas', '추천할 만한 영화!');


INSERT INTO member(email, pwd) VALUES('ijn10000@naver.com', '1111');
INSERT INTO member(email, pwd) VALUES('okm10000@naver.com', '2222');
INSERT INTO member(email, pwd) VALUES('chobocho0815@gmail.com', '3333');


INSERT INTO employee(name, age) VALUES('가가가', 26);
INSERT INTO employee(name, age) VALUES('아아아', 33);
INSERT INTO employee(name, age) VALUES('다다다', 41);
INSERT INTO employee(name, age) VALUES('바바바', 22);
INSERT INTO employee(name, age) VALUES('카카카', 55);
INSERT INTO employee(name, age) VALUES('마마마', 23);


INSERT INTO coffee(name, price) VALUES('아메리카노', 4500);
INSERT INTO coffee(name, price) VALUES('라떼', 5000);
INSERT INTO coffee(name, price) VALUES('카페 모카', 5500);

INSERT INTO pizza(name, price) VALUES('페퍼로니 피자', 25900);
INSERT INTO pizza(name, price) VALUES('불고기 피자', 29900);
INSERT INTO pizza(name, price) VALUES('고구마 피자', 30900);
INSERT INTO pizza(name, price) VALUES('포테이토 피자', 27900);
INSERT INTO pizza(name, price) VALUES('치즈 피자', 23900);

