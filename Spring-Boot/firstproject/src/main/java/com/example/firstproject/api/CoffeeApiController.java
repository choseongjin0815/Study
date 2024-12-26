package com.example.firstproject.api;

import com.example.firstproject.dto.CoffeeDTO;
import com.example.firstproject.entity.Coffee;
import com.example.firstproject.repository.CoffeeRepository;
import com.example.firstproject.service.CoffeeService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class CoffeeApiController {
//    @Autowired
//    private CoffeeRepository coffeeRepository;
    @Autowired
    private CoffeeService coffeeService;


//
//
//    //조회
    @GetMapping("/api/coffee")
    public List<Coffee> list() {
        return coffeeService.index();
    }

    @GetMapping("/api/coffee/{id}")
    public Coffee view(@PathVariable Long id) {
        return coffeeService.show(id);
    }

    //삽입
    @PostMapping("/api/coffee")
    public ResponseEntity<Coffee> create(@RequestBody CoffeeDTO dto) {
        Coffee created = coffeeService.create(dto);
        return (created != null) ?
            ResponseEntity.status(HttpStatus.OK).body(created) :
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
//
    //수정
    @PatchMapping("/api/coffee/{id}")
    public ResponseEntity<Coffee> update(@PathVariable Long id, @RequestBody CoffeeDTO dto) {
        Coffee updated = coffeeService.update(id, dto);
        return (updated != null) ?
                ResponseEntity.status(HttpStatus.OK).body(updated) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

//        Coffee coffee = dto.toEntity();
//        Coffee target = coffeeRepository.findById(id).orElse(null);
//
//        if(target == null || id != coffee.getId()){
//            log.info("잘못된 요청 id : {}, coffee : {}", id, coffee.toString());
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }
//        target.patch(coffee);
//        log.info(target.toString());
//        Coffee updated = coffeeRepository.save(target);
//        log.info(updated.toString());
//        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }
//
    //삭제
    @DeleteMapping("/api/coffee/{id}")
    public ResponseEntity<Coffee> delete(@PathVariable Long id) {
        Coffee deleted = coffeeService.delete(id);

        return (deleted != null) ?
            ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }
    @Transactional
    @PostMapping("/api/coffee-transaction")
    public ResponseEntity<List<Coffee>> transactionTest(@RequestBody List<CoffeeDTO> dtos){
        List<Coffee> coffeeList = coffeeService.createList(dtos);

        return (coffeeList != null) ?
                ResponseEntity.status(HttpStatus.OK).body(coffeeList) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }



}
