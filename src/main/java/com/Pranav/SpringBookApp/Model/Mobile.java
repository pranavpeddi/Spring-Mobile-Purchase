package com.Pranav.SpringBookApp.Model;


import javax.persistence.*;
import java.util.ArrayList;
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



  @ManyToOne
  private Customer myCustomer;

   @OneToMany(mappedBy = "newMobile")
    List<newCustomer> newCustomers=new ArrayList<>();

    public long getMobileId() {
        return mobileId;
    }

    public Customer getMyCustomer() {
        return myCustomer;
    }

    public void setMyCustomer(Customer myCustomer) {
        this.myCustomer = myCustomer;
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

    @Override
    public String toString() {
        return "Mobile{" +
                "mobileId=" + mobileId +
                ", mobileName='" + mobileName + '\'' +
                ", ramSize='" + ramSize + '\'' +
                ", processor='" + processor + '\'' +
                ", price=" + price +
                ", myCustomer=" + myCustomer +
                '}';
    }
}
