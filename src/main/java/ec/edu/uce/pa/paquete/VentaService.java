package ec.edu.uce.pa.paquete;

import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped 
public class VentaService {

    private final UUID id = UUID.randomUUID();

    private CalculadoraDescuento descuentoRegular;
    private CalculadoraDescuento descuentoVIP;

    @Inject 
    Auditoria auditoria;

    
    @Inject 
    public VentaService(@Named("regular")CalculadoraDescuento descuentoRegular, @Named("vip") CalculadoraDescuento descuentoVIP) {
        this.descuentoRegular = descuentoRegular;
        this.descuentoVIP = descuentoVIP;
        System.out.println("Instancia de VentaService creada con uuid: " + id);
    }

    public void procesarVenta(Venta venta){
        System.out.println("Procesando venta núm " + venta.getNumero() + " en VentaService uuid: " + id);

        double valorDescuento = 0;
        int porcentaje = 0;

        if ("VIP".equalsIgnoreCase(venta.getTipoCliente())) {
            valorDescuento = descuentoVIP.calcular(venta.getMonto());
            porcentaje = 15;
        } else {
            valorDescuento = descuentoRegular.calcular(venta.getMonto());
            porcentaje = 5;
        }

        venta.setValorDescuento(valorDescuento);
        venta.setPorcentajeDescuento(porcentaje);
        venta.setTotal(venta.getMonto() - valorDescuento);

        String mensaje = "\nVenta núm " + venta.getNumero() + " procesada\n" +
                         "Cliente: " + venta.getTipoCliente() + "\n" +
                         "Monto: " + venta.getMonto() + "\n" +
                         "Descuento: " + venta.getPorcentajeDescuento() + "%\n" +
                         "Total: " + venta.getTotal();
        auditoria.registrar("VentaService", mensaje);
    }
    
}
