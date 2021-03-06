package DAO;

import ConexionBD.BaseDeDatos;
import Modelo.TarjetaCredito;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class TarjetaDB {

    public ArrayList<TarjetaCredito> ListTarjeta() {
        ArrayList<TarjetaCredito> tarjeta = new ArrayList();
        try {
            Connection cnx = BaseDeDatos.getConnection();
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM fr_tarjetas order by 1");
            while (rs.next()) {
                int codigo = rs.getInt("tar_id");
                Date fechaVenc = rs.getDate("tar_fecha_vencimiento");
                String numero = rs.getString("tar_numero");
                String cvv = rs.getString("tar_cvv");

                TarjetaCredito cl = new TarjetaCredito(codigo, fechaVenc, numero, cvv);
                tarjeta.add(cl);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error en listado");
        }
        return tarjeta;
    }

    public void insert(TarjetaCredito tarjetaCredito) {
        try {
            Connection cnx = BaseDeDatos.getConnection();
            // permite hacer transacciones eliminar insertar
            PreparedStatement pst = cnx.prepareStatement("INSERT INTO  "
                    + "FR_Tarjetas (  tar_id,tar_fecha_vencimiento ,tar_numero,"
                    + "tar_cvv) "
                    + "VALUES(   ?, ?, ? ,?)");
            pst.setInt(1, tarjetaCredito.getCodigo());
            pst.setDate(2, new java.sql.Date(tarjetaCredito.getFechaVenc().getTime()));
            pst.setString(3, tarjetaCredito.getNumero());
            pst.setString(4, tarjetaCredito.getCvv());

            pst.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
