package lk.samagispice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RestController;

import lk.samagispice.dao.EmployeeStatusDao;
import lk.samagispice.entity.EmployeeStatus;

import org.springframework.web.bind.annotation.GetMapping;

//Controller = pass data to front end

@RestController //One of these services will not be available if RestController is not here
public class EmployeeStatusController {

    @Autowired //inject designation object into dao variable
    private EmployeeStatusDao dao; // private can access only by this class


    //Get mapping to generate privilege UI
    @GetMapping(value ="/employeestatus/list", produces = "application/json")
    public List<EmployeeStatus>getAllData(){
        return dao.findAll(Sort.by(Direction.DESC, "id"));
    }

    
}


