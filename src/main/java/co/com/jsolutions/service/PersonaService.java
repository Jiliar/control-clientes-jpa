package co.com.jsolutions.service;

import co.com.jsolutions.domain.Persona;
import java.util.List;

public interface PersonaService {
    
    //Métodos abstractos de logica de negocio 
    public List<Persona> listPersonas();
    public void savePersona(Persona persona);
    public void deletePersona(Persona persona);
    public Persona findPersona(Persona persona);
    public List<Object[]> findTipoDocsByEstado();
}
