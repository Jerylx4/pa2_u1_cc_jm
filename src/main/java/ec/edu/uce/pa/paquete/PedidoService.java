package ec.edu.uce.pa.paquete;

import ec.edu.uce.pa.paquete.interceptors.Auditoria;
import ec.edu.uce.pa.paquete.interceptors.Mail;
import ec.edu.uce.pa.paquete.interceptors.MedirTiempo;
import ec.edu.uce.pa.paquete.interceptors.SMS;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped 
public class PedidoService {

    @Mail 
    @SMS 
    @MedirTiempo 
    @Auditoria 
    public String realizar(Pedido pedido, String valor1) {

        try {

        Thread.sleep(1500);

        }catch (Exception e){}

        System.out.println("Realizando pedido...");
        System.out.println("Pedido realizado para el cliente: " + pedido.getCliente());        
        System.out.println("Producto: " + pedido.getProducto());
        System.out.println("Total: " + pedido.getTotal());
        System.out.println("Correo: " + pedido.getCorreo());
        System.out.println("Pedido realizado con exito.");
       
        return "Pedido realizado con exito (return)";
    
    }



}
