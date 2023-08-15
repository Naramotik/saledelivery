package ru.murza.saledelivery.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.murza.saledelivery.models.Dish;
import ru.murza.saledelivery.service.DishService;


import java.util.List;

@RestController
@RequestMapping("/dish")
public class DishController {

    @Autowired
    private DishService dishService;

    @GetMapping
    public ResponseEntity<List<Dish>> findAll(){
        return new ResponseEntity<>(dishService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Dish> save(Dish dish){
        return new ResponseEntity<>(dishService.save(dish), HttpStatus.CREATED);
    }

    @DeleteMapping("/dishId")
    public ResponseEntity<?> delete(@PathVariable("dishId") Long dishId){
        dishService.deleteById(dishId);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
