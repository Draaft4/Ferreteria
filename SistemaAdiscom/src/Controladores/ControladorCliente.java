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

    public Cliente searchCedula(String cedula) {

        Cliente cli = null;
        for (Cliente cliente : lista) {
            if (cedula.equalsIgnoreCase(cliente.getCedula())) {

                cli = cliente;
            }
        }
        return cli;
    }

}
