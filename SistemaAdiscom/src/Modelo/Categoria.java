package Modelo;

public class Categoria {

    private int codigo;
    private String nombreCat;
    private String desc;

    public Categoria(int codigo, String nombreCat, String desc) {
        this.codigo = codigo;
        this.nombreCat = nombreCat;
        this.desc = desc;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreCat() {
        return nombreCat;
    }

    public void setNombreCat(String nombreCat) {
        this.nombreCat = nombreCat;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "CategriaProducto{" + "codigo=" + codigo + ", nombreCat=" + nombreCat + ", desc=" + desc + '}';
    }

}
