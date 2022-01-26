
package co.com.jsolutions.dao;

import co.com.jsolutions.domain.Rol;
import org.springframework.data.repository.CrudRepository;

/*En esta interfaz se manejan todo lo referente al concepto de transacciones, 
estas transacciones son heredadas de la interfaz CrudRepository
la cual gestiona por medio de genericos el tipo de objeto y el tipo de ID
usado en la tabla referente al objeto en base de datos */
public interface RolDao extends CrudRepository<Rol, Long>{
}
