package ru.murza.saledelivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.murza.saledelivery.models.Order;
import ru.murza.saledelivery.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll(){
        List<Order> orders = new ArrayList<>();
        orderRepository.findAll().forEach(orders::add);
        return orders;
    }

    public Order save(Order order){
        return orderRepository.save(order);
    }

    public void deleteById(Long orderId){
        orderRepository.deleteById(orderId);
    }
}
