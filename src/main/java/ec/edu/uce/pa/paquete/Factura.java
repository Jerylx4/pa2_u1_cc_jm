package ec.edu.uce.pa.paquete;

public class Factura {
private String cliente;
    private double subtotal;
    private double totalConImpuesto;

    public Factura(String cliente, double subtotal) {
        this.cliente = cliente;
        this.subtotal = subtotal;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotalConImpuesto() {
        return totalConImpuesto;
    }

    public void setTotalConImpuesto(double totalConImpuesto) {
        this.totalConImpuesto = totalConImpuesto;
    }

    
}
