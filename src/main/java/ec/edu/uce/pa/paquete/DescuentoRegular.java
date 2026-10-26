package ec.edu.uce.pa.paquete;

import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped 
@Named("regular") 
public class DescuentoRegular implements CalculadoraDescuento{

    private final UUID id = UUID.randomUUID();

    public DescuentoRegular() {
        System.out.println("Instancia de descuento regular creada con uuid: " + id);
    }

    @Override
    public double calcular(double monto) {
        System.out.println("Descuento regular con uuid: " + id + " aplicado");
        return monto * 0.05;
    }

}
