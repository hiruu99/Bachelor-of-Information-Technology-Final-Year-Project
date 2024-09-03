package lk.samagispice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import lk.samagispice.entity.Supplier;

public interface SupplierDao extends JpaRepository<Supplier, Integer>{
    
}
