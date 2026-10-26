package ec.edu.uce.pa.paquete;

import java.util.UUID;

import jakarta.enterprise.context.Dependent;

@Dependent 
public class Auditoria {
    private final UUID id = UUID.randomUUID();

    public Auditoria(){
        System.out.println("Instancia de auditoria creada con uuid: " + id);
    }

    public void registrar(String origen, String mensaje){
        System.out.println("[Auditoria: " + id + "] | [Mensaje: " + mensaje + "]");
    }


}
