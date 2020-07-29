package Modelo;

public class Producto {

    private int codigo;
    private String nombre;
    private String desc;
    private double precio;
    private int stock;

    public Producto(int codigo, String nombre, String desc, double precio, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.desc = desc;
        this.precio = precio;
        this.stock = stock;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", nombre=" + nombre + ", desc=" + desc + ", precio=" + precio + ", stock=" + stock + '}';
    }
    
}
