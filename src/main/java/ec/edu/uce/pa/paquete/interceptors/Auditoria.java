package ec.edu.uce.pa.paquete.interceptors;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.interceptor.InterceptorBinding;

@InterceptorBinding //le da el comportamiento de interceptor
@Retention(RetentionPolicy.RUNTIME) //se ejecuta cuando se ejecuta el software
@Target({ElementType.TYPE, ElementType.METHOD}) //el interceptor va sobre un metodo
public @interface Auditoria {

}
