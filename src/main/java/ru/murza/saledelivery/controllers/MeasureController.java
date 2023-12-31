package ru.murza.saledelivery.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ru.murza.saledelivery.dto.MeasureDTO;
import ru.murza.saledelivery.models.Measure;
import ru.murza.saledelivery.service.MeasureService;
import ru.murza.saledelivery.util.Mapper;

import java.util.List;

@RestController
@Transactional
@RequestMapping("/measure")
public class MeasureController {

    @Autowired
    private MeasureService measureService;

    @GetMapping
    public ResponseEntity<List<MeasureDTO>> getMeasure(){
        List<MeasureDTO> measureDTOList = measureService.getMeasures()
                .stream()
                .map(measure -> Mapper.modelMapper.map(measure, MeasureDTO.class))
                .toList();
        return new ResponseEntity<>(measureDTOList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MeasureDTO> addMeasure(@RequestBody MeasureDTO measureDTO){
        Measure measure = Mapper.modelMapper.map(measureDTO, Measure.class);
        MeasureDTO outMeasureDTO = Mapper.modelMapper.map(measureService.save(measure), MeasureDTO.class);
        return new ResponseEntity<>(outMeasureDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{measureId}")
    public ResponseEntity<MeasureDTO> putMeasure(@PathVariable("measureId") Long measureId,
                                                 @RequestBody MeasureDTO measureDTO){
        Measure measure = Mapper.modelMapper.map(measureDTO, Measure.class);
        MeasureDTO outMeasureDTO = Mapper.modelMapper.map(measureService.putMeasure(measureId, measure), MeasureDTO.class);
        return new ResponseEntity<>(outMeasureDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{measureId}")
    public ResponseEntity<?> deleteMeasure (@PathVariable("measureId") Long measureId){
        measureService.deleteById(measureId);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
