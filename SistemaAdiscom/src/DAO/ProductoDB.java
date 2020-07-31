package DAO;

import ConexionBD.BaseDeDatos;
import Modelo.Categoria;
import Modelo.Producto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductoDB {
    
    ArrayList<Categoria> listCategoria;

    public ProductoDB(ArrayList<Categoria> listCategoria) {
        this.listCategoria = listCategoria;
    }
    
    public ArrayList<Producto> ListProductos(){
    ArrayList<Producto> producto = new ArrayList();
    try{
        Connection cnx = BaseDeDatos.getConnection();
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM fr_productos");
        while (rs.next()){
            Categoria cat = null;
            int codigo= rs.getInt("pro_id");
            String nombre= rs.getString("pro_nombre");
            String desc= rs.getString("pro_descripcion");
            double precio= rs.getDouble("pro_precio_unitario");
            int stock= rs.getInt("pro_stock");
            String procedencia= rs.getString("pro_procedencia");
            int catid = rs.getInt("fr_categorias_cat_id");
            for (Categoria categoria : listCategoria) {
                if(categoria.getCodigo() == catid){
                    cat = categoria;
                }
            }
           Producto cl= new Producto(codigo,  nombre,  desc,  precio, stock, procedencia, cat);
           producto.add(cl);
        }
    }catch (SQLException ex){
        System.out.println(ex.getMessage());
        System.out.println("Error en listado");
    }
    return producto;
    }
    
    
}
