package ec.edu.uce.pa.paquete;

import java.util.UUID;

import jakarta.inject.Singleton;

@Singleton
public class NotificacionService {
    private final UUID id = UUID.randomUUID();

    public NotificacionService(){
        System.out.println("[InstanciaNotificacionService]: " + id);
    }

    public void enviarNotificacion(String cliente, String mensaje){
        System.out.println("[Notificacion: " + id + "] \nEnviando notificación al celular de " + cliente + ": \"" + mensaje + "\"");
    }
}
