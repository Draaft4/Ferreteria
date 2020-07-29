package Modelo;

public class FacturaDet {
    
    private int id;
    private int cant;
    private double precio;
    private double desc;
    private double subtotal;
    private boolean devuelto;
    private int idProducto;

    public FacturaDet(int id, int cant, double precio, double desc, double subtotal, boolean devuelto, int idProducto) {
        this.id = id;
        this.cant = cant;
        this.precio = precio;
        this.desc = desc;
        this.subtotal = subtotal;
        this.devuelto = devuelto;
        this.idProducto = idProducto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getDesc() {
        return desc;
    }

    public void setDesc(double desc) {
        this.desc = desc;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public boolean isDevuelto() {
        return devuelto;
    }

    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public String toString() {
        return "FacturaDet{" + "id=" + id + ", cant=" + cant + ", precio=" + 
                precio + ", desc=" + desc + ", subtotal=" + subtotal + 
                ", devuelto=" + devuelto + ", idProducto=" + idProducto + '}';
    }
    
}
