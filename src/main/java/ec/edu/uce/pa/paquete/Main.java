package ec.edu.uce.pa.paquete;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain 
public class Main implements QuarkusApplication {

    @Inject 
    private PedidoService pS;

    @Inject
    private CompraService cS;

    public static void main(String[] args) {
        Quarkus.run(Main.class, args);
    }

    @Override 
    public int run(String... args){
        System.out.println("Iniciando app");

        Pedido pedido = new Pedido("Juan Perez", "laptop", 1500.00, "juanp@gmail.com"); // creamos manualmente el objeto                                                               // de la calse pedido
        pedido.setTelefono("0961915937");
        this.pS.realizar(pedido);

        Compra compra = new Compra("Jeryl Morales", "PC", 1900.00, "jfmoralesc1@uce.edu.ec");
        compra.setTelefono("0961915937");
        this.cS.realizar(compra);


        return 0;
    }
}
