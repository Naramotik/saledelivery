package ru.murza.saledelivery.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.murza.saledelivery.models.Composition;
import ru.murza.saledelivery.service.CompositionService;

import java.util.List;

@RestController
@RequestMapping("/composition")
public class CompositionController {

    @Autowired
    private CompositionService compositionService;

    @GetMapping
    public ResponseEntity<List<Composition>> findAll(){
        return new ResponseEntity<>(compositionService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Composition> save(Composition composition){
        return new ResponseEntity<>(compositionService.save(composition), HttpStatus.CREATED);
    }

    @DeleteMapping("/compositionId")
    public ResponseEntity<?> delete(@PathVariable("compositionId") Long compositionId){
        compositionService.deleteById(compositionId);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
