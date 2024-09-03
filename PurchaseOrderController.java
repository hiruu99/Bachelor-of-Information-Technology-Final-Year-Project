package lk.samagispice.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lk.samagispice.dao.PurchaseOrderDao;
import lk.samagispice.entity.POrder;
import lk.samagispice.entity.Privilege;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
public class PurchaseOrderController {
    
    @Autowired
    private PurchaseOrderDao dao;

    //private PrivilegeController privilegeController = new PrivilegeController();

    @RequestMapping(value = "/porder")
    public ModelAndView porderUI() {
      
        //  //get loged user authentiacation object using security context
        // Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        ModelAndView porderView = new ModelAndView();

        // porderView.addObject("title" , "Purchase Order Management : Bit Project 2023");
        // porderView.addObject("username" , auth.getName());
        porderView.setViewName("porder.html");
        return porderView;                                                                                   
    }
    

    @GetMapping(value = "/porder/findall" , produces = "application/json")
    public List<POrder> getAllData() {
    //       //get logged user authentation object using securitycontextHolder
    //      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    //     Privilege loggedUserPrivilege = privilegeController.getPrivilegeByUserModule(auth, "PURCHASEORDER");
    //     if (!loggedUserPrivilege.getP_select()) {
    //        return new ArrayList<>(); 
    //     }
        return dao.findAll();
     }
    
    
@PostMapping(value = "/porder")
public String savePorder(@RequestBody POrder pOrder) {
    //       //get logged user authentation object using securitycontextHolder
    //      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    //     Privilege loggedUserPrivilege = privilegeController.getPrivilegeByUserModule(auth, "PURCHASEORDER");
    //     if (!loggedUserPrivilege.getP_insert()) {
    //        return "Save not completed : You have no permission...!"; 
    //     }
    
    try{
        // User logedUser - daoUser.getByUserName(auth.getName());
        // pOrder.setAddeddatetime(LocalDateTime.now());
        // pOrder.setAddeduser_id(logedUser.getId());

        // pOrder.setPordercode(LocalDate.now().getYear() + "0001");


        // There is many to many relationship between purchase order has item
        // Therefore it contains ids from both POrder and rawspice
        // To stop the infinite recursion and stack overflow
        // for (POrderHasRawspice pohi : pOrder.getPorderhasrawspiceList()){
        //     pohi.setPorder_id(pOrder);
        // }

        dao.save(pOrder);
    
    return "OK";
} catch (Exception e){
    return "Save not completed : " + e.getMessage();
}

    
}}
