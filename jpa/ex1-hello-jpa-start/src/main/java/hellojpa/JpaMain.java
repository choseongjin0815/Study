package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); //persistence.xml에 있는 unit name 애플리케이션 실행시점에 딱 한번만

        EntityManager em = emf.createEntityManager();
        //code
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("Johnㅁ");
//            em.persist(member);
//            Member findMember = em.find(Member.class, 1L); //jpa를 통해 데이터를 가져오면 jpa가 관리를하고 jpa가 변경여부 트랜잭션 시점에 체크해서
//            //업데이트 시점에 쿼리 날림
//            findMember.setName("HelloJPA"); // persist안해도됨
//            List<Member> findMembers = em.createQuery("select m from Member m", Member.class) //member 객체를 대상으로 쿼리 대상이 테이블 아니고 객체
//                            .getResultList();
//
//            for(Member member : findMembers) {
//                System.out.println(member.getName());
//            }
//            Member member1 = new Member(150L, "member1");
//            Member member2 = new Member(151L, "member2");
//
//            em.persist(member1);
//            em.persist(member2);
//            Member member = em.find(Member.class, 150L);
//            member.setName("kkkkkkk");
//
//            em.detach(member); //영속성 컨텍스트에서 더이상 관리하지 마라
//
//            System.out.println("=========================");

            //저장
            Team team = new Team();
            team.setName("Team 1");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.setTeam(team);
            em.persist(member);


            //team.getMembers().add(member);//양방향 연관관계에서는 값을 양쪽 다 넣어주는게 좋음

            //해줘야 디비에서 값을 깔끔하게 가져옴
            em.flush();
            em.clear();

            Team findTeam = em.find(Team.class, team.getId());
            List<Member> findMembers = findTeam.getMembers();

            for (Member m : findMembers) {
                System.out.println("m=" + m.getUsername());
            }



            tx.commit();
        }
        catch (Exception e) {
            tx.rollback();
        }
        finally {
            em.close();
        }

        emf.close();
    }
}
