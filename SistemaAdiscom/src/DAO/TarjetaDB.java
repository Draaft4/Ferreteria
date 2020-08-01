package DAO;

import ConexionBD.BaseDeDatos;
import Modelo.TarjetaCredito;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class TarjetaDB {

    public ArrayList<TarjetaCredito> ListTarjeta() {
        ArrayList<TarjetaCredito> tarjeta = new ArrayList();
        try {
            Connection cnx = BaseDeDatos.getConnection();
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM fr_tarjetas");
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
}
