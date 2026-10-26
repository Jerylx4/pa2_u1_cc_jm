package ec.edu.uce.pa.paquete;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import jakarta.inject.Inject;

public class Main implements QuarkusApplication{

    @Inject 
    VentaService vS;

    @Inject 
    Auditoria aS;

    public static void main(String[] args) {
        Quarkus.run(Main.class, args);
    }

    @Override
    public int run(String... args) throws Exception {
        System.out.println("==== SIMULADOR DE DESCUENTOS ====");
        aS.registrar("Main", "Iniciando el sistema");

        Venta v1 = new Venta(1, "Regular", 100.00);
        Venta v2 = new Venta(2, "Vip", 200.00);
        Venta v3 = new Venta(3, "Regular", 300.00);
        Venta v4 = new Venta(4, "Vip", 500.00);

        vS.procesarVenta(v1);
        vS.procesarVenta(v2);
        vS.procesarVenta(v3);
        vS.procesarVenta(v4);

        aS.registrar("Main", "Fin del sistema");
        return 0;
    }
}
