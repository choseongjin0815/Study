package com.db.test.service;

import com.db.test.entity.MemberEntity;
import com.db.test.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class MemberService {
    private final MemberRepository memberRepository;

    public List<MemberEntity> getTestMember() {
        System.out.println(memberRepository.findMemberTest());
        return memberRepository.findMemberTest();
    }
}
