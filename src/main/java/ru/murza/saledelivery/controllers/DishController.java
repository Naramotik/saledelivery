package ru.murza.saledelivery.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.murza.saledelivery.dto.DishDTO;
import ru.murza.saledelivery.models.Dish;
import ru.murza.saledelivery.service.DishService;
import ru.murza.saledelivery.util.Mapper;


import java.util.List;

@RestController
@RequestMapping("/dish")
public class DishController {

    @Autowired
    private DishService dishService;

    @GetMapping
    public ResponseEntity<List<DishDTO>> findAll(){
        List<DishDTO> dishDTO = dishService.findAll()
                .stream()
                .map(dish -> Mapper.modelMapper.map(dish, DishDTO.class))
                .toList();
        return new ResponseEntity<>(dishDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DishDTO> save(@RequestBody Dish dish){
        DishDTO dishDTO = Mapper.modelMapper.map(dishService.save(dish), DishDTO.class);
        return new ResponseEntity<>(dishDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/dishId")
    public ResponseEntity<?> delete(@PathVariable("dishId") Long dishId){
        dishService.deleteById(dishId);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
