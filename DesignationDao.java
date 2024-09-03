package lk.samagispice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import lk.samagispice.entity.Designation;;

public interface DesignationDao extends JpaRepository<Designation,Integer> {
    
}
