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
    private ArrayList<FacturaDet> detalles;

    public FacturaCab(int id, String numero, Date fechaEmision, double subtotal, double desc, double IVA, double total) {
        this.id = id;
        this.numero = numero;
        this.fechaEmision = fechaEmision;
        this.subtotal = subtotal;
        this.desc = desc;
        this.IVA = IVA;
        this.total = total;
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
            det+="\n"+detalle.toString();
        }
        return "FacturaCab{" + "id=" + id + ", numero=" + numero + 
                ", fechaEmision=" + fechaEmision + ", subtotal=" + subtotal + 
                ", desc=" + desc + ", IVA=" + IVA + ", total=" + total + 
                ", detalles=" + detalles + '}';
    }
    
    
    
}
