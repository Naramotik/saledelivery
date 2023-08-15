package ru.murza.saledelivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.murza.saledelivery.models.Composition;
import ru.murza.saledelivery.models.Ingredient;
import ru.murza.saledelivery.repository.CompositionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompositionService {

    @Autowired
    private CompositionRepository compositionRepository;

    public List<Composition> findAll(){
        List<Composition> compositions = new ArrayList<>();
        compositionRepository.findAll().forEach(compositions::add);
        return compositions;
    }

    public Composition save(Composition composition){
        return compositionRepository.save(composition);
    }

    public void deleteById(Long compositionId){
        compositionRepository.deleteById(compositionId);
    }
}
