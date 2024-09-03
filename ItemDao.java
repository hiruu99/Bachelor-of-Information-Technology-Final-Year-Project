package lk.samagispice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import lk.samagispice.entity.Item;

public interface ItemDao extends JpaRepository<Item, Integer>{
    
}
