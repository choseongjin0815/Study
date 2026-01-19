package study.data_jpa.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.data_jpa.entity.Member;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class MemberJpaRepositoryTest {

    @Autowired
    MemberJpaRepository memberJpaRepository;

    @Test
    public void testMember () {
        Member member = new Member("memberA");
        Member savedMember = memberJpaRepository.save(member);

        Member findMember = memberJpaRepository.find(savedMember.getId());

        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        Assertions.assertThat(findMember).isEqualTo(member); //
    }

    @Test
    public void basicCRUD() {
        Member member1 = new Member("memberA");
        Member member2 = new Member("memberB");
        memberJpaRepository.save(member1);
        memberJpaRepository.save(member2);

        //단건 조회 검증
        Member findMember1 = memberJpaRepository.findById(member1.getId()).get();
        Member findMember2 = memberJpaRepository.findById(member2.getId()).get();
        Assertions.assertThat(findMember1.getId()).isEqualTo(member1.getId());
        Assertions.assertThat(findMember2.getId()).isEqualTo(member2.getId());

        //리스트 조회 검증
        List<Member> all = memberJpaRepository.findAll();
        Assertions.assertThat(all.size()).isEqualTo(2);

        //카운트 검증
        long count = memberJpaRepository.count();
        Assertions.assertThat(count).isEqualTo(2);

        //삭제 검증
        memberJpaRepository.delete(member1);
        memberJpaRepository.delete(member2);

        long deleteCount = memberJpaRepository.count();
        Assertions.assertThat(deleteCount).isEqualTo(0);

    }

    @Test
    public void findByuserNameAndGreaterThenTest() {
        Member member1 = new Member("memberA", 10);
        Member member2 = new Member("memberA", 20);
        memberJpaRepository.save(member1);
        memberJpaRepository.save(member2);

        List<Member> result = memberJpaRepository.findByUsernameAndGreaterThen("memberA", 10);

        Assertions.assertThat(result.get(0).getUsername()).isEqualTo("memberA");
        Assertions.assertThat(result.get(0).getAge()).isEqualTo(20);
        Assertions.assertThat(result.size()).isEqualTo(1);

    }

    @Test
    public void paging() {
        //given
        memberJpaRepository.save(new Member("memberA", 10));
        memberJpaRepository.save(new Member("memberB", 10));
        memberJpaRepository.save(new Member("memberC", 10));
        memberJpaRepository.save(new Member("memberD", 10));
        memberJpaRepository.save(new Member("memberE", 10));
        memberJpaRepository.save(new Member("memberF", 10));

        int age = 10;
        int offset = 0;
        int limit = 3;

        //when
        List<Member> members = memberJpaRepository.findByPage(age, offset, limit);
        long totalCount = memberJpaRepository.totalCount(age);

        //then
        Assertions.assertThat(members.size()).isEqualTo(3);
        Assertions.assertThat(totalCount).isEqualTo(6);

    }

    @Test
    public void bulkUpdate() {
        memberJpaRepository.save(new Member("memberA", 10));
        memberJpaRepository.save(new Member("memberB", 20));
        memberJpaRepository.save(new Member("memberC", 15));
        memberJpaRepository.save(new Member("memberD", 22));
        memberJpaRepository.save(new Member("memberE", 12));

        int resultCount = memberJpaRepository.bulkAgePlus(15);

        Assertions.assertThat(resultCount).isEqualTo(3);
    }
}