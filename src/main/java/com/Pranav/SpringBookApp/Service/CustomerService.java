package com.Pranav.SpringBookApp.Service;

import com.Pranav.SpringBookApp.Model.Customer;
import com.Pranav.SpringBookApp.Model.Mobile;
import com.Pranav.SpringBookApp.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {


    @Autowired
private CustomerRepository customerRepository;

    public void save(Customer customer)
    {
        customerRepository.save(customer);
    }

    public List<Customer> getAll()
    {
        return (List<Customer>)customerRepository.findAll();
    }


}
