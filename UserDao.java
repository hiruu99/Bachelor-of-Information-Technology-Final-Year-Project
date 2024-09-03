package lk.samagispice.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import lk.samagispice.entity.User;

//Integer = Data type of primary key
public interface UserDao extends JpaRepository <User, Integer>{
    
}



