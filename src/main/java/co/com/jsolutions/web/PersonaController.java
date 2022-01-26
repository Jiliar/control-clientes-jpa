
package co.com.jsolutions.web;

import co.com.jsolutions.domain.Persona;
import co.com.jsolutions.service.PersonaService;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class PersonaController {
    
    @Autowired
    private PersonaService personaService;
    
    @GetMapping("cliente/")
    public String list(Model modelo, @AuthenticationPrincipal User user){
        var personas = personaService.listPersonas();
        List<Object[]> tipo_docs = personaService.findTipoDocsByEstado();
        modelo.addAttribute("tipo_docs",tipo_docs);
        modelo.addAttribute("personas", personas);
        log.info(String.valueOf("Cantidad de personas registradas "+personas.size()));
        return "views/cliente/list";
    }
    
    @GetMapping("cliente/add")
    public String add(Persona person){
        return "views/cliente/update";
    }
    
    @PostMapping("cliente/save")
    public String save(@Valid Persona persona, Errors errores){
        if(errores.hasErrors()){
            return "views/cliente/update";
        }
        personaService.savePersona(persona);
        return "redirect:/cliente/";
    }
    
    
    @GetMapping("cliente/edit")
    public String edit(Persona persona, Model modelo){ //Spring Framework inicializa al objecto automaticamente
        persona = personaService.findPersona(persona);
        List<Object[]> tipo_docs = personaService.findTipoDocsByEstado();
        modelo.addAttribute("tipo_docs",tipo_docs);
        modelo.addAttribute(persona);
        return "views/cliente/update";
    }
    
    @GetMapping("cliente/delete")
    public String delete(Persona persona){ //Spring Framework inicializa al objecto automaticamente
        personaService.deletePersona(persona);
        return "redirect:/cliente/";
    }
    

}
