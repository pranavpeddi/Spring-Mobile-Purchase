package com.Pranav.SpringBookApp.Controller;


import com.Pranav.SpringBookApp.Model.Customer;
import com.Pranav.SpringBookApp.Model.Mobile;
import com.Pranav.SpringBookApp.Repository.CustomerRepository;
import com.Pranav.SpringBookApp.Service.CustomerService;
import com.Pranav.SpringBookApp.Service.MobileService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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




    @PreAuthorize("hasAnyRole('ADMIN')")
@GetMapping("addMobile")
public String meowMeow()
{
    return "saveMobile";
}





@PostMapping("saveMobile")
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






@PostMapping("showDetails")
public String showCustomer(Customer customer,@RequestParam("id")long id,Model model)
{
    List<Customer> list1=customerService.findSingleUser(id);

    model.addAttribute("newCustomer",list1);
    return "showSingleUser";
}


@GetMapping("findDate")
public String findDate()
{
    return "searchDate";
}

@GetMapping("piecesSold")
public String mobileSold(Model model)
{
  List<Customer>customers=customerService.getAll();
  int y2=0,iphone=0,celkon=0,note=0,jio=0,vivo=0,honor=0,prime=0;
  for(Customer c1:customers)
  {
      if(c1.getMobile().getMobileId()==13)
      {
          y2++;
      }
      else if(c1.getMobile().getMobileId()==14)
      {
           iphone++;
      }
      else if(c1.getMobile().getMobileId()==15)
      {
        celkon++;
      }
      else if(c1.getMobile().getMobileId()==16)
      {
         note++;
      }
      else if(c1.getMobile().getMobileId()==19)
      {
          jio++;
      }
      else if(c1.getMobile().getMobileId()==33)
      {
         vivo++;
      }
      else if(c1.getMobile().getMobileId()==34)
      {
         honor++;
      }
      else if(c1.getMobile().getMobileId()==35)
      {
            prime++;
      }
      else
      {
          System.out.println("not found anything ");
      }
  }
    model.addAttribute("y2",y2);
    model.addAttribute("iphone",iphone);
    model.addAttribute("celkon",celkon);
    model.addAttribute("note",note);
    model.addAttribute("jio",jio);
    model.addAttribute("vivo",vivo);
    model.addAttribute("honor",honor);
    model.addAttribute("prime",prime);
    return "mobilesSold";
}

@PostMapping("dayList")
    public  String todaysShow(Model model, @RequestParam("date")String date) throws NullPointerException
{


    List<Customer> required=new ArrayList<>();
    List<Customer> list=customerService.getAll();
    DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate d1=LocalDate.parse(date,dateTimeFormatter);
    long sum=0L;

    for(Customer c1:list)
    {

        if(d1.equals(c1.getDate_of_purchase().getDate()))
        {


            required.add(c1);
            sum+=c1.getMobile().getPrice();

        }



    }
 


    model.addAttribute("todaysPurchase",required);
    model.addAttribute("TodaysIncome",sum);
    model.addAttribute("date",d1);
    return "today";
}




    @GetMapping("list")
    public  String listCustomers(Model model)
    {
        List<Customer> list=customerService.getAll();
        model.addAttribute("customers",list);
        return "customerList";
    }


@GetMapping("updateCustomer")
        public String upd(@RequestParam("id")long theId, Model model)
{
    Customer customer=customerService.findById  (theId);
    model.addAttribute("customer",customer);
    return "saveCustomer";
}

@GetMapping("delete")
    public String deleteCustomer(@RequestParam("id")long theid)
{
    customerService.deleteCustomer(theid);
    return "redirect:/customerRel/list";
}


@GetMapping("deleteMobile")
    public String deleteMobile(@RequestParam("id")long mID)
{
    mobileService.deleteMobile(mID);
    return "redirect:/customerRel/mobileList";

}
}
