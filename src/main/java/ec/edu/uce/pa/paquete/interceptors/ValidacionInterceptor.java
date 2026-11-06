package ec.edu.uce.pa.paquete.interceptors;

import ec.edu.uce.pa.paquete.Factura;
import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@ValidarFactura
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
public class ValidacionInterceptor {

    @AroundInvoke
    public Object interceptar(InvocationContext context) throws Exception {
        System.out.println("[ValidacionInterceptor]: Validando datos de la factura...");

        Object[] parametros = context.getParameters();
        if (parametros != null && parametros.length > 0 && parametros[0] instanceof Factura) {
            Factura f = (Factura) parametros[0];

            if (f.getCliente() == null || f.getCliente().isBlank()) {
                throw new IllegalArgumentException("[ValidacionInterceptor Error]: El nombre del cliente no puede estar vacío.");
            }
            if (f.getSubtotal() <= 0) {
                throw new IllegalArgumentException("[ValidacionInterceptor Error]: El subtotal debe ser mayor a cero.");
            }
        }

        System.out.println("[ValidacionInterceptor]: Factura válida. Continuando...");
        return context.proceed();
    }
}