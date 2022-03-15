package org.cleaningstore.customer.service;

import org.cleaningstore.customer.model.Customer;
import org.cleaningstore.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {

    private CustomerRepository customerRepository;

  //  private PasswordEncoder passwordEncoder;


    public CustomerService(CustomerRepository customerRepository
     //                      ,PasswordEncoder passwordEncoder
    ) {
        this.customerRepository = customerRepository;
     //   this.passwordEncoder = passwordEncoder;
    }

    public Customer findCustomer(long id) throws CustomerNotFoundException{
        Customer customer = customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
        return customer;
    }

    public Customer findCustomer(String email) throws CustomerNotFoundException{
        Customer customer = customerRepository.findByEmail(email).orElseThrow(CustomerNotFoundException::new);
        return customer;
    }
}
