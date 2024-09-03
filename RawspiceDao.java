package lk.samagispice.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import lk.samagispice.entity.Rawspice;

//Integer = Data type of primary key
public interface RawspiceDao extends JpaRepository <Rawspice, Integer>{
    
}