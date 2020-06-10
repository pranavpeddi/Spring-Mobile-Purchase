package com.Pranav.SpringBookApp.Service;

import com.Pranav.SpringBookApp.Model.Customer;
import com.Pranav.SpringBookApp.Model.Role;
import com.Pranav.SpringBookApp.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;


@Service
public class CustomerDetailService implements UserDetailsService {


    @Autowired

    private CustomerRepository customerRepository;
   public static String uname="";



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        Customer customer=customerRepository.findByCustomerName(username);
        CustomerUserDetails userDetails=null;
      Set<Role> roles=customer.getRoles();
      roles.stream().forEach(t->System.out.println(t));
        if(customer!=null)
        {

            userDetails=new CustomerUserDetails();
            userDetails.setCustomer(customer);
           uname=username;
            System.out.println(username);

        }
        else
        {
            throw new UsernameNotFoundException("username is not found"+username);
        }
        return userDetails;

    }
}
