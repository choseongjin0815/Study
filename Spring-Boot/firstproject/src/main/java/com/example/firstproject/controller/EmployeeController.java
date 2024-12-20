package com.example.firstproject.controller;

import com.example.firstproject.dto.EmployeeForm;
import com.example.firstproject.entity.Employee;
import com.example.firstproject.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Slf4j
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employee")
    public String mainView(Model model){
        //리포지토리에서 데이터 가져오기
        ArrayList<Employee> empEntity = employeeRepository.findAll();
        //모델에 데이터 등록
        model.addAttribute("empList", empEntity);

        return "employee/main";
    }

    @GetMapping("/employee/{id}")
    public String view(@PathVariable Long id, Model model) {
        //리포지토리에서 id에 해당하는 데이터 가져오기
        Employee employeeEntity = employeeRepository.findById(id).orElse(null);
        //모델에 데이터 등록
        model.addAttribute("employee", employeeEntity);

        return "employee/view";

    }
    @GetMapping("/employee/new")
    public String createPage() {return "employee/new";}

    @PostMapping("/employee/addEmployee")
    public String addEmployee(EmployeeForm form){
        //DTO를 Entity로
        Employee employeeEntity = form.toEntity();
        //엔티티를 리포지토리에 등록
        if(employeeEntity != null) {
            employeeRepository.save(employeeEntity);
        }
        return "redirect:/employee";
    }

    @GetMapping("/employee/edit/{id}")
    public String editPage(@PathVariable Long id, Model model) {
        //리포지토리에서 데이터 불러오기
        Employee emp = employeeRepository.findById(id).orElse(null);
        //모델에 데이터 등록
        model.addAttribute("employee", emp);

        return "/employee/edit";
    }

    @PostMapping("/employee/update")
    public String update(EmployeeForm form) {
        //DTO를 엔티티로
        Employee empEnt = form.toEntity();
        //엔티티를 리포지토리에 반영
        //우선 리포지토리에 있는 값과 empEnt 아이디 값 같은거 있는지 확인
        Employee target = employeeRepository.findById(empEnt.getId()).orElse(null);
        //대상이 있으면 업데이트
        if(target != null){
            employeeRepository.save(empEnt);
        }

        return "redirect:/employee/" + empEnt.getId();
    }

    @GetMapping("/employee/delete/{id}")
    public String delete(@PathVariable Long id) {
        //삭제할 id에 해당하는 값을 리포지토리로 부터 가져옴
        Employee emp = employeeRepository.findById(id).orElse(null);

        //만약 존재한다면 삭제
        if(emp != null){
            employeeRepository.delete(emp);
        }

        return "redirect:/employee";
    }

}
