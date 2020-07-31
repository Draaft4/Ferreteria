package Controladores;

import DAO.FacturaDetDB;
import Modelo.FacturaCab;
import Modelo.FacturaDet;
import Modelo.Producto;
import java.util.ArrayList;
import java.util.List;

public class ControladorFacturaDetalles implements ControladorGenerico{

    FacturaDetDB base;
    ArrayList<FacturaDet> listDetalle;
    
    public ControladorFacturaDetalles(ArrayList<Producto> listProducto, ArrayList<FacturaCab> listFacturaCab) {
        base = new FacturaDetDB(listFacturaCab,listProducto);
        listDetalle = base.ListFacturaDet();
    }
    
    public void print (){
        for(FacturaDet detalle : listDetalle){
            System.out.println(detalle.toString());
        }
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
