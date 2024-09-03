package lk.samagispice.entity;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "supplier")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "regno" , unique = true)
    @NotNull
    private String regno;

    @NotNull
    private String suppliername;

    @NotNull
    private LocalDateTime addeddatetime;

    @NotNull
    private Integer addeduser_id; 

    private LocalDateTime updatedatetime; 
    private Integer updateuser_id ;  
    private LocalDateTime deletedatetime; 
    private Integer deleteuser_id; 

    @ManyToOne
    @JoinColumn(name = "supplierstatus_id" ,referencedColumnName = "id")
    private SupplierStatus supplierstatus_id;

    @ManyToMany
    @JoinTable(name = "supplier_has_item" , joinColumns = @JoinColumn(name= "supplier_id") , inverseJoinColumns = @JoinColumn(name = "item_id"))
    private Set<Item> supplyItems;

}
