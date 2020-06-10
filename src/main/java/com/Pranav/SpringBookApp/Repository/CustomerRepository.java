package com.Pranav.SpringBookApp.Repository;

import com.Pranav.SpringBookApp.Model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long> {
    Customer findByCustomerEmail(String email);
    Customer findByCustomerName(String name);
    List<Customer> findByCustomerId(long id);






}
