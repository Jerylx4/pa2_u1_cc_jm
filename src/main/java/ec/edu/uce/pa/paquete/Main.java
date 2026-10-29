package ec.edu.uce.pa.paquete;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain 
public class Main implements QuarkusApplication {

    @Inject 
    private PedidoService pS;

    public static void main(String[] args) {
        Quarkus.run(Main.class, args);
    }

    @Override 
    public int run(String... args){
        System.out.println("Iniciando app");

        Pedido pedido = new Pedido("Juan Perez", "laptop", 1500.00, "juanp@gmail.com"); // creamos manualmente el objeto                                                               // de la calse pedido
        pedido.setTelefono("0961915937");
        this.pS.realizar(pedido, "valor 1");

        return 0;
    }
}
