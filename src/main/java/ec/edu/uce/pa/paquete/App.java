package ec.edu.uce.pa.paquete;

import ec.edu.uce.pa.paquete.negocio.Matricula;
import ec.edu.uce.pa.paquete.negocio.MatriculaService;

public class App {
    public static void main(String[] args) {
        Matricula m1 = new Matricula("Jeryl Morales", "Programación avanzada II", 58.60, "jfmoralesc1@uce.edu.ec");
        MatriculaService mS = new MatriculaService();
        mS.registrar(m1);

        m1 = null;
        mS = null;
    }
}
