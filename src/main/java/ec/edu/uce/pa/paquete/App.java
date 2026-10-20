package ec.edu.uce.pa.paquete;

import ec.edu.uce.pa.paquete.negocio.Matricula;
import ec.edu.uce.pa.paquete.negocio.MatriculaService;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain 
public class App implements QuarkusApplication {

    @Inject 
    private MatriculaService mS;
    public static void main(String[] args) {
        Quarkus.run(App.class, args);
    }

    @Override
    public int run(String... args){
        Matricula m1 = new Matricula("Jeryl Morales", "Programación avanzada II", 58.60, "jfmoralesc1@uce.edu.ec");
        mS.registrar(m1);
   
        return 0;
    }

}
