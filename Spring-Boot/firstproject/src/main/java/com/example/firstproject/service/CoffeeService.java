package com.example.firstproject.service;

import com.example.firstproject.dto.CoffeeDTO;
import com.example.firstproject.entity.Coffee;
import com.example.firstproject.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@Service
public class CoffeeService {
    @Autowired
    private CoffeeRepository coffeeRepository;

    public List<Coffee> index() {
        return coffeeRepository.findAll();
    }

    public Coffee show(Long id) {
        return coffeeRepository.findById(id).orElse(null);
    }

    public Coffee create(CoffeeDTO dto) {
        log.info(dto.toString());
        Coffee coffee = dto.toEntity();
        if(coffee.getId() != null) {
            return null;
        }
        return coffeeRepository.save(coffee);

    }

    public List<Coffee> createList(List<CoffeeDTO> dtos){
        List<Coffee> coffeeList = dtos.stream()
                .map(dto -> dto.toEntity())
                .collect(Collectors.toList());
        coffeeList.stream()
                .forEach(coffee -> coffeeRepository.save(coffee));
        coffeeRepository.findById(-1L)
                .orElseThrow(() -> new IllegalArgumentException("리스트 호출 실패!"));

        return coffeeList;

    }

    public Coffee update(Long id, CoffeeDTO dto) {
        Coffee coffee = dto.toEntity();
        Coffee target = coffeeRepository.findById(id).orElse(null);

        if(target == null || id != coffee.getId()) {
            return null;
        }
        target.patch(coffee);

        Coffee updated = coffeeRepository.save(target);

        return updated;
    }

    public Coffee delete(Long id) {
        Coffee target = coffeeRepository.findById(id).orElse(null);

        if(target == null) {
            return null;
        }
        coffeeRepository.delete(target);
        return target;


    }
}
