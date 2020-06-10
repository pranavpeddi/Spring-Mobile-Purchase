package com.Pranav.SpringBookApp.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class DateOfPurchase {


    @Id
    @GeneratedValue
    private long dop_id;

    private LocalDate date;

    @OneToMany(mappedBy = "date_of_purchase")
    private List<Customer>customers=new ArrayList<>();

    public long getDop_id() {
        return dop_id;
    }

    public void setDop_id(long dop_id) {
        this.dop_id = dop_id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
