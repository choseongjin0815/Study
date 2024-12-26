package com.example.firstproject.dto;

import com.example.firstproject.entity.Coffee;
import lombok.ToString;

@ToString
public class CoffeeDTO {
    public Long id;
    public String name;
    public int price;

    public Coffee toEntity() {
        return new Coffee(id, name, price);
    }
}
