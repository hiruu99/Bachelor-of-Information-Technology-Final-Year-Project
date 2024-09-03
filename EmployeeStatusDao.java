package lk.samagispice.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import lk.samagispice.entity.EmployeeStatus;

public interface EmployeeStatusDao extends JpaRepository<EmployeeStatus,Integer> {
    
}
