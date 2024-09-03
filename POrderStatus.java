package lk.samagispice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // convert into persistence entity
@Table(name = "porderstatus") // for map with employee db table

@Data // for generate setter and getter toString .... etc functions
@NoArgsConstructor //for generate  default constructor
@AllArgsConstructor//for generate  All argeument constructor
public class POrderStatus {
    
     @Id// PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)// AI
    @Column(name = "id" , unique = true)
    private Integer id;

    @Column(name = "name" , unique = true)
    private String name;


}
