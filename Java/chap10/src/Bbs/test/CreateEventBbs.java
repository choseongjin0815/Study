package Bbs.test;


import java.util.ArrayList;
import java.util.Scanner;

public class CreateEventBbs {

    public static void main(String[] args) {
        ArrayList<EventBbsforAL> postList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        EventBbsforAL eventBbs = new EventBbsforAL();
        
        System.out.println("페이지 사이즈를 입력하세요:");
        int pageSize = sc.nextInt();

        while (true) {
            System.out.println("이벤트 게시판에서 어떤 작업을 하실건가요?");
            System.out.println("1. [글등록]\n2. [검색]\n3. [글조회]\n4. [끝내기]\n5. [더미생성]\n6. [삭제]\n7. [수정]");
            String work = sc.next();
            
            switch (work) {
                case "1":
                case "글등록":
                    System.out.println("게시글을 몇 개 등록하실 건가요?");
                    int postNo = sc.nextInt();
                    eventBbs.addPost(postList, postNo);
                    break;

                case "2":
                case "검색":
                    eventBbs.searchPost();
                    break;

                case "3":
                case "글조회":
                    System.out.println("조회할 게시글 번호를 입력하세요:");
                    int bbsIdx = sc.nextInt();
                    eventBbs.view(bbsIdx);
                    break;

                case "4":
                case "끝내기":
                    System.out.println("프로그램을 종료합니다.");
                    return;

                case "6":
                case "삭제":
                    System.out.println("삭제할 게시글 번호를 입력하세요:");
                    int deleteIdx = sc.nextInt();
                    eventBbs.deletePost(postList, deleteIdx);
                    break;

                case "7":
                case "수정":
                    System.out.println("수정할 게시글 번호를 입력하세요:");
                    int modifyIdx = sc.nextInt();
                    eventBbs.modifyPost(postList, modifyIdx);
                    break;

                default:
                    System.out.println("잘못된 입력입니다.");
                    break;
            }
        }
    }
}

