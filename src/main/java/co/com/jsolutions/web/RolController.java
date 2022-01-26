
package co.com.jsolutions.web;

import co.com.jsolutions.domain.Rol;
import co.com.jsolutions.service.RolService;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class RolController {
    
    @Autowired
    private RolService rolService;
   
    
    @GetMapping("rol/")
    public String list(Model modelo, @AuthenticationPrincipal User user){
        var roles = rolService.listRol();
        log.info("Usuario loggeado: "+user);
        modelo.addAttribute("roles", roles);
        return "views/rol/list";
    }
    
    @GetMapping("rol/add")
    public String add(Rol person){
        return "views/rol/update";
    }
    
    @PostMapping("rol/save")
    public String save(@Valid Rol rol, Errors errores){
        if(errores.hasErrors()){
            return "views/rol/update";
        }
        
        Format f = new SimpleDateFormat("mm-dd-yyyy hh:mm:ss");
        String str = f.format(new Date());
        rol.setFecha_registro(str);
        
        rol.setEstado(1);
        rolService.saveRol(rol);
        return "redirect:/rol/";
    }
    
    @GetMapping("rol/edit")
    public String edit(Rol rol, Model modelo){ //Spring Framework inicializa al objecto automaticamente
        rol = rolService.findRol(rol);
        modelo.addAttribute(rol);
        return "views/rol/update";
    }
    
    @GetMapping("rol/delete")
    public String delete(Rol rol){ //Spring Framework inicializa al objecto automaticamente
        rolService.deleteRol(rol);
        return "redirect:/rol/";
    }
}
