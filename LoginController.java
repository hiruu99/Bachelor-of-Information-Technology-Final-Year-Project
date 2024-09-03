package lk.samagispice.controller;

import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;

//Controller = pass data to front end

@RestController //One of these services will not be available if RestController is not here
public class LoginController {


    //Get mapping to generate privilege UI
    @GetMapping(value ="/login")
    public ModelAndView loginUI() {
        ModelAndView loginView= new ModelAndView();
        loginView.setViewName("login.html");
        return loginView;
    }

    

}

