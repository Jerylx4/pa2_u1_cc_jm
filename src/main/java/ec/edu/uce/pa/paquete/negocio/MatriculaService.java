package ec.edu.uce.pa.paquete.negocio;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped 
public class MatriculaService {

    @Inject 
    private PagoService pS;

    @Inject 
    private NotificacionService nS;

    public void registrar(Matricula m) {

        System.out.println("Generando matricula...");
        System.out.println("Matricula generada para el estudiante: " + m.getEstudiante());
        System.out.println("Materia: " + m.getMateria());
        System.out.println("Arancel: $" + m.getValor());
        System.out.println("Correo institucional: " + m.getCorreo());
        System.out.println("Matricula generada con exito");

        pS.procesarCobro(m.getEstudiante(), m.getValor());

        String asunto = "Confirmación de matricula";
        String msg = "Estimado " + m.getEstudiante() + ", su matricula en la asignatura de " +
                m.getMateria() + " con un valor de $" + m.getValor() +
                " ha sido registrada con exito.";
        nS.enviar(m.getCorreo(), asunto, msg);
    }
}
