package co.com.jsolutions.service.impl;

import co.com.jsolutions.domain.Rol;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.com.jsolutions.dao.RolDao;
import co.com.jsolutions.service.RolService;

@Service //Anotación de Spring para especificar que la clase hace referencia a un servicio con el fin de esructurar la lógica empresarial en una capa diferente
public class RolServiceImpl implements RolService{

    @Autowired() //Anotracón de Spring para inyectar dependencias que seran administradas por el contenedor de Spring
    private RolDao rolDao; //Conecta capa de servicios con la capa de datos

    @Transactional(readOnly = true) //Anotación de Spring para referenciar una transacción a base de datos de solo lectura
    public List<Rol> listRol() {
        return (List<Rol>) rolDao.findAll();
    }
    
    @Transactional() //Anotación de Spring para referenciar una transacción a base de datos de escritura y/o lectura
    public void saveRol(Rol rol) {
        rolDao.save(rol);
    }
    
    @Transactional()
    public void deleteRol(Rol rol) {
        rolDao.delete(rol);
    }

    @Transactional(readOnly = true)
    public Rol findRol(Rol rol) {
       return rolDao.findById(rol.getId()).orElse(null);
    }

    
}
