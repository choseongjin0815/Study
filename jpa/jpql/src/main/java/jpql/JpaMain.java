
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
            Member member = new Member();
            member.setUsername("member1");
            member.setAge(20);
            em.persist(member);

            em.flush();
            em.clear();

            List<MemberDTO> resultList = em.createQuery("select new jpql.MemberDTO(m.username, m.age) from Member m", MemberDTO.class)
                    .getResultList();
            MemberDTO memberDTO = resultList.get(0);  
            System.out.println("username: " + memberDTO.getUsername());
            System.out.println("age: " + memberDTO.getAge());
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
