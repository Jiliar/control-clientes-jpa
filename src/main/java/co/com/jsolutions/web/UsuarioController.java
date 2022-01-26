
package co.com.jsolutions.web;

import co.com.jsolutions.domain.Usuario;
import co.com.jsolutions.service.UsuarioService;
import co.com.jsolutions.util.EncryptPassword;
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
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;
   
    
    @GetMapping("usuario/")
    public String list(Model modelo, @AuthenticationPrincipal User user){
        var usuarios = usuarioService.listUsuario();
        log.info("Usuario loggeado: "+user);
        modelo.addAttribute("usuarios", usuarios);
        return "views/usuario/list";
    }
    
    @GetMapping("usuario/add")
    public String add(Usuario person){
        return "views/usuario/update";
    }
    
    @PostMapping("usuario/save")
    public String save(@Valid Usuario usuario, Errors errores){
        if(errores.hasErrors()){
            return "views/usuario/update";
        }
        String pass = EncryptPassword.getEncryptPassword(usuario.getPassword());
        usuario.setPassword(pass);
        
        Format f = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String str = f.format(new Date());
        usuario.setFecha_registro(str);
        
        usuario.setEstado(1);
        
        usuarioService.saveUsuario(usuario);
        return "redirect:/usuario/";
    }
    
    
    @GetMapping("usuario/edit")
    public String edit(Usuario usuario, Model modelo){ //Spring Framework inicializa al objecto automaticamente
        usuario = usuarioService.findUsuario(usuario);
        modelo.addAttribute(usuario);
        return "views/usuario/update";
    }
    
    @GetMapping("usuario/delete")
    public String delete(Usuario usuario){ //Spring Framework inicializa al objecto automaticamente
        usuarioService.deleteUsuario(usuario);
        return "redirect:/usuario/";
    }
}
