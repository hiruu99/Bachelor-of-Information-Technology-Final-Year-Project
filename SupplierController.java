package lk.samagispice.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lk.samagispice.dao.SupplierDao;
import lk.samagispice.entity.Privilege;
import lk.samagispice.entity.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class SupplierController {
    
    @Autowired
    private PrivilegeController privilegeController;

    @Autowired
    private SupplierDao dao;

    @RequestMapping(value = "/supplierform")
    public ModelAndView supplierFormUI() {

         //get loged user authentiacation object using security context
        //  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
         
        ModelAndView supplierView = new ModelAndView();
        supplierView.setViewName("supplier.html");
        supplierView.addObject("title" , "Supplier Management : Bit Project 2023");
        // supplierView.addObject("username" , auth.getName());
        return supplierView;
    }


    @RequestMapping(value = "/suppliertable")
    public ModelAndView supplierTableUI() {

         //get loged user authentiacation object using security context
        //  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
         
        ModelAndView supplierView = new ModelAndView();
        supplierView.setViewName("suppliertable.html");
        supplierView.addObject("title" , "Supplier Management : Bit Project 2023");
        // supplierView.addObject("username" , auth.getName());
        return supplierView;
    }

       // define findall get mapping for get all  employee data -->  URL [ /supplier/findall ]
    //    @RequestMapping(value = "/supplier/findall" , produces = "application/json")
    //    public List<Supplier> getAllData(){
   
    //         //get logged user authentation object using securitycontextHolder
    //         Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    //        Privilege loggedUserPrivilege = privilegeController.getPrivilegeByUserModule(auth, "SUPPLIER");
           
    //        if (!loggedUserPrivilege.getPri_select()) {
    //           return new ArrayList<>(); 
    //        }
    //        return dao.findAll();
    //    }
   

       @GetMapping(value = "/supplier/{id}", produces = "application/json")
       public Supplier getSupplierById(@PathVariable("id")int sid ) {
           return dao.getReferenceById(sid);
       }
       
    
}
