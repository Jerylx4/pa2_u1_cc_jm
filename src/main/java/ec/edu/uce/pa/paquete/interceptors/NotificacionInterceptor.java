package ec.edu.uce.pa.paquete.interceptors;

import ec.edu.uce.pa.paquete.Factura;
import ec.edu.uce.pa.paquete.NotificacionService;
import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor 
@Notificar 
@Priority(Interceptor.Priority.APPLICATION + 3)
public class NotificacionInterceptor {

    @Inject
    private NotificacionService nS;

    @AroundInvoke
    public Object interceptar(InvocationContext context) throws Exception {
        System.out.println("[NotificacionInterceptor]: Preparando envío de notificación...");

        Object resultado = context.proceed();

        Object[] parametros = context.getParameters();
        if (parametros != null && parametros.length > 0 && parametros[0] instanceof Factura) {
            Factura f = (Factura) parametros[0];
            nS.enviarNotificacion(f.getCliente(), "Su factura por $" + f.getTotalConImpuesto() + " ha sido emitida con éxito.");
        }

        System.out.println("[NotificacionInterceptor]: Notificación procesada.");
        return resultado;
    }
}
