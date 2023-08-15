package ru.murza.saledelivery.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.murza.saledelivery.models.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
