package org.cleaningstore.customer.controller;

import com.sun.istack.NotNull;
import org.cleaningstore.customer.model.Customer;
import org.cleaningstore.customer.service.CustomerNotFoundException;
import org.cleaningstore.customer.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;


@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("{id}")
    public Customer findCustomer(@PathVariable long id) throws CustomerNotFoundException {return  customerService.findCustomer(id);
    }

    @GetMapping()
    public Customer findCustomer(@RequestParam @NotNull String email) throws CustomerNotFoundException {
        return  customerService.findCustomer(email);
    }


}
