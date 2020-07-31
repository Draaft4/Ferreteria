package Controladores;

import DAO.ClientesDB;
import Modelo.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ControladorCliente implements ControladorGenerico{
    
    ClientesDB base = new ClientesDB();
    
    ArrayList<Cliente> lista;
    
    public ControladorCliente() {
        lista = base.ListClientes();
    }
    
    public void print(){
        for (Cliente cliente : lista) {
            System.out.println(cliente.toString());
        }
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
    
    
}
