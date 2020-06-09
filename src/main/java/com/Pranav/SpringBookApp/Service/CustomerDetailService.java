package com.Pranav.SpringBookApp.Service;

import com.Pranav.SpringBookApp.Model.Customer;
import com.Pranav.SpringBookApp.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomerDetailService implements UserDetailsService {


    @Autowired

    private CustomerRepository customerRepository;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer=customerRepository.findByCustomerName(username);
        CustomerUserDetails userDetails=null;
        if(customer!=null)
        {
            userDetails=new CustomerUserDetails();
            userDetails.setCustomer(customer);
        }
        else
        {
            throw new UsernameNotFoundException("username is not found"+username);
        }
        return userDetails;

    }
}
