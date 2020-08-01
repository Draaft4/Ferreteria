package Controladores;

import DAO.FacturaCabecerDB;
import Modelo.Cliente;
import Modelo.FacturaCab;
import Modelo.FacturaDet;
import Modelo.MetodoPago;
import java.util.ArrayList;
import java.util.List;

public class ControladorFacturaCabecera implements ControladorGenerico{

    FacturaCabecerDB base;
    ArrayList<FacturaCab> listCabecera;
    
    
    public ControladorFacturaCabecera(ArrayList<Cliente> listCliente, ArrayList<MetodoPago> listMetodoPago,ArrayList<FacturaDet> listDetalle) {
        base = new FacturaCabecerDB(listMetodoPago,listCliente,listDetalle);
        listCabecera = base.ListFacturasCab();
    }
    
    public void print (){
        for(FacturaCab cabecera : listCabecera){
            System.out.println(cabecera.toString());
        }
    }
    
     public ArrayList<FacturaCab> getFacturaCab() {
        return listCabecera;
    }
    
    @Override
    public void create(Object obj) {
       
    }

    @Override
    public void read(String codigo) {
       
    }

    @Override
    public void update(Object obj) {
        
    }

    @Override
    public void delete(String codigo) {
        
    }

    @Override
    public List<Object> find() {
        
        return null;
        
    }
    
    public void total(Object facturaDetalle){
        
    }
    
    public void descuento(int descuento){
        
    }
    
}
