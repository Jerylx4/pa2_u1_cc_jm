package ec.edu.uce.pa.paquete;

import ec.edu.uce.pa.paquete.interceptors.Auditoria;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped 
public class PedidoService {

    @Auditoria 
    public String realizar(Pedido pedido, String valor1) {
        long inicio = System.currentTimeMillis();

        try {

        Thread.sleep(1500);

        }catch (Exception e){}

        System.out.println("Realizando pedido...");
        System.out.println("Pedido realizado para el cliente: " + pedido.getCliente());        
        System.out.println("Producto: " + pedido.getProducto());
        System.out.println("Total: " + pedido.getTotal());
        System.out.println("Correo: " + pedido.getCorreo());
        System.out.println("Pedido realizado con exito.");

        long fin = System.currentTimeMillis() - inicio;
        System.out.println("[TIEMPO] El tiempo que se demora en realizar un pedido es: " + fin + " ms");
       
        return "Pedido realizado con exito (return)";
    
    }



}
