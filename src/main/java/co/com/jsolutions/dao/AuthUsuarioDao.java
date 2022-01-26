
package co.com.jsolutions.dao;

import co.com.jsolutions.domain.Usuario;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthUsuarioDao extends JpaRepository<Usuario, Long>{
    Usuario findByUsername(String username);
}
