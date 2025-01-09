package com.db.test.repository.search;

import com.db.test.entity.MemberEntity;
import com.db.test.entity.QMemberEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class MemberSearchImpl implements MemberSearch{
    private final JPAQueryFactory jpaQueryFactory;
    @Override
    public List<MemberEntity> findMemberTest() {
        QMemberEntity memberEntity = QMemberEntity.memberEntity;
        return jpaQueryFactory.selectFrom(memberEntity)
                .where(memberEntity.memberName.eq("홍길동"))
                .fetch();
    }
}
