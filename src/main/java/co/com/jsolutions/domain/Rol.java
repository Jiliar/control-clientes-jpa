package co.com.jsolutions.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "roles")
public class Rol implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id //Anotación de Spring para especificar la Primary Key de la tabla especificada
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Anotación de Spring para referenciar la estrategia de implementación de la llave primaria
    private Long id;
    
    @NotEmpty
    private String sys_name;
    
    @NotNull
    private int estado;
    
    @NotEmpty
    private String fecha_registro;
    
}
