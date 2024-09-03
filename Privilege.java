package lk.samagispice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "privilege") // Table mapping

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Privilege {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY) // AI
    // Column mapping - above property names

    @Column(name ="id")
    private Integer id;
    
    @Column(name ="p_select")
    @NotNull
    private Boolean p_select;
    
    @Column(name ="p_insert")
    @NotNull
    private Boolean p_insert;
    
    @Column(name ="p_update")
    @NotNull
    private Boolean p_update;
    
    @Column(name ="p_delete")
    @NotNull
    private Boolean p_delete;


    @ManyToOne
    @JoinColumn(name ="role_id", referencedColumnName = "id")
    private Role role_id;

    @ManyToOne
    @JoinColumn(name ="module_id", referencedColumnName = "id")
    private Module module_id;
}
