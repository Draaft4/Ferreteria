package Modelo;

import java.util.Date;

public class KardexDet {
    
    private int id;
    private Date fechaEdit;
    private String detalle;
    private double valUnit;
    private int cantEntr;
    private double valTotlEnt;
    private int cantSal;
    private double valTotlSal;
    private int cantSaldo;
    private double saldo;
    private int cab;

    public KardexDet(int id, Date fechaEdit, String detalle, double valUnit, int cantEntr, double valTotlEnt, int cantSal, double valTotlSal, int cantSaldo, double saldo, int cab) {
        this.id = id;
        this.fechaEdit = fechaEdit;
        this.detalle = detalle;
        this.valUnit = valUnit;
        this.cantEntr = cantEntr;
        this.valTotlEnt = valTotlEnt;
        this.cantSal = cantSal;
        this.valTotlSal = valTotlSal;
        this.cantSaldo = cantSaldo;
        this.saldo = saldo;
        this.cab = cab;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaEdit() {
        return fechaEdit;
    }

    public void setFechaEdit(Date fechaEdit) {
        this.fechaEdit = fechaEdit;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public double getValUnit() {
        return valUnit;
    }

    public void setValUnit(double valUnit) {
        this.valUnit = valUnit;
    }

    public int getCantEntr() {
        return cantEntr;
    }

    public void setCantEntr(int cantEntr) {
        this.cantEntr = cantEntr;
    }

    public double getValTotlEnt() {
        return valTotlEnt;
    }

    public void setValTotlEnt(double valTotlEnt) {
        this.valTotlEnt = valTotlEnt;
    }

    public int getCantSal() {
        return cantSal;
    }

    public void setCantSal(int cantSal) {
        this.cantSal = cantSal;
    }

    public double getValTotlSal() {
        return valTotlSal;
    }

    public void setValTotlSal(double valTotlSal) {
        this.valTotlSal = valTotlSal;
    }

    public int getCantSaldo() {
        return cantSaldo;
    }

    public void setCantSaldo(int cantSaldo) {
        this.cantSaldo = cantSaldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getCab() {
        return cab;
    }

    public void setCab(int cab) {
        this.cab = cab;
    }

    @Override
    public String toString() {
        return "KardexDet{" + "id=" + id + ", fechaEdit=" + fechaEdit + ", detalle=" + detalle + ", valUnit=" + valUnit + ", cantEntr=" + cantEntr + ", valTotlEnt=" + valTotlEnt + ", cantSal=" + cantSal + ", valTotlSal=" + valTotlSal + ", cantSaldo=" + cantSaldo + ", saldo=" + saldo + ", cab=" + cab + '}';
    }
    
    
    
}
