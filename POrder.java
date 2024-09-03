package lk.samagispice.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "porder")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class POrder {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String pordercode;

    @NotNull
    private LocalDate requireddate;
    
    @NotNull
    private BigDecimal totalamount;

    private String note;

     @NotNull
    private LocalDateTime addeddatetime;

    @NotNull
    private Integer addeduser_id; 

    private LocalDateTime updatedatetime; 
    private Integer updateuser_id ;  
    private LocalDateTime deletedatetime; 
    private Integer deleteuser_id; 

    @ManyToOne
    @JoinColumn(name = "porderstatus_id" ,referencedColumnName = "id")
    private POrderStatus porderstatus_id;

    @ManyToOne
    @JoinColumn(name = "supplier_id" ,referencedColumnName = "id")
    private Supplier supplier_id;

    //mappedby = can oly read, cannot write
    //Therefore use cascadeType.All (But still cant remove)
    //@OneToMany
    
}
