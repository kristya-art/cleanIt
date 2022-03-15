package org.cleaningstore;

import org.cleaningstore.customer.model.Address;
import org.cleaningstore.customer.model.CreditCard;
import org.cleaningstore.customer.model.CreditCardType;
import org.cleaningstore.customer.model.Customer;
import org.cleaningstore.customer.repository.CustomerRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

   // OrderRepository orderRepository;

  //  OrderService orderService;

    CustomerRepository customerRepository;

    public DataLoader(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {




//        OrderItem orderItem = new OrderItem(book,1);
//        OrderItem orderItem2 = new OrderItem(book2,3);

        Customer customer1 = new Customer("Alic", "Bon","alic@gmx.com","alicb^^^^",new Address("Mainstreet 45","Zuchwil","SO","4528","Schweiz"),new CreditCard(CreditCardType.VISA,"1234",06,2023));
//        Customer Customer3 = new Customer("Make", "make@gmx.com");
//        Customer Customer2 = new Customer("Karol", "karol@gmx.com");

//			ArrayList<Customer> list = new ArrayList<>();
//			list.add(Customer1);
//			list.add(Customer2);
//			list.add(Customer3);
//        List<OrderItem> orderItems = new ArrayList<>();
//        orderItems.add(orderItem);
//        orderItems.add(orderItem2);
//        Order newOrder = orderService.createOrder(customer1,orderItems);orderItems

//        Order order = new Order(orderItems,OrderStatus.ACCEPTED,new BigDecimal(89.0),new Date(),customer1);
       customerRepository.save(customer1);
//        orderRepository.save(order);
    }
}
