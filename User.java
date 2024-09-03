package lk.samagispice.entity;

import java.util.Set;
import java.time.LocalDateTime;

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
@Table(name = "user") // Table mapping

@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY) // AI
    // Column mapping - above property names

    @Column(name ="id")
    private Integer id;
    
    @Column(name ="username")
    @NotNull
    private String username;
    
    @Column(name ="password")
    @NotNull
    private String password;
    
    @Column(name ="email")
    @NotNull
    private String email;
    
    @Column(name ="status")
    @NotNull
    private Boolean status;

    @Column(name ="note")
    private String note;

    @Column(name ="addeddatetime")
    @NotNull
    private LocalDateTime addeddatetime;

    @Column(name ="photopath")
    private String photopath;

    @ManyToOne
    @JoinColumn(name ="employee_id", referencedColumnName = "id")
    private Employee employee_id;

    @ManyToMany // user and role table has many to many relationship
    //Therefore association or join table created
    //name define the table name, columns defined by joincolumns
    @JoinTable (name ="user_has_role", joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name ="role_id"))
    private Set<Role> roles;
}

