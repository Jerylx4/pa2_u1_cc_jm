package ec.edu.uce.pa.paquete.interceptors;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@MedirTiempo 
@Interceptor 
@Priority((Interceptor.Priority.APPLICATION + 4)) 
public class MedirTiempoInterceptor {

    @AroundInvoke 
    public Object interceptar(InvocationContext context) throws Exception{
        long inicial = System.currentTimeMillis();

        Object resultado = context.proceed();

        long fin = System.currentTimeMillis() - inicial;

        System.out.println("[TiempoInterceptor]: El metodo tardó " + fin + " ms en ejecutarse");

        return resultado;
    }

}
