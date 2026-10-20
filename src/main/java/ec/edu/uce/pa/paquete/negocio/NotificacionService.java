package ec.edu.uce.pa.paquete.negocio;

import jakarta.inject.Singleton;

@Singleton 
public class NotificacionService {
    public void enviar(String correo, String asunto, String cuerpo) {
        System.out.println("Enviando notificación a: " + correo);
        System.out.println("Asunto: " + asunto);
        System.out.println("Cuerpo: " + cuerpo);
        System.out.println("Notificación enviada con exito");

    }
}
