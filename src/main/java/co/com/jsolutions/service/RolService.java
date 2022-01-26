package co.com.jsolutions.service;

import co.com.jsolutions.domain.Rol;
import java.util.List;

public interface RolService {
    
    //Métodos abstractos de logica de negocio 
    public List<Rol> listRol();
    public void saveRol(Rol rol);
    public void deleteRol(Rol rol);
    public Rol findRol(Rol rol);
}
