package com.Pranav.SpringBookApp.Model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
public class Customer {

    @Id
    @GeneratedValue
    private long customerId;
    private String customerName;
    private String customerEmail;
    private String Customerpassword;



    public String getCustomerpassword() {
        return Customerpassword;
    }

    public void setCustomerpassword(String customerpassword) {
        Customerpassword = customerpassword;
    }

    public List<Mobile> getMobiles() {
        return mobiles;
    }

    public void setMobiles(List<Mobile> mobiles) {
        this.mobiles = mobiles;
    }

    @OneToMany(mappedBy = "myCustomer")
    private List<Mobile> mobiles=new ArrayList<>();

    public Customer() {
    }

    //public  Customer

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long custId) {
        this.customerId = custId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

}
