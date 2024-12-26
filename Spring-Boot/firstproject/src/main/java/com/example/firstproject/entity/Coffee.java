package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;


@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private int price;

    public Long getId() {
        return id;
    }

    public void patch(Coffee coffee) {
        if(coffee.name != null) {
            this.name = coffee.name;
        }

        if(coffee.price > 0) {
            this.price = coffee.price;
        }
    }
}
