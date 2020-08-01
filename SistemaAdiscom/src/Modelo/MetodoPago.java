package Modelo;

public class MetodoPago {

    private int codigo;
    private String tipoMetodo;
    private TarjetaCredito tarjeta;

    public MetodoPago(int codigo, String tipoMetodo, TarjetaCredito tarjeta) {
        this.codigo = codigo;
        this.tipoMetodo = tipoMetodo;
        this.tarjeta = tarjeta;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipoMetodo() {
        return tipoMetodo;
    }

    public void setTipoMetodo(String tipoMetodo) {
        this.tipoMetodo = tipoMetodo;
    }

    public TarjetaCredito getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(TarjetaCredito tarjeta) {
        this.tarjeta = tarjeta;
    }

    @Override
    public String toString() {
        if (tarjeta == null) {
            return "MetodoPago{" + "codigo=" + codigo + ", tipoMetodo=" + tipoMetodo + ", tarjeta=" + "null" + '}';
        }
        return "MetodoPago{" + "codigo=" + codigo + ", tipoMetodo=" + tipoMetodo + ", tarjeta=" + tarjeta.toString() + '}';//
    }

}
