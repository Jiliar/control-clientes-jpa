
package co.com.jsolutions.web;

import co.com.jsolutions.domain.Persona;
import co.com.jsolutions.service.PersonaService;
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
public class DashboardController {
    
    @Autowired
    private PersonaService personaService;
   
    @GetMapping("/")
    public String dashboardList(Model modelo, @AuthenticationPrincipal User user){
        var personas = personaService.listPersonas();
        modelo.addAttribute("personas", personas);
        var saldoTotal = 0D;
        var cantidadTotal = 0;
        var cantidadTotalDias = 0;
        for(var p:personas){
            saldoTotal+=p.getSaldo();
            cantidadTotalDias+=p.getCantidad_dias();
            cantidadTotal++;
        }
        var promedioDias = cantidadTotalDias/cantidadTotal;
        modelo.addAttribute("saldoTotal", saldoTotal);
        modelo.addAttribute("cantidadTotal", cantidadTotal);
        modelo.addAttribute("promedioDias", promedioDias);
        return "index";
    }
    
    @GetMapping("/delete")
    public String delete(Persona persona){ //Spring Framework inicializa al objecto automaticamente
        personaService.deletePersona(persona);
        return "redirect:/";
    }
    
    
    
}
