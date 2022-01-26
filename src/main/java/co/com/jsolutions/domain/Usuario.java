package co.com.jsolutions.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "usuarios")
public class Usuario implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id //Anotación de Spring para especificar la Primary Key de la tabla especificada
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Anotación de Spring para referenciar la estrategia de implementación de la llave primaria
    private Long id;
    
    @NotEmpty
    private String username;
    
    @NotEmpty
    private String password;
    
    private int estado;
    
    private String fecha_registro;
    
    
    @JoinTable(
        name = "usuarios_roles",
        joinColumns = @JoinColumn(name = "id_usuario", nullable = false),
        inverseJoinColumns = @JoinColumn(name="id_rol", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Rol> roles;
   
}
