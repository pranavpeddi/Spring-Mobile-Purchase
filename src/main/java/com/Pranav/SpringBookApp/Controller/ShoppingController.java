package com.Pranav.SpringBookApp.Controller;


import com.Pranav.SpringBookApp.Model.Customer;
import com.Pranav.SpringBookApp.Model.Mobile;
import com.Pranav.SpringBookApp.Repository.CustomerRepository;
import com.Pranav.SpringBookApp.Service.CustomerService;
import com.Pranav.SpringBookApp.Service.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("customerRel")
public class ShoppingController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerService customerService;

    @Autowired
    MobileService mobileService;

@GetMapping("/addCustomer")
public String bowbow()
{
    return "saveCustomer";
}




public String saveMobile(@ModelAttribute("mobile")Mobile mobile, @RequestParam("customer") int customerNum)
{
  //  mobile.setMyCustomer();
    mobileService.save(mobile);
    return "index";
}

@PostMapping("/save")
public String saveNewCustomer(Customer customer, @RequestParam("name")String name,
                              @RequestParam("email") String email,@RequestParam("password")String password)
{


    customer.setCustomerEmail(email);
    customer.setCustomerpassword(password);
    customer.setCustomerName(name);
    customerRepository.save(customer);
    return "redirect:/customerRel/list";
}


@GetMapping("/list")
    public  String listCustomers(Model model)
{
    List<Customer> list=customerService.getAll();
    model.addAttribute("customers",list);
    return "customerList";
}
}
