package lk.samagispice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import lk.samagispice.entity.Employee;

/* JpaRepository has pre defined methods for CRUD operations. No need to write SQL queries manually */
public interface EmployeeDao extends JpaRepository<Employee, Integer> {
// interface = fully completed abstract class, can have only abstract methods
// abstract class = cannot make instances further, can have both normal method and abstract method
// abstract method = without method body

    /* JpaRepository<Employee, Integer> eke Employee kiyanne data access karanna one karana file (mapping file) eka. 
    Integer kiyanne mapping file eke id (primary key) eke data type eka */

    // dao = Data Access Object
    // native, HQL, JPQL

    ////// JPQL

    // get employee by given email
    @Query(value = "select e from Employee e where e.email=?1")
    public Employee getByEmail(String email);

    // get employee by given nic
    @Query(value = "select e from Employee e where e.nic=?1")
    public Employee getByNic(String nic);

    ////// Native
    //get next employee number
    // Add values according to the same format having zeros at the beginning
    @Query(value = "SELECT lpad(max(e.empno) +1, 8, '0') FROM bitproject.employee as e;", nativeQuery = true)
    public String getNextNumber();

    // Create query for get employee list without having user account
    // select employees from employee table
    //Use where close to get the yser ids in the user table
    //This is a inner query
    @Query("select e from Employee e where e.id not in (select u.employee_id.id from User u)")
    //table name convert to class name
    public List<Employee> getEmployeeListWithoutUserAccount();


}
