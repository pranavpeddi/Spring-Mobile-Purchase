package com.Pranav.SpringBookApp.Repository;

import com.Pranav.SpringBookApp.Model.Mobile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobileRepository extends CrudRepository<Mobile,Long> {

}
