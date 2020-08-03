package DAO;

import ConexionBD.BaseDeDatos;
import Modelo.MetodoPago;
import Modelo.TarjetaCredito;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MetodoPagoDB {

    ArrayList<TarjetaCredito> listTarjeta;

    public MetodoPagoDB(ArrayList<TarjetaCredito> listTarjeta) {
        this.listTarjeta = listTarjeta;
    }

    public ArrayList<MetodoPago> ListMetodoPago() {
        ArrayList<MetodoPago> metodopago = new ArrayList();
        try {
            Connection cnx = BaseDeDatos.getConnection();
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM fr_metodos_pago order by 1");
            while (rs.next()) {
                TarjetaCredito tar = null;
                int codigo = rs.getInt("met_id");
                String tipo = rs.getString("met_tipo");
                int tarid = rs.getInt("fr_tarjetas_tar_id");
                for (TarjetaCredito tarjeta : listTarjeta) {
                    if (tarjeta.getCodigo() == tarid) {
                        tar = tarjeta;
                    } else {

                    }
                }
                MetodoPago cl = new MetodoPago(codigo, tipo, tar);

                metodopago.add(cl);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error en listado");
        }

        return metodopago;
    }

    public void insert(MetodoPago metodo) {
        try {
            Connection cnx = BaseDeDatos.getConnection();
            // permite hacer transacciones eliminar insertar
            PreparedStatement pst = cnx.prepareStatement("INSERT INTO  "
                    + "FR_METODOS_PAGO (  met_id,met_tipo ,fr_tarjetas_tar_id) "
                    + "VALUES(  ?, ? ,?)");
            pst.setInt(1, metodo.getCodigo());
            pst.setString(2, metodo.getTipoMetodo());
            if (metodo.getTarjeta() != null) {
                pst.setInt(3, metodo.getTarjeta().getCodigo());
            } else {
                pst.setString(3, "0");
            }
            pst.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

}
