package com.Pranav.SpringBookApp.Repository;

import com.Pranav.SpringBookApp.Model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long> {
    Customer findByCustomerEmail(String email);
    Customer findByCustomerName(String name);
    List<Customer> findByCustomerId(Long id);

}
