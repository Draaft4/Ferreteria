package Modelo;

import java.util.ArrayList;
import java.util.Date;

public class FacturaCab {

    private int id;
    private String numero;
    private Date fechaEmision;
    private double subtotal;
    private double desc;
    private double IVA;
    private double total;
    private String anulado;
    private Cliente cliente;
    private MetodoPago metodoPago;
    private ArrayList<FacturaDet> detalles;

    public FacturaCab(int id, String numero, Date fechaEmision, double subtotal, double desc, double IVA, double total, String anulado, Cliente cliente, MetodoPago metodoPago, ArrayList<FacturaDet> detalles) {
        this.id = id;
        this.numero = numero;
        this.fechaEmision = fechaEmision;
        this.subtotal = subtotal;
        this.desc = desc;
        this.IVA = IVA;
        this.total = total;
        this.anulado = anulado;
        this.cliente = cliente;
        this.metodoPago = metodoPago;
        this.detalles = detalles;
    }

    public String getAnulado() {
        return anulado;
    }

    public void setAnulado(String anulado) {
        this.anulado = anulado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getDesc() {
        return desc;
    }

    public void setDesc(double desc) {
        this.desc = desc;
    }

    public double getIVA() {
        return IVA;
    }

    public void setIVA(double IVA) {
        this.IVA = IVA;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public ArrayList<FacturaDet> getDetalles() {
        return detalles;
    }

    public void addDetalles(FacturaDet detalle) {
        this.detalles.add(detalle);
    }

    @Override
    public String toString() {
        String det = "";
        for (FacturaDet detalle : detalles) {
            det += "\n" + detalle.toString();
        }
        return "FacturaCab{" + "id=" + id + ", numero=" + numero + ", fechaEmision="
                + fechaEmision + ", subtotal=" + subtotal + ", desc="
                + desc + ", IVA=" + IVA + ", total=" + total + ", anulado="
                + anulado + ", cliente=" + cliente.toString() + ", metodoPago="
                + metodoPago.toString() + "\nDetalles=" + det + '}';
    }

}
