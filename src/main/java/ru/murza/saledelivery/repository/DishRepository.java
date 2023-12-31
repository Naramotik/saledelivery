package ru.murza.saledelivery.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.murza.saledelivery.enums.DishCategory;
import ru.murza.saledelivery.models.Dish;

import java.util.List;

@Repository
public interface DishRepository extends CrudRepository<Dish, Long> {

    @Transactional
    @Query("from Dish dish where dishCategory = :dishCategory")
    List<Dish> findByDishCategory(@Param("dishCategory") DishCategory dishCategory);
}
