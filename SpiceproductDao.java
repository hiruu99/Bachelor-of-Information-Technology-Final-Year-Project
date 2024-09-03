package lk.samagispice.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import lk.samagispice.entity.Spiceproduct;

//Integer = Data type of primary key
public interface SpiceproductDao extends JpaRepository <Spiceproduct, Integer>{
    
}