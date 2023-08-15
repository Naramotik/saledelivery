package ru.murza.saledelivery.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.murza.saledelivery.models.Dish;

@Repository
public interface DishRepository extends CrudRepository<Dish, Long> {
}
