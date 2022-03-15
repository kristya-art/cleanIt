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

        Customer customer1 = new Customer("Alic", "Bon","alic@gmx.com","alicb^^^^",new Address("Mainstreet 45","Zuchwil","SO","4528","Schweiz"),new CreditCard(CreditCardType.VISA,"1234 5678 9123 4567" ,06,2023));
        Customer customer2 = new Customer("Benni", "Bellini","benni@gmx.com","bebe^^^^",new Address("Cherrystreet 5","Bern","BE","3019","Schweiz"),new CreditCard(CreditCardType.VISA,"1234 8976 8934 3487",03,2023));
        Customer customer3 = new Customer("Zamira", "Karimi","zaka@gmx.com","zaka^^^^",new Address("Mangostreet 1","Biel","BE","2500","Schweiz"),new CreditCard(CreditCardType.MASTERCARD,"9836 3635 5324 2837",05,2025));
        Customer customer4 = new Customer("Alessandro", "Pinelli","shiriagina@yahoo.com","alpi^^^",new Address("Pineapplestreet 13","Zurich","ZU","8000","Schweiz"),new CreditCard(CreditCardType.VISA,"2963 7437 3737 9538",01,2024));



//        Customer Customer3 = new Customer("Make", "make@gmx.com");
//        Customer Customer2 = new Customer("Karol", "karol@gmx.com");

			ArrayList<Customer> list = new ArrayList<>();
			list.add(customer1);
			list.add(customer2);
			list.add(customer3);
            list.add(customer4);

            for(Customer c:list){
                customerRepository.save(c);
            }

 //       List<OrderItem> orderItems = new ArrayList<>();
//        orderItems.add(orderItem);
//        orderItems.add(orderItem2);
//        Order newOrder = orderService.createOrder(customer1,orderItems);orderItems

//        Order order = new Order(orderItems,OrderStatus.ACCEPTED,new BigDecimal(89.0),new Date(),customer1);

//        orderRepository.save(order);
    }
}
