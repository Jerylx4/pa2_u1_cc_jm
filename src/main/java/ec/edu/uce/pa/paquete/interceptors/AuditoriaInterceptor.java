package ec.edu.uce.pa.paquete.interceptors;

import java.lang.reflect.Parameter;

import ec.edu.uce.pa.paquete.AuditoriaService;
import ec.edu.uce.pa.paquete.Pedido;
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
        
        //todo lo que está arriba se ejecuta antes de ejecutar el metodo interceptado
        Object resultado = context.proceed(); //ejecuta el metodo interceptado
        
        System.out.println("Retorno: " + resultado);

        String nombreMetodo = context.getMethod().getName();
        System.out.println("Auditoria[se está ejecutando el método: " + nombreMetodo +"]");
        System.out.println("Ejecuta lo que quiero que haga el interceptor");

        Parameter[] parametros = context.getMethod().getParameters();

        for(Parameter parametro : parametros){
            System.out.println("Parametro: " + parametro.getName());
        }

        Object[] valores = context.getParameters();

        Pedido pedido = (Pedido) valores[0];

        String cliente = pedido.getCliente();
        double total = pedido.getTotal();
        String correo = pedido.getCorreo();

        this.aS.guardarEnLaBase(cliente, total, correo);

        
        System.out.println("Mensaje luego de que se ejecuta el método interceptado");
        return resultado;
    }
}
