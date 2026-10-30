package ec.edu.uce.pa.paquete.interceptors;

import ec.edu.uce.pa.paquete.AuditoriaService;
import ec.edu.uce.pa.paquete.Factura;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Auditoria 
@Interceptor 
public class AuditoriaInterceptor {

    @Inject
    private AuditoriaService aS;

    @AroundInvoke 
    public Object interceptar(InvocationContext context) throws Exception{

        System.out.println("[AuditoriaInterceptor]: Capturando ejecución de factura...");
        Object resultado = context.proceed();

        Object[] parametros = context.getParameters();

        if (parametros != null && parametros.length > 0 && parametros[0] instanceof Factura) {

            Factura f1 = (Factura) parametros[0];
            aS.registrar(f1.getCliente(), f1.getTotalConImpuesto());
        }

        System.out.println("[AuditoriaInterceptor]: Auditoria completada con exito");

        return resultado;
    } 

}
