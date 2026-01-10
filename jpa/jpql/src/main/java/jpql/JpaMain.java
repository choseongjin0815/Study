
package jpql;

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

            Team team = new Team();
            team.setName("team");
            em.persist(team);

            Team team2 = new Team();
            team2.setName("team2");
            em.persist(team2);


            Member member = new Member();
            member.setUsername("member");
            member.setTeam(team);
            member.setAge(0);
            em.persist(member);

            Member member2 = new Member();
            member2.setUsername("member2");
            member2.setTeam(team);
            member2.setAge(0);
            em.persist(member2);

            Member member3 = new Member();
            member3.setUsername("member3");
            member3.setTeam(team2);
            member3.setAge(0);
            em.persist(member3);

//            String query = "select m from Member m join fetch m.team";

            String query = "select m from Member m where m = :member";
//            em.flush();
//            em.clear();

            int resultCount = em.createQuery("update Member m set m.age = 3").executeUpdate();

            em.clear();

            //영속성 컨텍스트에는 0으로 그대로 있고 DB에만 업데이트 됨 따라서 3이 아닌 0이 나옴
            Member findMember = em.find(Member.class, member.getId());
            System.out.println("find member: " + findMember.getAge());

            System.out.println(resultCount);
//
//            Member findMember = em.createQuery(query , Member.class).setParameter("member", member).getSingleResult();
//            System.out.println("Found member: " + findMember);
//            List<Member> result = em.createQuery(query, Member.class).getResultList();
//
//            for (Member m : result) {
//                System.out.println("Member: " + m.getUsername() + "," + m.getTeam().getName());
//
//                //join fetch안쓰면
//                //회원1  팀A(SQL)
//                //회원2 팀A(1차캐시)
//                //회원3, 팀B(SQL)
//            }
            //            Member member = new Member();
//            member.setUsername("member1");
//            member.setAge(20);
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            List<MemberDTO> resultList = em.createQuery("select new jpql.MemberDTO(m.username, m.age) from Member m", MemberDTO.class)
//                    .getResultList();
//            MemberDTO memberDTO = resultList.get(0);
//            System.out.println("username: " + memberDTO.getUsername());
//            System.out.println("age: " + memberDTO.getAge());
//           TypedQuery<Member> query =  em.createQuery("select m from Member m where m.username = :username", Member.class);
//           query.setParameter("username", "member1");
//           Member member1 = query.getSingleResult();
//            System.out.println("find" + member1.getUsername());
//           query.getResultList();
//           for (Member m : query.getResultList()) {
//               System.out.println(m);
//           }
//            TypedQuery<String> query2 =  em.createQuery("select m.username from Member m", String.class);
//            Query query3 =  em.createQuery("select m.username from Member m");


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
