package ru.murza.saledelivery.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.murza.saledelivery.models.Order;
import ru.murza.saledelivery.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        return new ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Order> save(@RequestBody Order order){
        return new ResponseEntity<>(orderService.save(order), HttpStatus.CREATED);
    }

    @DeleteMapping("/orderId")
    public ResponseEntity<?> delete(@PathVariable("orderId") Long orderId){
        orderService.deleteById(orderId);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
