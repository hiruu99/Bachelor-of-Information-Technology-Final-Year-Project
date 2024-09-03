package lk.samagispice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.samagispice.dao.RoleDao;
import lk.samagispice.entity.Role;

import java.util.List;

@RestController
public class RoleController {
    
    @Autowired
    private RoleDao dao;

    @GetMapping(value="/role/listwithoutadmin", produces ="application/json")
    public List<Role> getRoleListWithoutAdmin(){
        return dao.listWithoutAdmin();
    }
}
