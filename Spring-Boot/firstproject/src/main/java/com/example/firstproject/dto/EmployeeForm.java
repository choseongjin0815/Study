package com.example.firstproject.dto;

import com.example.firstproject.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class EmployeeForm {
    private Long id;

    private String name;

    private int age;


    public Employee toEntity(){
        return new Employee(id, name, age);
    }
}
