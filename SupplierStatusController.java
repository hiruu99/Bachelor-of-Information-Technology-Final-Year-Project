package lk.samagispice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.samagispice.dao.SupplierStatusDao;
import lk.samagispice.entity.SupplierStatus;

@RestController
public class SupplierStatusController {
    
    @Autowired
    private SupplierStatusDao dao;

    @GetMapping(value = "/supplierstatus/list" , produces = "application/json")
    public List<SupplierStatus> getAllData(){
        return dao.findAll();
    }
}
