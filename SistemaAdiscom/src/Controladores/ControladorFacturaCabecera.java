package Controladores;

import DAO.FacturaCabecerDB;
import Modelo.Cliente;
import Modelo.FacturaCab;
import Modelo.FacturaDet;
import Modelo.MetodoPago;
import java.util.ArrayList;
import java.util.List;

public class ControladorFacturaCabecera implements ControladorGenerico {

    FacturaCabecerDB base;
    ArrayList<FacturaCab> listCabecera;

    public ControladorFacturaCabecera(ArrayList<Cliente> listCliente, ArrayList<MetodoPago> listMetodoPago, ArrayList<FacturaDet> listDetalle) {
        base = new FacturaCabecerDB(listMetodoPago, listCliente, listDetalle);
        listCabecera = base.ListFacturasCab();
    }

    public void print() {
        for (FacturaCab cabecera : listCabecera) {
            System.out.println(cabecera.toString());
        }
    }

    public ArrayList<FacturaCab> getFacturaCab() {
        return listCabecera;
    }

    public ArrayList<FacturaCab> buscar(String parametro, int tipo) {
        ArrayList<FacturaCab> busqueda = new ArrayList<FacturaCab>();
        switch (tipo) {
            case 1:
                //Busqueda por codigo
                for (FacturaCab facturaCab : listCabecera) {
                    if (String.valueOf(facturaCab.getNumero()).equals(parametro)) {
                        busqueda.add(facturaCab);
                    }
                }
                break;
            case 2:
                //Busqueda por nombre
                for (FacturaCab facturaCab : listCabecera) {
                    if (facturaCab.getCliente().getNombre().equalsIgnoreCase(parametro)) {
                        busqueda.add(facturaCab);
                    }
                }
                break;

        }
        return busqueda;
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

    public void total(Object facturaDetalle) {

    }

    public void descuento(int descuento) {

    }

}
