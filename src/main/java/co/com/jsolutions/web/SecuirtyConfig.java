
package co.com.jsolutions.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecuirtyConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception{
        log.debug(userDetailsService.toString());
        build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    
    /*@Override //Gestión de Autenticación
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication().withUser("admin").password("{noop}123").roles("ADMIN","USER")
                .and().withUser("user").password("{noop}123").roles("USER");
    }*/
    
    @Override //Gestión de Autorización
    protected void configure(HttpSecurity http)throws Exception{
        http.authorizeRequests().antMatchers("/clientes/**","/clientes/add/**","/clientes/edit/**","/clientes/delete").hasRole("ADMIN")
                .antMatchers("/","/clientes/**").hasAnyRole("USER","ADMIN")
                .and().formLogin().loginPage("/auth/login")
                .and().exceptionHandling().accessDeniedPage("/errors/403");
    }
}
