package com.Pranav.SpringBookApp.Service;

import com.Pranav.SpringBookApp.Model.Mobile;
import com.Pranav.SpringBookApp.Repository.MobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MobileService {
    @Autowired
    private MobileRepository mobileRepository;


    public  void save(Mobile mobile)
    {
        mobileRepository.save(mobile);
    }
}
