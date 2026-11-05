package ec.edu.uce.pa.paquete.interceptors;

import ec.edu.uce.pa.paquete.Pedido;
import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Mail 
@Interceptor 
@Priority((Interceptor.Priority.APPLICATION + 1)) 
public class MailInterceptor {

    @AroundInvoke 
    public Object interceptar(InvocationContext context) throws Exception{

        Object resultado = context.proceed();

        Object[] valores = context.getParameters();

        Pedido p1 = (Pedido) valores[0];
        
        String cliente = p1.getCliente();
        String producto = p1.getProducto();
        String correo = p1.getCorreo();

        System.out.println("[Mail] Se ha enviado un mail a " + cliente + " con correo " + correo +" por la compra de " + producto);

        return resultado;
    }
}
