package com.example.firstproject.api;

import com.example.firstproject.dto.PizzaDTO;
import com.example.firstproject.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PizzaApiController {
    @Autowired
    PizzaService pizzaService;
    //1.조회
    //1-1. 단건 조회
    @GetMapping("/api/pizza/{id}")
    public ResponseEntity<PizzaDTO> show(@PathVariable Long id){
        //서비스에 위임
        PizzaDTO dto = pizzaService.pizza(id);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    //1-2. 목록 조회
    @GetMapping("/api/pizza")
    public ResponseEntity<List<PizzaDTO>> showAll() {
        //서비스에 위임
        List<PizzaDTO> dtos = pizzaService.pizza();
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }
    //2.생성
    @PostMapping("/api/pizza")
    public ResponseEntity<PizzaDTO> create(@RequestBody PizzaDTO dto) {
        //서비스에 위임
        PizzaDTO pizza = pizzaService.create(dto);

        //결과 반환
        return ResponseEntity.status(HttpStatus.OK).body(pizza);
    }
    //3.수정
    @PatchMapping("/api/pizza/{id}")
    public ResponseEntity<PizzaDTO> update(@PathVariable Long id,
                                           @RequestBody PizzaDTO dto) {
        //서비스에 위임
        PizzaDTO updatedDTO = pizzaService.update(id, dto);

        //결과 반환
        return ResponseEntity.status(HttpStatus.OK).body(updatedDTO);
    }
    //4.삭제
    @DeleteMapping("/api/pizza/{id}")
    public ResponseEntity<PizzaDTO> delete(@PathVariable Long id) {
        //서비스에 위임
        PizzaDTO deletedDTO = pizzaService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).body(deletedDTO);


    }
}
