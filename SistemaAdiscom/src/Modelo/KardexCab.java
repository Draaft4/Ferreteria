package Modelo;

import java.util.ArrayList;

public class KardexCab {

    private int id;
    private int valMin;
    private String detalles;
    private ArrayList<KardexDet> detall;

    public KardexCab(int id, int valMin, String detalles, ArrayList<KardexDet> detall) {
        this.id = id;
        this.valMin = valMin;
        this.detalles = detalles;
        this.detall = detall;

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

    public ArrayList<KardexDet> getDetall() {
        return detall;
    }

    public void addDetall(KardexDet detall) {
        this.detall.add(detall);
    }

    @Override
    public String toString() {
        String det = "";
        for (KardexDet kardexDet : detall) {
            det += "\n" + kardexDet.toString();
        }
        return "KardexCab{" + "id=" + id + ", valMin=" + valMin + ", detalle=" + detalles + "\nDetalles=" + det + '}';
    }

}
