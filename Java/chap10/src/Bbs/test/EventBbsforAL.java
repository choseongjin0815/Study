package Bbs.test;


import chap10.BasicBbsIf;
import java.util.ArrayList;
import java.util.Scanner;

public class EventBbsforAL implements BasicBbsInterface {
    String title, email, name, startDate, endDate, registDate, content, contentIdx;
    int idx;

    public EventBbsforAL() {}

    public EventBbsforAL(int idx, String title, String name, String email, String startDate, String endDate, String registDate, String contentIdx, String content) {
        this.idx = idx;
        this.title = title;
        this.name = name;
        this.email = email;
        this.startDate = startDate;
        this.endDate = endDate;
        this.registDate = registDate;
        this.contentIdx = contentIdx;
        this.content = content;
    }

    @Override
    public void bbsList(int pageSize, int pageNo) {
        // 게시판 목록 기능 구현
    }

    @Override
    public void view(int bbsIdx) {
        // 글 조회 기능 구현
    }

    public void addPost(ArrayList<EventBbsforAL> postList, int postNo) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < postNo; i++) {
            System.out.print("제목 : ");
            String title = sc.next();
            System.out.print("이름 : ");
            String name = sc.next();
            System.out.print("이메일 : ");
            String email = sc.next();
            System.out.print("시작일 : ");
            String startDate = sc.next();
            System.out.print("종료일 : ");
            String endDate = sc.next();
            System.out.print("등록일 : ");
            String registDate = sc.next();
            System.out.print("내용 : ");
            String content = sc.next();
            postList.add(new EventBbsforAL(postList.size() + 1, title, name, email, startDate, endDate, registDate, "게시글" + (postList.size() + 1), content));
        }
    }

    public void searchPost() {
        // 검색 기능 구현
    }

    public void deletePost(ArrayList<EventBbsforAL> postList, int idx) {
        // 글 삭제 기능 구현
        if (idx < postList.size()) {
            postList.remove(idx);
        } else {
            System.out.println("잘못된 인덱스입니다.");
        }
    }

    public void modifyPost(ArrayList<EventBbsforAL> postList, int idx) {
        Scanner sc = new Scanner(System.in);
        System.out.print("수정할 컬럼 번호(1: 제목, 2: 이름, 3: 이메일, 4: 내용)>>> ");
        int modifyColumnNo = sc.nextInt();
        System.out.print("수정할 값 >>> ");
        String modifyValue = sc.next();
        
        if (idx < postList.size()) {
            EventBbsforAL post = postList.get(idx);
            switch (modifyColumnNo) {
                case 1: post.title = modifyValue; break;
                case 2: post.name = modifyValue; break;
                case 3: post.email = modifyValue; break;
                case 4: post.content = modifyValue; break;
                default: System.out.println("잘못된 입력입니다.");
            }
        } else {
            System.out.println("잘못된 인덱스입니다.");
        }
    }
}

