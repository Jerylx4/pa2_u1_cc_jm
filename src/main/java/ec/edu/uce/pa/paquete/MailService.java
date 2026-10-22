package ec.edu.uce.pa.paquete;

import io.quarkus.arc.Unremovable;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Singleton;

//@ApplicationScoped //delego el control al contenedor ArC
//@RequestScoped //para aplicaciones web
@Singleton 
@Unremovable 
public class MailService {
    public void enviar(String correo, String asunto, String cuerpo) {
        System.out.println("Enviando correo a : " + correo);
        System.out.println("Asunto: " + asunto);
        System.out.println("Cuerpo: " + cuerpo);
        System.out.println("Correo enviado con exito.");
    }
}
