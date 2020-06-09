package com.Pranav.SpringBookApp.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class newCustomer {
    @Id
    @GeneratedValue
    private long CustomerId;

  @ManyToOne
    private Mobile newMobile;
}
