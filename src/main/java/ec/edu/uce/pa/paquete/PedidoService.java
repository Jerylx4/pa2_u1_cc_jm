package ec.edu.uce.pa.paquete;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

//@ApplicationScoped //delego el control al contenedor ArC
//@RequestScoped //para aplicaciones web
@Singleton 
public class PedidoService {

    @Inject 
    private MailService mS; //injectamos la clase

    public void realizar(Pedido pedido) {

        System.out.println("Realizando pedido...");

        IO.println("Pedido realizado para el cliente: " + pedido.getCliente());
        System.out.println("Producto: " + pedido.getProducto());
        System.out.println("Total: " + pedido.getTotal());
        System.out.println("Correo: " + pedido.getCorreo());

        System.out.println("Pedido realizado con exito.");

        String asunto = "Confirmacion de pedido";
        String correo = "Estimado " + pedido.getCliente() + ", su pedido de " +
                pedido.getProducto() + " por un total de $" + pedido.getTotal() +
                " ha sido realizado con exito.";
        this.mS.enviar(pedido.getCorreo(), asunto, correo); //this es una buena practica
    }

}
