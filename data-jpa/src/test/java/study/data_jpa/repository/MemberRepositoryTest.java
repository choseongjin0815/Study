package study.data_jpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.data_jpa.dto.MemberDto;
import study.data_jpa.entity.Member;
import study.data_jpa.entity.Team;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;
    @Autowired
    private MemberJpaRepository memberJpaRepository;
    @Autowired TeamRepository teamRepository;
    @PersistenceContext
    EntityManager em;

    @Test
    public void testMember () {
        Member member = new Member("memberA");
        Member savedMember = memberRepository.save(member);

        Member findMember = memberRepository.findById(savedMember.getId()).get();

        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        Assertions.assertThat(findMember).isEqualTo(member); //
    }

    @Test
    public void basicCRUD() {
        Member member1 = new Member("memberA");
        Member member2 = new Member("memberB");
        memberRepository.save(member1);
        memberRepository.save(member2);

        //단건 조회 검증
        Member findMember1 = memberRepository.findById(member1.getId()).get();
        Member findMember2 = memberRepository.findById(member2.getId()).get();
        Assertions.assertThat(findMember1.getId()).isEqualTo(member1.getId());
        Assertions.assertThat(findMember2.getId()).isEqualTo(member2.getId());

        //리스트 조회 검증
        List<Member> all = memberRepository.findAll();
        Assertions.assertThat(all.size()).isEqualTo(2);

        //카운트 검증
        long count = memberRepository.count();
        Assertions.assertThat(count).isEqualTo(2);

        //삭제 검증
        memberRepository.delete(member1);
        memberRepository.delete(member2);

        long deleteCount = memberRepository.count();
        Assertions.assertThat(deleteCount).isEqualTo(0);
    }

    @Test
    public void findByuserNameAndGreaterThenTest() {
        Member member1 = new Member("memberA", 10);
        Member member2 = new Member("memberA", 20);
        memberJpaRepository.save(member1);
        memberJpaRepository.save(member2);

        List<Member> result = memberRepository.findByUsernameAndAgeGreaterThan("memberA", 10);

        Assertions.assertThat(result.get(0).getUsername()).isEqualTo("memberA");
        Assertions.assertThat(result.get(0).getAge()).isEqualTo(20);
        Assertions.assertThat(result.size()).isEqualTo(1);

    }

    @Test
    public void findBy() {
        List<Member> helloBy = memberRepository.findTop3By();
    }

    @Test
    public void testQuery() {
        Member member1 = new Member("memberA", 10);
        Member member2 = new Member("memberA", 20);
        memberRepository.save(member1);
        memberRepository.save(member2);

        List<Member> result = memberRepository.findUser("memberA", 10);
        Assertions.assertThat(result.get(0)).isEqualTo(member1);
    }

    @Test
    public void findMemberDto() {
        Team team = new Team("teamA");

        teamRepository.save(team);
        Member member1 = new Member("memberA", 10);

        member1.setTeam(team);
        memberRepository.save(member1);

        List<MemberDto> result = memberRepository.findMemberDto();

        for (MemberDto memberDto : result) {
            System.out.println("dto: " + memberDto);
        }
    }

    @Test
    public void findByNames() {
        Member member1 = new Member("memberA", 10);
        Member member2 = new Member("memberB", 20);
        memberRepository.save(member1);
        memberRepository.save(member2);

        List<Member> result = memberRepository.findByNames(Arrays.asList("memberA", "memberB"));
        for (Member member : result) {
            System.out.println("member: " + member);
        }
    }

    @Test
    public void paging() {
        //given
        memberRepository.save(new Member("memberA", 10));
        memberRepository.save(new Member("memberB", 10));
        memberRepository.save(new Member("memberC", 10));
        memberRepository.save(new Member("memberD", 10));
        memberRepository.save(new Member("memberE", 10));
        memberRepository.save(new Member("memberF", 10));


        int age = 10;
        PageRequest pageRequest = PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "username"));

        //when
        Page<Member> page = memberRepository.findByAge(age, pageRequest);

        Page<MemberDto> toMap = page.map(member -> new MemberDto(member.getId(), member.getUsername(), null));

        //then
        List<Member> content = page.getContent();
        long totalElements = page.getTotalElements();

        for(Member member : content) {
            System.out.println("member: " + member);
        }
        System.out.println("totalElements: " + totalElements);

        Assertions.assertThat(content.size()).isEqualTo(3);
        Assertions.assertThat(page.getTotalElements()).isEqualTo(6);
        Assertions.assertThat(page.getNumber()).isEqualTo(0);
        Assertions.assertThat(page.getTotalPages()).isEqualTo(2);
        Assertions.assertThat(page.isFirst()).isTrue();
        Assertions.assertThat(page.hasNext()).isTrue();
    }

    @Test
    public void bulkUpdate() {
        memberRepository.save(new Member("memberA", 10));
        memberRepository.save(new Member("memberB", 20));
        memberRepository.save(new Member("memberC", 15));
        memberRepository.save(new Member("memberD", 22));
        memberRepository.save(new Member("memberE", 12));

        int resultCount = memberRepository.bulkAgePlus(11);
//        em.flush();
//        em.clear();

        List<Member> result = memberRepository.findByUsername("memberE"); //벌크 연산을 하면 영속성 컨텍스트에 있는 값이 있는데 그걸 무시하고 가져와서 12나옴  em.flush em.clear 대신 Modifying(clearAuto... true하면됨)
        Member member5 = result.get(0);
        System.out.println("member5: " + member5);

        Assertions.assertThat(resultCount).isEqualTo(4);
    }
}