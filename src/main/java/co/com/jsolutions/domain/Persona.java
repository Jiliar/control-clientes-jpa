package co.com.jsolutions.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data //Anotación de la dependencia Lombok, que crea los metodos Getters, Setters, Constructores, toString, equalsAndHashCode.
@Entity //Anotación de Spring que convierte la clase en una entidad.
@Table(name = "personas") //Anotación de Spring que desarrolla el mapeo de la tabla en base de datos.
public class Persona implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id //Anotación de Spring para especificar la Primary Key de la tabla especificada
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Anotación de Spring para referenciar la estrategia de implementación de la llave primaria
    private Long id;
    
    @NotEmpty    
    private String identificacion;
    
    @NotEmpty
    private String tipo_id;
    
    @NotEmpty
    private String nombre1;
    
    @NotEmpty
    private String nombre2;
    
    @NotEmpty
    private String apellido1;
    
    @NotEmpty
    private String apellido2;
    
    @NotEmpty
    @Email
    private String email;
    
    private String telefono;
    private String direccion;
    private String ocupacion;
    
    @NotNull
    private double saldo;
    
    @NotNull
    private int cantidad_dias;
    
    
}
