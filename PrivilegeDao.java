package lk.samagispice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import lk.samagispice.entity.Privilege;

//Integer = Data type of primary key
public interface PrivilegeDao extends JpaRepository <Privilege, Integer>{
    
}
