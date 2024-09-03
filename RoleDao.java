package lk.samagispice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import lk.samagispice.entity.Role;

import java.util.List;

public interface RoleDao extends JpaRepository <Role, Integer> {
    
    //create query for getting role list without admin
    @Query("select r from Role r where r.name <> 'Admin'")
    public List<Role> listWithoutAdmin();
}
