package Controladores;

import DAO.KardexCabDB;
import DAO.KardexDetDB;
import Modelo.KardexCab;
import Modelo.KardexDet;
import Modelo.Producto;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ControladorKardexCabecera implements ControladorGenerico {

    KardexCabDB base = new KardexCabDB();
    KardexDetDB base1 = new KardexDetDB();

    ArrayList<KardexCab> listaKardexcab;
    ArrayList<KardexDet> listDetalles;

    public ControladorKardexCabecera(ArrayList<KardexDet> detalle) {
        this.listDetalles = detalle;
        listaKardexcab = base.ListKardexCab(detalle);
    }

    public void print() {
        for (KardexCab kardexcab : listaKardexcab) {
            System.out.println(kardexcab.toString());
        }
    }

    public int generarNuevo(Producto producto, int cant, int valmin) {
        int nuevoDetalle = listDetalles.get(listDetalles.size() - 1).getId() + 1;
        int nuevoCab = listaKardexcab.get(listaKardexcab.size() - 1).getId() + 1;
        Date fecha = new Date();
        KardexDet nuevoDet = new KardexDet(nuevoDetalle, fecha, "Compra", producto.getPrecio(), cant, (double) (producto.getPrecio() * cant), 0, 0, cant, (double) (producto.getPrecio() * cant), nuevoCab);
        ArrayList<KardexDet> nuevolist = new ArrayList();
        String detalle = "Control del movimiento del producto " + producto.getNombre();
        nuevolist.add(nuevoDet);
        KardexCab nuevoCabecera = new KardexCab(nuevoCab, valmin, detalle, nuevolist);
        base.insert(nuevoCabecera);
        base1.insert(nuevoDet);
        return nuevoCab;
    }

    public ArrayList<KardexCab> getKardexCab() {
        return listaKardexcab;
    }

    @Override
    public void create(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void read(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> find() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
