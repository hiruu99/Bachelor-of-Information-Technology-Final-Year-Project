package lk.samagispice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lk.samagispice.dao.EmployeeDao;
import lk.samagispice.dao.EmployeeStatusDao;
import lk.samagispice.entity.Employee;
import lk.samagispice.entity.EmployeeStatus;
//import lk.samagispice.entity.Privilege;
import lk.samagispice.entity.Privilege;

import java.util.List;
//import java.util.ArrayList;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao dao;

    @Autowired
    private EmployeeStatusDao daoStatus;

    //create privilegecontroller object
    private PrivilegeController privilegeController = new PrivilegeController();
    
    @RequestMapping(value ="/employee")
    public ModelAndView employeeUI(){

        //get loged user authentication object using Security context
        //Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        ModelAndView employeeView = new ModelAndView();

        employeeView.addObject("title", "Employee Management : Bit Projet 2023");
        //employeeView.addObject("username", auth.getName());
        employeeView.setViewName("employee.html");
        return employeeView;
    }

    // define findall get mapping for get all employee data --> URL [ /employee/findall ]
    @RequestMapping(value = "/employee/findall", produces = "application/json")
    public List<Employee> getAllData() {

        //get logged user authentication object using securitycontextholder
        // Authentication auh = SecurityContextHolder.getContext().getAuthentication();
        // Privilege loggedUserPrivilege = privilegeController.getPrivilegeByUserModule(auth, "EMPLOYEE");
        // if(!loggedUserPrivilege.getP_select()){
        //     return new ArrayList<>();
        // }
        return dao.findAll();
    }


    //create post mapping for add new employee record 
    @PostMapping(value = "/employee")
    // employee = object which is returning from front end
    public String saveEmployee (@RequestBody Employee employee){
        //Authentication and Authorization 
        //get logged user authentication object using securitycontextholder
        // Authentication auh = SecurityContextHolder.getContext().getAuthentication();
        // Privilege loggedUserPrivilege = privilegeController.getPrivilegeByUserModule(auth, "EMPLOYEE");
        // if(!loggedUserPrivilege.getP_insert()){
        //     return "Insert not completed : You have no privilege!...";
        // }

        //duplicate
        Employee extEmployeeEmail = dao.getByEmail(employee.getEmail());
        if (extEmployeeEmail != null){
            return "Save not completed : given " + employee.getEmail()+ "already existed.....!";
        }

        Employee extEmployeeNic = dao.getByNic(employee.getNic());
        if (extEmployeeNic != null){
            return "Save not completed : given " + employee.getNic()+ "already existed.....!";
        }

        try{
           //set auto generated value 
           //employee.setEmpno("00000003");
           //create nextNumber variable to store nextNumber in db using calling the getNextNumber function in dao
           String nextNumber = dao.getNextNumber();
           // to check whether nextNumber variable is empty or not
           if(nextNumber.equals(null)|| nextNumber.equals("nextNumber")){
                employee.setEmpno("00000001");
           }
           else{
            employee.setEmpno(nextNumber);
           }

           //set addeddatetime
             
           //call operator
           dao.save(employee);

           //dependency


           return "OK";
        } catch (Exception e){
            return "Save not completed :" + e.getMessage();
        }
    }

    //define delete mapping for delete employee record
    @DeleteMapping(value="/employee")
    public String deleteEmployee(@RequestBody Employee employee){

        //Authentication and Authorizatin
        //get logged user authentication object using securitycontextholder
        // Authentication auh = SecurityContextHolder.getContext().getAuthentication();
        // Privilege loggedUserPrivilege = privilegeController.getPrivilegeByUserModule(auth, "EMPLOYEE");
        // if(!loggedUserPrivilege.getP_delete()){
        //     return "Delete not completed : You have no privilege!...";
        // }
        
        //existing
        Employee extEmployee = dao.getReferenceById(employee.getId());
        if (extEmployee == null){
            return "Delete not completed : Employee not exists!...";
        }

        try{
            //operator
            //hard delete
            dao.delete(employee);
            //dao.delete(dao.getReferenceById(employee.getId())) --> Not using the direct data, use only a object;

            //soft delete
            EmployeeStatus dEmployeeStatus = daoStatus.getReferenceById(3); //get delete status object
            extEmployee.setEmployeestatus_id(dEmployeeStatus); //change status into delete
            dao.save(extEmployee); //save extemployee object (update)

            //dependency

            return "OK";

        }catch (Exception e){
            return "Delete Not Completed : " + e.getMessage();
        }

    }

    @PutMapping(value ="/employee" )
    public String updateEmployee(@RequestBody Employee employee) {
        //Authentication and Authorization
        //get logged user authentication object using securitycontextholder
        // Authentication auh = SecurityContextHolder.getContext().getAuthentication();
        // Privilege loggedUserPrivilege = privilegeController.getPrivilegeByUserModule(auth, "EMPLOYEE");
        // if(!loggedUserPrivilege.getP_update()){
        //     return "Update not completed : You have no privilege!...";
        // }

        //check existing and duplicate
        //getReferenceById == PK
        //Used the object which is passed from front end
        Employee extEmployee = dao.getReferenceById(employee.getId());
        // Checking whether the existing element is null
        if (extEmployee == null){
            return "Update not completed : Employee not exist...!";
        }

        Employee extEmployeeByEmail = dao.getByEmail(employee.getEmail());
        //employee.getId = which is returned from front end
        //extEmployeeByEmail.getId = which is existing
        if (extEmployeeByEmail != null && extEmployeeByEmail.getId() != employee.getId()){
            //use only 1 method
            //return "Update not completed : change Email already exist..!";
            return "Update not completed : changed " + employee.getEmail() + " already exist..!";
        }

        Employee extEmployeeByNic = dao.getByNic(employee.getNic());
        if (extEmployeeByNic != null && extEmployeeByNic.getId() != employee.getId()){
            return "Update not completed : changed " + employee.getNic() + " already exist..!";
        }

        try{
            //set auto generated value

            //perator
            dao.save(employee);

            //dependencies

            return "OK";
        }catch (Exception e){
            return "Update not completed : " + e.getMessage();
                }
    }

    //dao ---> instance of employee
    //Get mapping for get employee without having user account [test URL--> /employee/listbywithoutuseraccount]
    @GetMapping(value = "/employee/listbywithoutuseraccount", produces ="application/json")
    public List<Employee> getListByWithoutUserAccount() {
        return dao.getEmployeeListWithoutUserAccount();
    }
    
}
