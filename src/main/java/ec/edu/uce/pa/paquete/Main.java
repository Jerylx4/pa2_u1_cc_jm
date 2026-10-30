package ec.edu.uce.pa.paquete;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import jakarta.inject.Inject;

public class Main implements QuarkusApplication {

    @Inject 
    FacturaService fS;

    public static void main(String[] args) {
        Quarkus.run(Main.class, args);
    }

    @Override
    public int run(String... args) throws Exception {
        System.out.println("---------------- SISTEMA INICIADO ----------------");

        Factura f1 = new Factura("Jeryl Morales", 150.00);
        fS.emitirFactura(f1);

        System.out.println("--------------------------------------------------");
        return 0;
    }
}
