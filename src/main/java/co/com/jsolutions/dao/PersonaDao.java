
package co.com.jsolutions.dao;
 import java.util.List;
import co.com.jsolutions.domain.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/*En esta interfaz se manejan todo lo referente al concepto de transacciones, 
estas transacciones son heredadas de la interfaz CrudRepository
la cual gestiona por medio de genericos el tipo de objeto y el tipo de ID
usado en la tabla referente al objeto en base de datos */
public interface PersonaDao extends CrudRepository<Persona, Long>{
    
    @Query(nativeQuery = true, value = "SELECT id, nombre FROM tipo_documentos WHERE estado = :estado ORDER BY id ASC")
    List<Object[]> findTipoDocsByEstado(@Param("estado")Integer id);
}
