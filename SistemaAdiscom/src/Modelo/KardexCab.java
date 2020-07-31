package Modelo;

import java.util.ArrayList;

public class KardexCab {
    
    private int id;
    private int valMin;
    private String detalles;

    public KardexCab(int id, int valMin, String detalles) {
        this.id = id;
        this.valMin = valMin;
        this.detalles = detalles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValMin() {
        return valMin;
    }

    public void setValMin(int valMin) {
        this.valMin = valMin;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return "KardexCab{" + "id=" + id + ", valMin=" + valMin + ", detalles=" + detalles + '}';
    }

  
}
