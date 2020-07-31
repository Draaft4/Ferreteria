package Modelo;

public class Producto {

    private int codigo;
    private String nombre;
    private String desc;
    private double precio;
    private int stock;
    private String procedencia; 
    private Categoria cat;

    public Producto(int codigo, String nombre, String desc, double precio, int stock,String procedencia,Categoria cat) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.desc = desc;
        this.precio = precio;
        this.stock = stock;
        this.cat = cat;
        this.procedencia = procedencia;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public Categoria getCat() {
        return cat;
    }

    public void setCat(Categoria cat) {
        this.cat = cat;
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
        return "Producto{" + "codigo=" + codigo + ", nombre=" + nombre + ", desc="
                + desc + ", precio=" + precio + ", stock=" + stock + 
                ", procedencia=" + procedencia + ", cat=" + cat.toString() + '}';
    }

    
}
