package hello.servlet.domain.member;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {

    private Long id;
    private String username;
    private int age;

    public Member() {}

    public Member(String usename, int age) {
        this.username = usename;
        this.age = age;
    }
}
