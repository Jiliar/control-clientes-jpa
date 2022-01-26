package co.com.jsolutions.service.impl;

import co.com.jsolutions.dao.AuthUsuarioDao;
import co.com.jsolutions.domain.Usuario;
import co.com.jsolutions.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    
    @Autowired() //Anotracón de Spring para inyectar dependencias que seran administradas por el contenedor de Spring
    private AuthUsuarioDao usuarioDao; //Conecta capa de servicios con la capa de datos

    @Transactional(readOnly = true) //Anotación de Spring para referenciar una transacción a base de datos de solo lectura
    public List<Usuario> listUsuario() {
        return (List<Usuario>) usuarioDao.findAll();
    }
    
    @Transactional() //Anotación de Spring para referenciar una transacción a base de datos de escritura y/o lectura
    public void saveUsuario(Usuario rol) {
        usuarioDao.save(rol);
    }
    
    @Transactional()
    public void deleteUsuario(Usuario rol) {
        usuarioDao.delete(rol);
    }

    @Transactional(readOnly = true)
    public Usuario findUsuario(Usuario rol) {
       return usuarioDao.findById(rol.getId()).orElse(null);
    }
    
}
