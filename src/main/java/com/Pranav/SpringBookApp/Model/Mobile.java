package com.Pranav.SpringBookApp.Model;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity

public class Mobile
{
   @Id
   @GeneratedValue
   private long mobileId;
   private String mobileName;
   private String ramSize;
   private String processor;
   private long price;
   private LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @OneToMany(mappedBy = "mobile")

    List<Customer> customers=new ArrayList<>();

    public long getMobileId() {
        return mobileId;
    }


    public void setMobileId(long mobileId) {
        this.mobileId = mobileId;
    }

    public String getMobileName() {
        return mobileName;
    }

    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    public String getRamSize() {
        return ramSize;
    }

    public void setRamSize(String ramSize) {
        this.ramSize = ramSize;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "mobileId=" + mobileId +
                ", mobileName='" + mobileName + '\'' +
                ", ramSize='" + ramSize + '\'' +
                ", processor='" + processor + '\'' +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}
