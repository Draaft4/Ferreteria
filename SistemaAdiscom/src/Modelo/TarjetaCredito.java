package Modelo;

import java.util.Date;

public class TarjetaCredito {

    private int codigo;
    private Date fechaVenc;
    private String numero;
    private String cvv;

    public TarjetaCredito(int codigo, Date fechaVenc, String numero, String cvv) {
        this.codigo = codigo;
        this.fechaVenc = fechaVenc;
        this.numero = numero;
        this.cvv = cvv;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFechaVenc() {
        return fechaVenc;
    }

    public void setFechaVenc(Date fechaVenc) {
        this.fechaVenc = fechaVenc;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    @Override
    public String toString() {
        return "TarjetaCredito{" + "codigo=" + codigo + ", fechaVenc=" + fechaVenc + ", numero=" + numero + ", cvv=" + cvv + '}';
    }

}
