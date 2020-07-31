package Controladores;

import DAO.KardexDetDB;
import Modelo.KardexCab;
import Modelo.KardexDet;
import java.util.ArrayList;
import java.util.List;

public class ControladorKardexDetalles implements ControladorGenerico {
        KardexDetDB base;
    ArrayList<KardexDet> listKardexDet;
    
    public ControladorKardexDetalles(ArrayList<KardexCab> listKardexCab) {
        base = new KardexDetDB(listKardexCab);
        
    }
    
    public void print (){
        for(KardexDet kardexcab : listKardexDet){
            System.out.println(kardexcab.toString());
        }
    }
    
    public ArrayList<KardexDet> getKardexDet() {
        return listKardexDet;
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
