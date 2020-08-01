package DAO;

import ConexionBD.BaseDeDatos;
import Modelo.Categoria;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CategoriaDB {

    public ArrayList<Categoria> ListCategorias() {
        ArrayList<Categoria> categoria = new ArrayList();
        try {
            Connection cnx = BaseDeDatos.getConnection();
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM fr_categorias");
            while (rs.next()) {
                int codigo = rs.getInt("cat_id");
                String nombreCat = rs.getString("cat_nombre");
                String desc = rs.getString("cat_descripcion");

                Categoria cl = new Categoria(codigo, nombreCat, desc);
                categoria.add(cl);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error en listado");
        }
        return categoria;
    }
}
