package lk.samagispice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lk.samagispice.dao.PrivilegeDao;
import lk.samagispice.entity.Privilege;

import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;

//Controller = pass data to front end

@RestController //One of these services will not be available if RestController is not here
public class PrivilegeController {

    @Autowired //dependency injection
    private PrivilegeDao dao; //Create variable privilegedao

    //@Autowired
    //private EmployeeDao employeeDao;

    //dependency injection
    /* 
    public PrivilegeController(PrivilegeDao dao, EmployeeDao employeeDao){
        this.dao = dao;
        this.employeeDao = employeeDao;
    }
    */


    //Get mapping to generate privilege UI
    @GetMapping(value ="/privilege")
    public ModelAndView privilegeUI() {
        ModelAndView privilegeView= new ModelAndView();
        privilegeView.setViewName("privilege.html");
        return privilegeView;
    }
    

    //create mapping for get all privilege data --> URL [ /privilege/findall ]
    @GetMapping (value = "/privilege/findall", produces = "application/json")
    public List <Privilege> getAllData(){
        return dao.findAll();
    }
    


}
