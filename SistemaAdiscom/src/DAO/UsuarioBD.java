package DAO;

import ConexionBD.BaseDeDatos;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsuarioBD {

    public ArrayList<Usuario> ListUsuario() {
        ArrayList<Usuario> usuario = new ArrayList();
        try {
            Connection cnx = BaseDeDatos.getConnection();
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM fr_usuarios");
            while (rs.next()) {
                int idUsr = rs.getInt("idusr");
                String password = rs.getString("contraseña");
                int nivelAcceso = rs.getInt("nivelacceso");
                String user = rs.getString("usuario");

                Usuario cl = new Usuario(idUsr, password, nivelAcceso, user);
                usuario.add(cl);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error en listado");
        }
        return usuario;
    }
}
