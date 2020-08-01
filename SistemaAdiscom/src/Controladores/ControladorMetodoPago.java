package Controladores;

import DAO.MetodoPagoDB;
import Modelo.MetodoPago;
import Modelo.TarjetaCredito;
import java.util.ArrayList;
import java.util.List;

public class ControladorMetodoPago implements ControladorGenerico {

    MetodoPagoDB base;
    ArrayList<MetodoPago> listMetodoPago;

    public ControladorMetodoPago(ArrayList<TarjetaCredito> listTarjeta) {
        base = new MetodoPagoDB(listTarjeta);
        listMetodoPago = base.ListMetodoPago();
    }

    public void print() {
        for (MetodoPago metpag : listMetodoPago) {
            System.out.println(metpag.toString());
        }
    }

    public ArrayList<MetodoPago> getMetodoPago() {
        return listMetodoPago;
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
