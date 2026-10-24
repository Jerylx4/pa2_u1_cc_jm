package ec.edu.uce.pa.paquete;

import io.quarkus.arc.Unremovable;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

//Ambitos y contextos
//@ApplicationScoped //su ambito es durante toda la aplicacion, es decir se crea una sola instancia de la clase y se comparte entre todos los componentes que la utilizan
//@RequestScoped //su ambito es en aplicaciones web durante la peticon request http, vive durante la peticion o request
//@SessionScoped //su ambito es durante la sesion del usuario, es decir se crea una instancia durante toda la ejecucion de la sesion y se comparte entre todos los componentes que la utilizan
//@Singleton //su ambito es durante toda la aplicacion, es decir se crea una sola instancia de la clase y se comparte entre todos los componentes que la utilizan
@Dependent //su ambito es durante la inyeccion de dependencias, es decir se crea una instancia y se comparte entre todos los componentes que la utilizan durante la inyeccion de dependencias

//@Singleton
@Named("mail")
public class MailService implements Notificacion{

    private Integer cantidad = 0;
    private String nombre;

    @Override
    public void enviar(String destino, String mensaje) {
        System.out.println("Enviando correo a : " + destino);
        System.out.println("Mensaje: " + mensaje);
        System.out.println("Correo enviado con exito.");
        System.out.println("Fin del envio del correo");
    }


    @Override 
    public Integer getCantidad() {
        return cantidad;
    }

    @Override 
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
