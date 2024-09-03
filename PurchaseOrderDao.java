package lk.samagispice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import lk.samagispice.entity.POrder;

public interface PurchaseOrderDao extends JpaRepository<POrder, Integer>{
    
}
