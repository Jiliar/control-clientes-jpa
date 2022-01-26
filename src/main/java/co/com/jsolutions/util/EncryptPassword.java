package co.com.jsolutions.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptPassword {
    
    public static void main(String arg[]){
        var password = "123";
        System.out.println("Password: "+password);
        System.out.println("Password Encriptado: "+getEncryptPassword(password));
    }
    
    public static String getEncryptPassword(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
}
}
