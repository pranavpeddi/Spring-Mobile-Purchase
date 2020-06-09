package com.Pranav.SpringBookApp.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserConrtoller {


    @GetMapping("/addCustomer")
    public String bowbow()
    {
        return "saveCustomer";
    }
}
