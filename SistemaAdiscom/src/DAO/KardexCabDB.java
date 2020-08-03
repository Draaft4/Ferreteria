package DAO;

import ConexionBD.BaseDeDatos;
import Modelo.KardexCab;
import Modelo.KardexDet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class KardexCabDB {

    ArrayList<KardexDet> detalles;

    public ArrayList<KardexCab> ListKardexCab(ArrayList<KardexDet> detalles) {
        ArrayList<KardexCab> kardexcab = new ArrayList();
        ArrayList<KardexDet> kardex = new ArrayList();
        this.detalles = detalles;
        try {
            Connection cnx = BaseDeDatos.getConnection();
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM FR_KARDEX_CABECERA order by 1");
            while (rs.next()) {
                int codigo = rs.getInt("kar_id");
                int valorminimo = rs.getInt("KR_VALOR_MINIMO");
                String kardetalle = rs.getString("kar_det_detalle");

                for (KardexDet kardexDet : detalles) {
                    int cab = kardexDet.getCab();
                    if (cab == codigo) {
                        kardex.add(kardexDet);

                    }
                }
                KardexCab cl = new KardexCab(codigo, valorminimo, kardetalle, kardex);
                kardexcab.add(cl);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error en listado Kardex Cabecera");
        }
        return kardexcab;
    }

    public void insert(KardexCab kardex) {
        try {
            Connection cnx = BaseDeDatos.getConnection();
            //permite hacer transacciones eliminar insertar
            PreparedStatement pst = cnx.prepareStatement("INSERT INTO  "
                    + "FR_kardex_cabecera (kar_id,kr_valor_minimo,kr_valor_maximo,kar_det_detalle) "
                    + "VALUES( ?,?,?,?)");
            pst.setInt(1, kardex.getId());
            pst.setInt(2, kardex.getValMin());
            pst.setInt(3, 0);
            pst.setString(4, kardex.getDetalles());
            pst.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Ingresando Cabecera:\n" + ex.getMessage());
        }
    }

}
