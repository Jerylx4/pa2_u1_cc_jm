package ec.edu.uce.pa.paquete;

import java.util.UUID;

import ec.edu.uce.pa.paquete.interceptors.Auditoria;
import ec.edu.uce.pa.paquete.interceptors.MedirTiempo;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped 
public class FacturaService {
    private final UUID id = UUID.randomUUID();

    public FacturaService() {
        System.out.println("[InstanciaFacturaService]: " + id);
    }

    @MedirTiempo 
    @Auditoria 
    public void emitirFactura(Factura factura) {
        System.out.println("[FacturaService: " + id + "]: Calculando impuestos para " + factura.getCliente());
        
        double impuesto = factura.getSubtotal() * 0.15;
        double total = factura.getSubtotal() + impuesto;
        
        factura.setTotalConImpuesto(total);
        
        System.out.println("[FacturaService]: Subtotal: $" + factura.getSubtotal() + " | IVA: $" + impuesto + " | Total: $" + total);
    }

}
