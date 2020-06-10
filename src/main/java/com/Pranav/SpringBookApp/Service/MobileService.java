package com.Pranav.SpringBookApp.Service;

import com.Pranav.SpringBookApp.Model.Mobile;
import com.Pranav.SpringBookApp.Repository.MobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MobileService {
    @Autowired
    private MobileRepository mobileRepository;
    public List<Mobile> getall()
    {
        return (List<Mobile>)mobileRepository.findAll();
    }
    public  void save(Mobile mobile)
    {
        mobileRepository.save(mobile);
    }

    public void deleteMobile(long id)
    {
        mobileRepository.deleteById(id);
    }


    public Mobile searchById(long id)
    {
        return mobileRepository.findByMobileId(id);
    }
}
