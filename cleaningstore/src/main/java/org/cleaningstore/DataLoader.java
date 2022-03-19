package org.cleaningstore;

import org.cleaningstore.catalog.model.Material;
import org.cleaningstore.customer.controller.CustomerController;
import org.cleaningstore.customer.model.Address;
import org.cleaningstore.customer.model.CreditCard;
import org.cleaningstore.customer.model.CreditCardType;
import org.cleaningstore.customer.model.Customer;
import org.cleaningstore.customer.repository.CustomerRepository;
import org.cleaningstore.order.model.Order;
import org.cleaningstore.order.model.OrderItem;
import org.cleaningstore.order.model.ProductInfo;
import org.cleaningstore.order.service.OrderService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {


    CustomerRepository customerRepository;
    OrderService orderService;
    CustomerController customerController;

    public DataLoader(CustomerRepository customerRepository, OrderService orderService,
    CustomerController customerController) {
        this.customerRepository = customerRepository;
        this.orderService = orderService;
        this.customerController = customerController;

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {


        // create customers
        Customer customer1 = new Customer("Alic", "Bon","alic@gmx.com","alicb^^^^",new Address("Mainstreet 45","Zuchwil","SO","4528","Schweiz"),new CreditCard(CreditCardType.VISA,"1234 5678 9123 4567" ,06,2023));
        Customer customer2 = new Customer("Benni", "Bellini","shiriagina@yahoo.com","bebe^^^^",new Address("Cherrystreet 5","Bern","BE","3019","Schweiz"),new CreditCard(CreditCardType.VISA,"1234 8976 8934 3487",03,2023));
        Customer customer3 = new Customer("Zamira", "Karimi","zaka@gmx.com","zaka^^^^",new Address("Mangostreet 1","Biel","BE","2500","Schweiz"),new CreditCard(CreditCardType.MASTERCARD,"9836 3635 5324 2837",05,2025));
        Customer customer4 = new Customer("Alessandro", "Pinelli","pinelli@yahoo.com","alpi^^^",new Address("Pineapplestreet 13","Zurich","ZU","8000","Schweiz"),new CreditCard(CreditCardType.VISA,"2963 7437 3737 9538",01,2024));

            ArrayList<Customer> list = new ArrayList<>();
			list.add(customer1);
			list.add(customer2);
			list.add(customer3);
            list.add(customer4);

            for(Customer c:list){
                customerRepository.save(c);
            }
        //create orderItems
        OrderItem oi1 = new OrderItem(new ProductInfo("shirt", Material.LINE,new BigDecimal(5.0)),1);
        OrderItem oi2 = new OrderItem(new ProductInfo("duvet", Material.COTTON,new BigDecimal(10.0)),2);
        OrderItem oi3 = new OrderItem(new ProductInfo("blouse", Material.LINE,new BigDecimal(6.5)),3);
        OrderItem oi4 = new OrderItem(new ProductInfo("dress", Material.COTTON,new BigDecimal(7.0)),2);

        List<OrderItem> orderItems12 = new ArrayList<>();
        List<OrderItem> orderItems34 = new ArrayList<>();
        orderItems12.add(oi1);
        orderItems12.add(oi2);

        orderItems34.add(oi3);
        orderItems34.add(oi4);


        Order order1 = orderService.placeOrder(customer1.getId(),orderItems12);

        Order order2 = orderService.placeOrder(customer2.getId(),orderItems34);

      //   customerController.sendEmail(customer2.getId());

     //   Order order = new Order(orderItems,OrderStatus.ACCEPTED,new BigDecimal(89.0),new Date(),customer1);

//        orderRepository.save(order);
    }
}
