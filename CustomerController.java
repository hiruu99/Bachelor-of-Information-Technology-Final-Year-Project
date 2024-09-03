package lk.samagispice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lk.samagispice.dao.CustomerDao;
import lk.samagispice.entity.Customer;

//Controller = pass data to front end

@RestController //One of these services will not be available if RestController is not here
public class CustomerController {

    @Autowired //dependency injection
    private CustomerDao dao; //Create variable privilegedao

    //@Autowired
    //private EmployeeDao employeeDao;

    //dependency injection
    /* 
    public PrivilegeController(PrivilegeDao dao, EmployeeDao employeeDao){
        this.dao = dao;
        this.employeeDao = employeeDao;
    }
    */

    //create mapping for get all user data --> URL [ /user/findall ]
    @RequestMapping (value = "/customer/findall", produces = "application/json")
    public List <Customer> getAllData(){
        return dao.findAll();
    }

    //define user ui service
    @GetMapping(value ="/customer")
    public ModelAndView customerUI(){
        ModelAndView customerView = new ModelAndView();
        customerView.setViewName("customer.html");
        return customerView;
    }
    
}

