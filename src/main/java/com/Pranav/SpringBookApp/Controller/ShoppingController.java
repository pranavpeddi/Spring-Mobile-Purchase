package com.Pranav.SpringBookApp.Controller;


import com.Pranav.SpringBookApp.Model.Customer;
import com.Pranav.SpringBookApp.Model.Mobile;
import com.Pranav.SpringBookApp.Repository.CustomerRepository;
import com.Pranav.SpringBookApp.Service.CustomerService;
import com.Pranav.SpringBookApp.Service.MobileService;
import com.sun.org.apache.regexp.internal.RE;
import com.sun.org.apache.xpath.internal.operations.Mod;
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

@GetMapping("/addMobile")
public String meowMeow()
{
    return "saveMobile";
}


@PostMapping("/saveMobile")
public String saveMobile(Mobile mobile, @RequestParam("mobileRam")String ram,@RequestParam("mobileProcessor")String processor,

                          @RequestParam("mobileName")String name,@RequestParam("price")Long price,@RequestParam("email")
                         String email)

{
    mobile.setMobileName(name);
    mobile.setPrice(price);
    mobile.setProcessor(processor);
    mobile.setRamSize(ram);
    Customer cus1=customerService.findByEmail(email);
    mobile.setMyCustomer(cus1);
    mobileService.save(mobile);
    return "redirect:/customerRel/mobileList";
}

@PostMapping("/save")
public String saveNewCustomer(Customer customer,Model theModel, @RequestParam("name")String name,
                              @RequestParam("email") String email,@RequestParam("password")String password)
{


    customer.setCustomerEmail(email);
    customer.setCustomerpassword(password);
    customer.setCustomerName(name);
    customerRepository.save(customer);
    List<Customer> list=customerService.getAll();
    theModel.addAttribute("customers",list);
    return "redirect:/customerRel/list";
}


@GetMapping("/list")
    public  String listCustomers(Model model)
{
    List<Customer> list=customerService.getAll();
    model.addAttribute("customers",list);
    return "customerList";
}


@GetMapping("/mobileList")
    public String listMobiles(Model model)
{
    List<Mobile> mobilesliList=mobileService.getall();
    model.addAttribute("mobiles",mobilesliList);
    return "mobileList";
}

@GetMapping("/updateCustomer")
        public String upd(@RequestParam("id")long theId, Model model)
{
    Customer customer=customerService.findById  (theId);
    model.addAttribute("customer",customer);
    return "saveCustomer";
}

@GetMapping("/delete")
    public String deleteCustomer(@RequestParam("id")long theid)
{
    customerService.deleteCustomer(theid);
    return "redirect:/customerRel/list";
}


@GetMapping("/deleteMobile")
    public String deleteMobile(@RequestParam("id")long mID)
{
    mobileService.deleteMobile(mID);
    return "redirect:/customerRel/mobileList";

}
}
