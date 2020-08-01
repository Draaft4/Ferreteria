package Controladores;

import DAO.ClientesDB;
import Modelo.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ControladorCliente implements ControladorGenerico {

    ClientesDB base = new ClientesDB();

    ArrayList<Cliente> lista;

    public ControladorCliente() {
        lista = base.ListClientes();
    }

    public void print() {

        for (Cliente cliente : lista) {
            System.out.println(cliente.toString());
        }
    }
    
    public  ArrayList<Cliente> buscar(String parametro, int tipo){
         ArrayList<Cliente> busqueda = new ArrayList<Cliente>();
         switch(tipo){
             case 1:
                 //Busqueda por cedula
                 for (Cliente cliente : lista) {
                     if(cliente.getCedula().equals(parametro)){
                         busqueda.add(cliente);
                     }
                 }
                 break;
             case 2:
                 //Busqueda por nombre
                 for (Cliente cliente : lista) {
                     if(cliente.getNombre().equalsIgnoreCase(parametro)){
                         busqueda.add(cliente);
                     }
                 }
                 break;
             case 3:
                 //Busqueda por apellido
                 for (Cliente cliente : lista) {
                     if(cliente.getApellido().equalsIgnoreCase(parametro)){
                         busqueda.add(cliente);
                     }
                 }
                 break;
             case 4:
                 //Busqueda por correo
                 for (Cliente cliente : lista) {
                     if(cliente.getCorreo().equals(parametro)){
                         busqueda.add(cliente);
                     }
                 }
                 break;
         }
         return busqueda;
    }

    public ArrayList<Cliente> getCliente() {
        return lista;
    }

    @Override
    public void create(Object obj) {

    }

    @Override
    public void read(String codigo) {
        ;

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
