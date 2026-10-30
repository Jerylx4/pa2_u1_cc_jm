package ec.edu.uce.pa.paquete;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.enterprise.context.Dependent;

@Dependent 
public class AuditoriaService {
    private final UUID id = UUID.randomUUID();

    public AuditoriaService(){
        System.out.println("[InstanciaAuditoriaService]: " + id);
    }

    public void registrar(String cliente, double total){
        System.out.println("[Auditoria: " + id + "] \n[Factura registrada] Cliente: " + cliente + ", Total: $" + total + " | Fecha: " + LocalDateTime.now());    
    }
}
