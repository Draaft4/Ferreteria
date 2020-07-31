package Controladores;

import DAO.CategoriaDB;
import Modelo.Categoria;
import java.util.ArrayList;
import java.util.List;

public class ControladorCategorias implements ControladorGenerico{
        
    CategoriaDB base = new CategoriaDB();
    ArrayList <Categoria> categoria;
    
    public ControladorCategorias() {
        categoria= base.ListCategorias();
    }
    
    public void print(){
        for(Categoria categoria: categoria){
            System.out.println(categoria.toString());
        }
                
    }

    public ArrayList<Categoria> getCategoria() {
        return categoria;
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
