package org.cleaningstore.order.controller;

import com.sun.istack.NotNull;
import org.cleaningstore.EmailSenderService;
import org.cleaningstore.customer.service.CustomerNotFoundException;
import org.cleaningstore.order.model.Order;
import org.cleaningstore.order.model.OrderInfo;
import org.cleaningstore.order.model.OrderStatus;
import org.cleaningstore.order.service.OrderNotFoundException;
import org.cleaningstore.order.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
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

    @PutMapping("{id}")
    public void updateOrder(@PathVariable long id,@RequestBody Order order)
    throws OrderNotFoundException{
        orderService.updateOrder(order);
    }

    @GetMapping("/search")
    public List<OrderInfo> searchOrders(@RequestParam @NotNull long customerId)
            throws CustomerNotFoundException {
        return orderService.searchOrders2(customerId);
    }

}
