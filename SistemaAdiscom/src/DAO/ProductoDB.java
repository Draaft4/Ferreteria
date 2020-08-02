package DAO;

import ConexionBD.BaseDeDatos;
import Modelo.Categoria;
import Modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProductoDB {

    ArrayList<Categoria> listCategoria;

    public ProductoDB(ArrayList<Categoria> listCategoria) {
        this.listCategoria = listCategoria;
    }

    public ArrayList<Producto> ListProductos() {
        ArrayList<Producto> producto = new ArrayList();
        try {
            Connection cnx = BaseDeDatos.getConnection();
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM fr_productos");
            while (rs.next()) {
                Categoria cat = null;
                int codigo = rs.getInt("pro_id");
                String nombre = rs.getString("pro_nombre");
                String desc = rs.getString("pro_descripcion");
                double precio = rs.getDouble("pro_precio_unitario");
                int stock = rs.getInt("pro_stock");
                String procedencia = rs.getString("pro_procedencia");
                int catid = rs.getInt("fr_categorias_cat_id");
                for (Categoria categoria : listCategoria) {
                    if (categoria.getCodigo() == catid) {
                        cat = categoria;
                    }
                }
                int idKarCab = rs.getInt("fr_kardex_cabecera_kar_id");
                Producto cl = new Producto(codigo, nombre, desc, precio, stock, procedencia, cat,idKarCab);
                producto.add(cl);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error en listado");
        }
        return producto;
    }
    
    
    public void insert(Producto producto) {
        try {
            Connection cnx = BaseDeDatos.getConnection();
            //permite hacer transacciones eliminar insertar
            PreparedStatement pst = cnx.prepareStatement("INSERT INTO  "
                    + "FR_Productos (  pro_id,pro_nombre ,pro_descripcion,pro_precio_unitario," +
                    "pro_stock,pro_procedencia,fr_categorias_cat_id, fr_kardex_cabecera_kar_id) "
                    + "VALUES(  FR_productos_SEQ.nextval, ?, ?, ? ,?,?,?)");
            pst.setString(1, producto.getNombre());
            pst.setString(2, producto.getDesc());
            pst.setString(3, String.valueOf(producto.getPrecio()));
            pst.setString(4, String.valueOf(producto.getStock()));
            pst.setString(5, producto.getProcedencia());
            pst.setString(6, producto.getCat().getCodigo()+"");
            pst.setString(7, String.valueOf(producto.getIdKardexCab()));
            pst.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

}
