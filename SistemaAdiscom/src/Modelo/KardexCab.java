package Modelo;

import java.util.ArrayList;

public class KardexCab {
    
    private int id;
    private int valMin;
    private ArrayList<KardexDet> detalles;

    public KardexCab(int id, int valMin) {
        this.id = id;
        this.valMin = valMin;
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

    public ArrayList<KardexDet> getDetalles() {
        return detalles;
    }

    public void addDetalles(KardexDet detalle) {
        this.detalles.add(detalle);
    }

    @Override
    public String toString() {
        String det = "";
        for (KardexDet detalle : detalles) {
            det+="\n"+detalle.toString();
        }
        return "KardexCab{" + "id=" + id + ", valMin=" + valMin + '}'+ 
                "\nDetalles:"+det;
    }
    
}
