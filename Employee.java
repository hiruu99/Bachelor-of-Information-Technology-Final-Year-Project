package lk.samagispice.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Convert into persistent entity
@Table(name = "employee") // To map with employee db table

@Data // To generate setter and getter toString ....//lombook package
@NoArgsConstructor // default constructor
@AllArgsConstructor // To gnerate All argument constructor
public class Employee {

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AI (Auto Increment)
    @Column(name = "id", unique = true)
    private Integer id;

    @Column(name = "empno", unique = true)
    private String empno;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "callingname")
    private String callingname; 

    @Column(name = "nic", unique =true)
    private String nic;

    @Column(name = "gender")
    private String gender; 

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "landno")
    private String landno;

    @Column(name = "address")
    private String address;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "note")
    private String note; 

    @Column(name = "civilstatus")
    private String civilstatus; 


    @ManyToOne // employee --> designation table relationship many to one
    @JoinColumn(name = "designation_id", referencedColumnName = "id")
    private Designation designation_id; // FK --> another table  PK

    @ManyToOne
    @JoinColumn(name ="employeestatus_id", referencedColumnName = "id")
    private EmployeeStatus employeestatus_id;
    
}  
