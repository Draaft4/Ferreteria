package Controladores;

import DAO.KardexCabDB;
import Modelo.KardexCab;
import java.util.ArrayList;
import java.util.List;

public class ControladorKardexCabecera implements ControladorGenerico {

      KardexCabDB base = new KardexCabDB();
    
    ArrayList<KardexCab> listaKardexcab;
    
    public ControladorKardexCabecera() {
        listaKardexcab = base.ListKardexCab();
    }
    
   
    
    public void print(){
        for (KardexCab kardexcab : listaKardexcab) {
            System.out.println(kardexcab.toString());
        }
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
