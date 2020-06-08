package com.Pranav.SpringBookApp.Repository;

import com.Pranav.SpringBookApp.Model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long> {

}
