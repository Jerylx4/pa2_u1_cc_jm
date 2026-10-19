package ec.edu.uce.pa.paquete.negocio;

public class MatriculaService {
    public void registrar(Matricula m) {

        System.out.println("Generando matricula...");
        System.out.println("Matricula generada para el estudiante: " + m.getEstudiante());
        System.out.println("Materia: " + m.getMateria());
        System.out.println("Arancel: $" + m.getValor());
        System.out.println("Correo institucional: " + m.getCorreo());
        System.out.println("Matricula generada con exito");

        PagoService pS = new PagoService(); // Creo manualmente el objeto de PagoService
        pS.procesarCobro(m.getEstudiante(), m.getValor());
        pS = null; // lo hago elegible para el gc

        NotificacionService nS = new NotificacionService(); // Creo manualmente el objeto de NotificacionService

        String asunto = "Confirmación de matricula";
        String msg = "Estimado " + m.getEstudiante() + ", su matricula en la asignatura de " +
                m.getMateria() + " con un valor de $" + m.getValor() +
                " ha sido registrada con exito.";
        nS.enviar(m.getCorreo(), asunto, msg);
        nS = null; // lo hago elegible para el gc
    }
}
