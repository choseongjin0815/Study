package com.example.firstproject.controller;

import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Slf4j
@Controller
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/member/regist")
    public String newMemberForm() {
        return "regist/regist";
    }

    @PostMapping("/member/create")
    public String createMember(MemberForm form) {
        //DTO로 들어온 값
        //System.out.println(form.toString());
        log.info(form.toString());
        //Entity로 전달
        Member member = form.toEntity();
        log.info(member.toString());
        //System.out.println(member.toString());
        //리포지토리로 데이터베이스에 저장
        Member saved = memberRepository.save(member);
        log.info(saved.toString());
        //System.out.println(saved.toString());
        //상세 페이지로 리다이렉트
        return "redirect:/member/" + saved.getId();
    }

    @GetMapping("/member/{id}")
    public String show(@PathVariable Long id, Model model) {
        //1데이터 가져오기
        Member memberEntity = memberRepository.findById(id).orElse(null);
        //2모델에 데이터 담기
        model.addAttribute("member", memberEntity);
        //3뷰페이지
        return "regist/view";
    }

    @GetMapping("/member")
    public String showAll(Model model){
        //1.데이터 전체 가져오기
        //Iterable<Member> memberList = memberRepository.findAll();
        ArrayList<Member> memberList = memberRepository.findAll();
        //2.모델에 데이터 담기
        model.addAttribute("members", memberList);
        //3.뷰페이지
        return "regist/showAll";
    }

    @GetMapping("/member/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        //수정할 데이터를 가져오기
        Member memberEntity = memberRepository.findById(id).orElse(null);
        //모델에 데이터 등록하기
        model.addAttribute("member", memberEntity);
        return "regist/edit";
    }

    @PostMapping("/member/update")
    public String update(MemberForm form){
        log.info(form.toString());
        //1.DTO를 Entity로 변환하기
        Member memberEntity = form.toEntity();
        log.info(memberEntity.toString());
        //2.Entity를 DB에 저장하기
        //2-1.DB에서 기존 데이터를 가져오가
        Member target = memberRepository.findById(memberEntity.getId()).orElse(null);
        //2-1 DB에 id에 해당하는 row 수정하기
        if(target != null) {
            memberRepository.save(memberEntity);
        }
        return "redirect:/member/" + memberEntity.getId();
    }
    @GetMapping("/member/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr) {
        //1.삭제할 데이터 불러오기
        Member target = memberRepository.findById(id).orElse(null);
        //2.대상 엔티티 삭제하기
        if(target != null) {
            memberRepository.delete(target);
            rttr.addFlashAttribute("msg", "삭제완료");
        }

        //3.리다이렉트
        return "redirect:/member";
    }


}
