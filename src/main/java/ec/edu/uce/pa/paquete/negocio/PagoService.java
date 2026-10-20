package ec.edu.uce.pa.paquete.negocio;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped 
public class PagoService {
    public void procesarCobro(String estudiante, double valor) {
        System.out.println("--- Procesando pago ---");
        System.out.println("Estudiante: " + estudiante);
        System.out.println("Valor a pagar: " + valor);
        System.out.println("Pago aprobado");
    }
}
