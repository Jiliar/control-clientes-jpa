package co.com.jsolutions.service.impl;

import co.com.jsolutions.dao.PersonaDao;
import co.com.jsolutions.domain.Persona;
import co.com.jsolutions.service.PersonaService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service //Anotación de Spring para especificar que la clase hace referencia a un servicio con el fin de esructurar la lógica empresarial en una capa diferente
public class PersonaServiceImpl implements PersonaService{

    
    @Autowired() //Anotracón de Spring para inyectar dependencias que seran administradas por el contenedor de Spring
    private PersonaDao personaDao; //Conecta capa de servicios con la capa de datos

    @Transactional(readOnly = true) //Anotación de Spring para referenciar una transacción a base de datos de solo lectura
    public List<Persona> listPersonas() {
        return (List<Persona>) personaDao.findAll();
    }
    
    @Transactional() //Anotación de Spring para referenciar una transacción a base de datos de escritura y/o lectura
    public void savePersona(Persona persona) {
        personaDao.save(persona);
    }
    
    @Transactional()
    public void deletePersona(Persona persona) {
        personaDao.delete(persona);
    }

    @Transactional(readOnly = true)
    public Persona findPersona(Persona persona) {
       return personaDao.findById(persona.getId()).orElse(null);
    }
    
    public List<Object[]> findTipoDocsByEstado(){
       List<Object[]> results = personaDao.findTipoDocsByEstado(1);
       return results;
    }
    
    
}
