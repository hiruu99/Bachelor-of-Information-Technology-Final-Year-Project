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

@Entity // Convert into persistent entity
@Table(name = "unittype") // To map with employee db table

@Data // To generate setter and getter toString ....//lombook package
@NoArgsConstructor // default constructor
@AllArgsConstructor // To gnerate All argument constructor

public class Unittype {
    
    @Id //PK
    @GeneratedValue (strategy =  GenerationType.IDENTITY) //AI
    @Column(name ="id", unique = true)
    private Integer id;

    @Column(name ="name", unique = true)
    private String name;
}

