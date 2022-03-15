package org.cleaningstore.order.controller;

import org.cleaningstore.order.model.Order;
import org.cleaningstore.order.model.OrderStatus;
import org.cleaningstore.order.service.OrderNotFoundException;
import org.cleaningstore.order.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

   private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> findAllOrders(){
        return orderService.findAllOrders();
    }

    @GetMapping("{id}")
    public Order findOrder(@PathVariable long id)throws OrderNotFoundException{
        return orderService.findOrder(id);
    }

}
