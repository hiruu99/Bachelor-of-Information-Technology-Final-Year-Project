package lk.samagispice.controller;

import org.springframework.web.bind.annotation.RestController;

import lk.samagispice.dao.ItemDao;
import lk.samagispice.entity.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@RestController
public class ItemController {
    
    @Autowired
    private ItemDao dao;

    @GetMapping(value = "/item/list" , produces = "application/json")
    public List<Item> getItemList() {
        return dao.findAll();
    }
    
}
