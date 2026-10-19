package ec.edu.uce.pa.paquete.negocio;

public class Matricula {
    private String estudiante;
    private String materia;
    private double valor;
    private String correo;

    public Matricula(){
    }

    public Matricula(String estudiante, String materia, double valor, String correo) {
        this.estudiante = estudiante;
        this.materia = materia;
        this.valor = valor;
        this.correo = correo;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    
}
