package ru.murza.saledelivery.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.murza.saledelivery.models.Measure;
import ru.murza.saledelivery.service.MeasureService;

import java.util.List;

@RestController
@RequestMapping("/measure")
public class MeasureController {

    @Autowired
    private MeasureService measureService;

    @GetMapping
    public ResponseEntity<List<Measure>> getMeasure(){
        return new ResponseEntity<>(measureService.getMeasures(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Measure> addMeasure(@RequestBody Measure measure){
        return new ResponseEntity<>(measureService.save(measure), HttpStatus.CREATED);
    }

    @PutMapping("/{measureId}")
    public ResponseEntity<Measure> putMeasure(@PathVariable("measureId") Long measureId,
                                              @RequestBody Measure measure){
        return new ResponseEntity<>(measureService.putMeasure(measureId, measure), HttpStatus.OK);
    }

    @DeleteMapping("/{measureId}")
    public ResponseEntity<?> deleteMeasure (@PathVariable("measureId") Long measureId){
        measureService.deleteById(measureId);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
