package co.com.jsolutions.service;

import co.com.jsolutions.domain.Usuario;
import java.util.List;

public interface UsuarioService {
    
    //Métodos abstractos de logica de negocio 
    public List<Usuario> listUsuario();
    public void saveUsuario(Usuario usuario);
    public void deleteUsuario(Usuario usuario);
    public Usuario findUsuario(Usuario usuario);
}
