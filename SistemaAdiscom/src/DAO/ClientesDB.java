package DAO;

import ConexionBD.BaseDeDatos;
import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClientesDB {

    public ArrayList<Cliente> ListClientes() {
        ArrayList<Cliente> cliente = new ArrayList();
        try {
            Connection cnx = BaseDeDatos.getConnection();
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT  cli_id, cli_cedula_ruc, cli_nombre, cli_apellido, cli_telefono, cli_correo, cli_direccion "
                    + "FROM FR_CLIENTES ORDER BY 1");
            while (rs.next()) {
                int codigo = rs.getInt("cli_id");
                String cedula = rs.getString("cli_cedula_ruc");
                String nombre = rs.getString("cli_nombre");
                String apellido = rs.getString("cli_apellido");
                String telefono = rs.getString("cli_telefono");
                String correo = rs.getString("cli_correo");
                String direccion = rs.getString("cli_direccion");
                Cliente cl = new Cliente(codigo, nombre, apellido, telefono, cedula, direccion, correo);
                cliente.add(cl);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error en listado");
        }
        return cliente;
    }

    public void insert(Cliente cliente) {
        try {
            Connection cnx = BaseDeDatos.getConnection();
            //permite hacer transacciones eliminar insertar
            PreparedStatement pst = cnx.prepareStatement("INSERT INTO  "
                    + "FR_Clientes (  cli_id ,cli_cedula_ruc ,cli_nombre,cli_apellido,"
                    + "cli_telefono,cli_correo,cli_direccion) "
                    + "VALUES(  FR_CLIENTES_SEQ.nextval, ?, ?, ? ,?,?,?)");
            pst.setString(1, cliente.getCedula());
            pst.setString(2, cliente.getNombre());
            pst.setString(3, cliente.getApellido());
            pst.setString(4, cliente.getTelefono());
            pst.setString(5, cliente.getCorreo());
            pst.setString(6, cliente.getDireccion());
            pst.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

}
