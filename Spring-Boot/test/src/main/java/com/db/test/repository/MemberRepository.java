package com.db.test.repository;

import com.db.test.entity.MemberEntity;
import com.db.test.repository.search.MemberSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long>, MemberSearch {
    List<MemberEntity> findAll();


}
