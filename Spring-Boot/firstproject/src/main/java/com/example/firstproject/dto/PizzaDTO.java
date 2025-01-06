package com.example.firstproject.dto;

import com.example.firstproject.entity.Pizza;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PizzaDTO {
    private Long id;
    private String name;
    private int price;


    public static PizzaDTO createPizzaDTO(Pizza pizza) {
        return new PizzaDTO(
                pizza.getId(),
                pizza.getName(),
                pizza.getPrice()
        );
    }
}
