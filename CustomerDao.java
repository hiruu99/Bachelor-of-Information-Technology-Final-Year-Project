package lk.samagispice.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import lk.samagispice.entity.Customer;

//Integer = Data type of primary key
public interface CustomerDao extends JpaRepository <Customer, Integer>{
    
}