package ru.murza.saledelivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.murza.saledelivery.enums.DishCategory;
import ru.murza.saledelivery.models.Composition;
import ru.murza.saledelivery.models.Dish;
import ru.murza.saledelivery.repository.CompositionRepository;
import ru.murza.saledelivery.repository.DishRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishService {

    @Autowired
    private DishRepository dishRepository;

    public List<Dish> findAll(){
        List<Dish> dishes = new ArrayList<>();
        dishRepository.findAll().forEach(dishes::add);
        return dishes;
    }

    public List<Dish> findByDishCategory(DishCategory dishCategory){
        return dishRepository.findByDishCategory(dishCategory);
    }

    public Dish save(Dish dish){
        return dishRepository.save(dish);
    }

    public void deleteById(Long dishId){
        dishRepository.deleteById(dishId);
    }
}
