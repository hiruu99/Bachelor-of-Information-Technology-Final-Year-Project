package lk.samagispice.entity;

//import java.util.Set;
import java.text.DecimalFormat;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
//import jakarta.persistence.JoinTable;
//import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer") // Table mapping

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Customer {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY) // AI
    // Column mapping - above property names

    @Column(name ="id")
    private Integer id;
    
    @Column(name ="note")
    private String note;
    
    @Column(name ="addeddatetime")
    @NotNull
    private LocalDateTime addeddatetime;
    
    @Column(name ="updatedatetime")
    @NotNull
    private LocalDateTime updatedatetime;
    
    @Column(name ="deletedatetime")
    @NotNull
    private LocalDateTime deletedatetime;

    @Column(name ="addeduserid")
    @NotNull
    private Integer addeduserid;

    @Column(name ="updateuserid")
    @NotNull
    private Integer updateuserid;

    @Column(name ="deleteuserid")
    @NotNull
    private Integer deleteuserid;

    @Column(name ="fullname")
    @NotNull
    private String fullname;
    
    @Column(name ="mobile")
    @NotNull
    private String mobile;

    @Column(name ="address")
    @NotNull
    private String address;

    @Column(name ="nic")
    @NotNull
    private String nic;

    @Column(name ="point")
    @NotNull
    private DecimalFormat point ;

    @ManyToOne
    @JoinColumn(name ="customerstatus_id", referencedColumnName = "id")
    private CustomerStatus customerstatus_id;

}


