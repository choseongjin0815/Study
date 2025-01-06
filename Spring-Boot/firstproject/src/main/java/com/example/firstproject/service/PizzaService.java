package com.example.firstproject.service;

import com.example.firstproject.dto.PizzaDTO;
import com.example.firstproject.entity.Pizza;
import com.example.firstproject.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PizzaService {
    @Autowired
    PizzaRepository pizzaRepository;
    public PizzaDTO pizza(Long id) {
        Pizza pizza = pizzaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("조회를 위해 일치하는 id가 없습니다."));
        return PizzaDTO.createPizzaDTO(pizza);
    }
    public List<PizzaDTO> pizza() {
        return pizzaRepository.findAll()
                .stream()
                .map(pizza -> PizzaDTO.createPizzaDTO(pizza))
                .collect(Collectors.toList());

    }

    public PizzaDTO create(PizzaDTO dto) {
        Pizza pizza = Pizza.createPizza(dto);
        Pizza created = pizzaRepository.save(pizza);
        return PizzaDTO.createPizzaDTO(created);
    }

    public PizzaDTO update(Long id, PizzaDTO dto) {
        Pizza target = pizzaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("일치하는 아이디가 없습니다."));
        target.patch(dto);

        Pizza updated = pizzaRepository.save(target);

        return PizzaDTO.createPizzaDTO(updated);

    }

    public PizzaDTO delete(Long id) {
        Pizza target = pizzaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("일치하는 id가 없습니다."));

        pizzaRepository.delete(target);

        return PizzaDTO.createPizzaDTO(target);
    }
}
