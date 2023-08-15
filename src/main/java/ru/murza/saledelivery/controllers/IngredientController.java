package ru.murza.saledelivery.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.murza.saledelivery.models.Ingredient;
import ru.murza.saledelivery.service.IngredientService;

import java.util.List;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @GetMapping
    public ResponseEntity<List<Ingredient>> findAll(){
        return new ResponseEntity<>(ingredientService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Ingredient> save(Ingredient ingredient){
        return new ResponseEntity<>(ingredientService.save(ingredient), HttpStatus.CREATED);
    }

    @DeleteMapping("/ingredientId")
    public ResponseEntity<?> delete(@PathVariable("ingredientId") Long ingredientId){
        ingredientService.deleteById(ingredientId);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
