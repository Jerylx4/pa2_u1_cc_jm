package ec.edu.uce.pa.paquete;

import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped 
@Named("vip") 
public class DescuentoVIP implements CalculadoraDescuento{

    private final UUID id = UUID.randomUUID();


    public DescuentoVIP() {
        System.out.println("Instancia de descuento vip creada con uuid: " + id);
    }

    @Override
    public double calcular(double monto) {
        System.out.println("Descuento vip con uuid: " + id + " aplicado");
        return monto * 0.15;
    }

}
