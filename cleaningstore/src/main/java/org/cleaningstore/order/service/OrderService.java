package org.cleaningstore.order.service;

import org.cleaningstore.customer.model.Customer;
import org.cleaningstore.customer.repository.CustomerRepository;
import org.cleaningstore.customer.service.CustomerNotFoundException;
import org.cleaningstore.customer.service.CustomerService;
import org.cleaningstore.order.model.Order;
import org.cleaningstore.order.model.OrderInfo;
import org.cleaningstore.order.model.OrderItem;
import org.cleaningstore.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static org.cleaningstore.order.model.OrderStatus.ACCEPTED;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private CustomerService customerService;


    public OrderService(OrderRepository orderRepository, CustomerService customerService) {
        this.orderRepository = orderRepository;
        this.customerService = customerService;
    }

    private Order createOrder(Customer customer, List<OrderItem> items) {
        BigDecimal amount = BigDecimal.ZERO;
        for(OrderItem item: items){
            amount = amount.add(item.getProduct().getPrice().multiply(new BigDecimal(item.getQuantity())));
        }
        return new Order(new Date(), amount, ACCEPTED, customer,items);
    }

    public Order placeOrder(long customerId, List<OrderItem> items)throws CustomerNotFoundException{
        Customer customer = customerService.findCustomer(customerId);
        Order order = createOrder(customer,items);
        orderRepository.save(order);
        return order;
    }

    public void updateOrder(Order order) throws OrderNotFoundException{
      Order existingOrder =  orderRepository.findById(order.getId()).orElseThrow(OrderNotFoundException::new);
      existingOrder.setStatus(order.getStatus());
      existingOrder.setAmount(order.getAmount());
      orderRepository.save(existingOrder);
    }

    public List<Order> findAllOrders(){
        return orderRepository.findAll();
    }

    public Order findOrder(long id) throws OrderNotFoundException{
        Order order = orderRepository.findById(id).orElseThrow(OrderNotFoundException::new);
        return order;
    }

    public List<OrderInfo> searchOrders(long customerId, Integer year) throws CustomerNotFoundException{
        Customer customer = customerService.findCustomer(customerId);
        Date startDate = new GregorianCalendar(year,0,1).getTime();
        Date endDate = new GregorianCalendar(year+1,0,1).getTime();
        return orderRepository.findByCustomerIdAndDateBetween(customerId,startDate,endDate);

    }
    public List<OrderInfo> searchOrders2(long customerId) throws CustomerNotFoundException{
        Customer customer1 = customerService.findCustomer(customerId);
        return orderRepository.findByCustomerId(customerId);
    }
}

