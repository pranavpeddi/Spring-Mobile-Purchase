package com.Pranav.SpringBookApp.Model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity
public class Customer {

    @Id
    @GeneratedValue
    private long customerId;
    private String customerName;
    private String customerEmail;
    private String customerPassword;

    @ManyToOne
    private Mobile mobile;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name="customer_role",joinColumns = @JoinColumn(name = "customer_id"),inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<Role> roles;


    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }





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

    public Mobile getMobile() {
        return mobile;
    }

    public void setMobile(Mobile mobile) {
        this.mobile = mobile;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerPassword='" + customerPassword + '\'' +
                ", mobile=" + mobile +
                ", roles=" + roles +
                '}';
    }
}
