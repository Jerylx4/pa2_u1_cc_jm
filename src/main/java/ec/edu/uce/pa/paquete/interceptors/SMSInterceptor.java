package ec.edu.uce.pa.paquete.interceptors;

import ec.edu.uce.pa.paquete.Pedido;
import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@SMS 
@Interceptor 
@Priority((Interceptor.Priority.APPLICATION + 2)) 
public class SMSInterceptor {

    @AroundInvoke 
    public Object interceptor(InvocationContext context) throws Exception{

        Object resultado = context.proceed();

        Object[] valores = context.getParameters();

        Pedido p1 = (Pedido) valores[0];
        
        String cliente = p1.getCliente();
        String producto = p1.getProducto();
        String tel = p1.getTelefono();

        System.out.println("[SMS] Se ha enviado un SMS a " + cliente + " con numero de telefono " + tel +" por la compra de " + producto);

        return resultado;
    }
}
