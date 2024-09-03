package lk.samagispice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import lk.samagispice.entity.SupplierStatus;

public interface SupplierStatusDao extends JpaRepository<SupplierStatus, Integer>{
    
}
