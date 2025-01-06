package com.example.firstproject.entity;

import com.example.firstproject.dto.PizzaDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private int price;

    public static Pizza createPizza(PizzaDTO dto) {
        return new Pizza (
                null,
                dto.getName(),
                dto.getPrice()
        );
    }

    public void patch(PizzaDTO dto) {
//        if(this.id != dto.getId()) {
//            throw new IllegalArgumentException("엔티티와 dto의 id가 다릅니다.");
//        }
        if(this.name != dto.getName()) {
            this.name = dto.getName();
        }
        if(this.price != dto.getPrice()) {
            this.price = dto.getPrice();
        }

    }
}
