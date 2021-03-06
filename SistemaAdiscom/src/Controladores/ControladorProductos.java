package Controladores;

import DAO.ProductoDB;
import Modelo.Categoria;
import Modelo.Producto;
import java.util.ArrayList;
import java.util.List;

public class ControladorProductos implements ControladorGenerico {

    ProductoDB base;
    ArrayList<Producto> listProducto;

    public ControladorProductos(ArrayList<Categoria> listCategoria) {
        base = new ProductoDB(listCategoria);
        listProducto = base.ListProductos();
    }

    public void print() {
        for (Producto producto : listProducto) {
            System.out.println(producto.toString());
        }
    }

    public ArrayList<Producto> buscar(String parametro, int tipo) {
        ArrayList<Producto> busqueda = new ArrayList<Producto>();
        switch (tipo) {
            case 1:
                //Busqueda por codigo
                for (Producto producto : listProducto) {
                    if (String.valueOf(producto.getCodigo()).equals(parametro)) {
                        busqueda.add(producto);
                    }
                }
                break;
            case 2:
                //Busqueda por nombre
                for (Producto producto : listProducto) {
                    if (producto.getNombre().equalsIgnoreCase(parametro)) {
                        busqueda.add(producto);
                    }
                }
                break;

        }
        return busqueda;
    }

    public ArrayList<Producto> getProducto() {
        return listProducto;
    }

    public void insertProducto(Producto producto) {
        base.insert(producto);
    }

    public void actualizarInformacion() {
        listProducto = base.ListProductos();
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

    public Producto searchCodigo(int codigo) {

        Producto pro = null;

        for (Producto producto : listProducto) {

            if (codigo == producto.getCodigo()) {
                pro = producto;
            }
        }

        return pro;
    }

}
