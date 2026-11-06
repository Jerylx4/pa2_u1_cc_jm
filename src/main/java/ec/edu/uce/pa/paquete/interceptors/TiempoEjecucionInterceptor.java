package ec.edu.uce.pa.paquete.interceptors;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@MedirTiempo
@Interceptor
@Priority(Interceptor.Priority.APPLICATION + 2) 
public class TiempoEjecucionInterceptor {

    @AroundInvoke 
    public Object interceptar(InvocationContext context) throws Exception{

        long inicio = System.currentTimeMillis();
        System.out.println("[TiempoInterceptor]: Iniciando cronómetro para (" + context.getMethod().getName() + ")");

        Object resultado = context.proceed();

        long duracion = System.currentTimeMillis() - inicio;
        System.out.println("[TiempoInterceptor]: El metodo tardó " + duracion + " ms en ejecutarse");

        return resultado;
    }
}
