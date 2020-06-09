package com.Pranav.SpringBookApp.Service;

import com.Pranav.SpringBookApp.Model.Customer;
import com.Pranav.SpringBookApp.Model.Mobile;
import com.Pranav.SpringBookApp.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

   public Customer findByEmail(String email)
   {
       return customerRepository.findByCustomerEmail(email);
   }

   public Customer findById(Long id)
   {
       Optional<Customer> res=customerRepository.findById( id);
       Customer customer1=null;
       if(res.isPresent())
       {
           customer1=res.get();
       }
       else
       {
           throw new RuntimeException("did not find the customer id");
       }
       return customer1;
   }


   public void deleteCustomer(long id)
   {
       customerRepository.deleteById(id);
   }

   public List<Customer> findSingleUser(long id)
   {
       return (List<Customer>) customerRepository.findByCustomerId(id);
   }


}
