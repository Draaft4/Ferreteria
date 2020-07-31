
package Controladores;

import DAO.TarjetaDB;
import Modelo.TarjetaCredito;
import java.util.ArrayList;
import java.util.List;


public class ControladorTarjeta implements ControladorGenerico {
    TarjetaDB base = new TarjetaDB();
    ArrayList <TarjetaCredito> tarjeta;
    
    public ControladorTarjeta() {
        tarjeta= base.ListTarjeta();
    }
    
    public void print(){
        for(TarjetaCredito tarjeta: tarjeta){
            
            System.out.println(tarjeta.toString());
        }
                
    }
     public ArrayList<TarjetaCredito> getTarjetaCredito() {
        return tarjeta;
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
