package com.Pranav.SpringBookApp.Controller;


import com.Pranav.SpringBookApp.Model.Customer;
import com.Pranav.SpringBookApp.Model.Mobile;
import com.Pranav.SpringBookApp.Repository.CustomerRepository;
import com.Pranav.SpringBookApp.Service.CustomerService;
import com.Pranav.SpringBookApp.Service.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/customerRel")
public class ShoppingController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerService customerService;

    @Autowired
    MobileService mobileService;



@GetMapping("/")
public String index()
{
    return "index";
}

@GetMapping("/addMobile")
public String meowMeow()
{
    return "saveMobile";
}




@PostMapping("/saveMobile")
public String saveMobile(Mobile mobile, @RequestParam("mobileRam")String ram,@RequestParam("mobileProcessor")String processor,

                          @RequestParam("mobileName")String name,@RequestParam("price")Long price
                         )

{
    mobile.setMobileName(name);
    mobile.setPrice(price);
    mobile.setProcessor(processor);
    mobile.setRamSize(ram);

  //  mobile.setMyCustomer(cus1);
    mobileService.save(mobile);

    return "redirect:/user/mobileList";
}






@PostMapping("/showDetails")
public String showCustomer(Customer customer,@RequestParam("id")long id,Model model)
{
    List<Customer> list1=customerService.findSingleUser(id);

    model.addAttribute("newCustomer",list1);
    return "showSingleUser";
}

@GetMapping("/dayList")
    public  String todaysShow(Model model) throws NullPointerException
{


    List<Customer> required=new ArrayList<>();
    LocalDate date=LocalDate.now();
    List<Customer> list=customerService.getAll();

    long sum=0L;

    for(Customer c1:list)
    {

        if(date.equals(c1.getMobile().getDate()))
        {
            System.out.println(c1);
            required.add(c1);
            sum+=sum+c1.getMobile().getPrice();
            System.out.println(c1);
        }
        sum=sum+c1.getMobile().getPrice();


    }
    required.stream().forEach(t->System.out.println(t));
    model.addAttribute("todaysPurchase",list);
    model.addAttribute("TodaysIncome",sum);
    return "today";
}




    @GetMapping("/list")
    public  String listCustomers(Model model)
    {
        List<Customer> list=customerService.getAll();
        model.addAttribute("customers",list);
        return "customerList";
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
