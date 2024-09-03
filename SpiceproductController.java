package lk.samagispice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lk.samagispice.dao.SpiceproductDao;
import lk.samagispice.entity.Spiceproduct;

//Controller = pass data to front end

@RestController //One of these services will not be available if RestController is not here
public class SpiceproductController {

    @Autowired //dependency injection
    private SpiceproductDao dao; //Create variable rawspicedao

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
    @RequestMapping (value = "/spiceproduct/findall", produces = "application/json")
    public List <Spiceproduct> getAllData(){
        return dao.findAll();
    }

    //define user ui service
    @GetMapping(value ="/spiceproduct")
    public ModelAndView spiceproductUI(){
        ModelAndView spiceproductView = new ModelAndView();
        spiceproductView.setViewName("spiceproduct.html");
        return spiceproductView;
    }
    
}


