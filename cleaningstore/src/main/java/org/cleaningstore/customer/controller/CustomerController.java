package org.cleaningstore.customer.controller;

import com.sun.istack.NotNull;
import org.cleaningstore.EmailSenderService;
import org.cleaningstore.customer.model.Customer;
import org.cleaningstore.customer.service.CustomerNotFoundException;
import org.cleaningstore.customer.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;
    private EmailSenderService emailService;

    public CustomerController(CustomerService customerService, EmailSenderService emailService) {
        this.customerService = customerService;
        this.emailService = emailService;
    }

    @GetMapping("{id}")
    public Customer findCustomer(@PathVariable long id) throws CustomerNotFoundException {return  customerService.findCustomer(id);
    }

//    @GetMapping("{email}")
//    public Customer findCustomerByEmail(@RequestParam @NotNull String email) throws CustomerNotFoundException {
//        return  customerService.findCustomer(email);
//    }

    @GetMapping()
    public List<Customer> findAllCustomers(){
        return customerService.findAllCustomers();
    }

    @PostMapping("/sendEmail/{id}")
    public ResponseEntity<String> sendEmail(@PathVariable long id) throws CustomerNotFoundException{
        Customer customer = customerService.findCustomer(id);
        emailService.sendSimpleEmail(customer.getEmail(),
                "Hi dear customer! Your order is " +
                       "ready to pick up","Your order is waiting for you"
                );

        return new ResponseEntity<>("mail sent successfully", HttpStatus.OK);
    }

//    @PutMapping("/update/{id}")
//    Customer update(@RequestBody Customer newCustomer, @PathVariable Long id) {


//    public void sendEmail(@PathVariable long id) throws CustomerNotFoundException{
//        Customer customer = customerService.findCustomer(id);
//        emailService.sendSimpleEmail(customer.getEmail(),
//                "Hi dear customer! Your order is " +
//                        "ready to pick up","Your order is waiting for you");
//
//    }


}
