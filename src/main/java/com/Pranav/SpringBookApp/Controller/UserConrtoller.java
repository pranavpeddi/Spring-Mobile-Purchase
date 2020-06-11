package com.Pranav.SpringBookApp.Controller;


import com.Pranav.SpringBookApp.Model.Customer;
import com.Pranav.SpringBookApp.Model.DateOfPurchase;
import com.Pranav.SpringBookApp.Model.Mobile;
import com.Pranav.SpringBookApp.Model.Role;
import com.Pranav.SpringBookApp.Repository.CustomerRepository;
import com.Pranav.SpringBookApp.Repository.DateOfPurchaseRepository;
import com.Pranav.SpringBookApp.Service.CustomerDetailService;
import com.Pranav.SpringBookApp.Service.CustomerService;
import com.Pranav.SpringBookApp.Service.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("user")
public class UserConrtoller {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerService customerService;

    @Autowired
    DateOfPurchaseRepository dateOfPurchaseRepository;

    @Autowired
    MobileService mobileService;

    @GetMapping("addCustomer")
    public String bowbow()
    {
        return "saveCustomer";
    }

    @GetMapping("mobileList")
    public String listMobiles(Model model)
    {
        List<Mobile> mobilesliList=mobileService.getall();
        model.addAttribute("mobiles",mobilesliList);
        return "mobileList";
    }

    @GetMapping("singleUser")
    public String sfsfsfs()
    {
        return "showSingleUser";
    }



    @PostMapping("save")
    public String saveNewCustomer(Customer customer, Model theModel, @RequestParam("name")String name,
                                  @RequestParam("email") String email, @RequestParam("password")String password)
    {


        customer.setCustomerEmail(email);
        customer.setCustomerPassword(password);
        customer.setCustomerName(name);
        Set<Role> role=new HashSet<Role>();
        Role r1=new Role();
        r1.setRole("USER");
        role.add(r1);

        customer.setRoles(role);
        customerRepository.save(customer);
        List<Customer> list=customerService.getAll();
        theModel.addAttribute("customers",list);
        return "index";
    }


    @GetMapping("addMobile")
    public String addMobile(@RequestParam("id")long id, Customer customer, Model model, DateOfPurchase dop)
    {

      Mobile mobile=mobileService.searchById(id);
      String name=CustomerDetailService.uname;
      customer=customerService.searchByName(name);
      customer.setMobile(mobile);
      LocalDate localDate=LocalDate.now();
      dop.setDate(localDate);
      dateOfPurchaseRepository.save(dop);
      customer.setDate_of_purchase(dop);
      customerService.save(customer);



      model.addAttribute("name",name);
      model.addAttribute("email",customer.getCustomerEmail());
      model.addAttribute("mobileName",customer.getMobile().getMobileName());
      model.addAttribute("price",customer.getMobile().getPrice());
      return "showSingleUser";

    }



    @PostMapping("addRoles")
    public String addUserByadmin(@RequestBody Customer customer)
    {
        customerRepository.save(customer);
        return "index";
    }
}
