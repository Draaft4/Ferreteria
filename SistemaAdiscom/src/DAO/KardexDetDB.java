package DAO;

import ConexionBD.BaseDeDatos;
import Modelo.KardexCab;
import Modelo.KardexDet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class KardexDetDB {

    public ArrayList<KardexDet> ListKardexDet() {
        ArrayList<KardexDet> kardexdet = new ArrayList();
        try {

            Connection cnx = BaseDeDatos.getConnection();
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM fr_kardex_detalle");
            while (rs.next()) {
                int codigo = rs.getInt("kar_det_id");
                Date karDetFecha = rs.getDate("kar_det_fecha");
                String karDetDetalle = rs.getString("kar_det_detalle");
                double karDetValorUnit = rs.getDouble("KAR_DET_ENTR_VALOR_UNIT");
                int karDetEnCantidad = rs.getInt("kar_det_entr_cantidad");
                double karDetEnValorTotal = rs.getDouble("kar_det_entr_total");
                int karDetSalCantidad = rs.getInt("kar_det_sal_cantidad");
                double karDetSalValorTotal = rs.getDouble("kar_det_sal_total");
                int karDetSaldoCantidad = rs.getInt("kar_det_saldo_cantidad");
                double karDetSaldoValorTotal = rs.getDouble("kar_det_saldo_total");
                int kardexCabid = rs.getInt("fr_kardex_cabecera_kar_id");
                KardexDet cl = new KardexDet(codigo, karDetFecha, karDetDetalle, karDetValorUnit, codigo, karDetValorUnit, codigo, karDetEnValorTotal, codigo, karDetSaldoValorTotal, kardexCabid);

                kardexdet.add(cl);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error en listado Kardex Detalle");
        }
        return kardexdet;
    }

    public void insert(KardexDet kardex) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Connection cnx = BaseDeDatos.getConnection();
            //permite hacer transacciones eliminar insertar
            PreparedStatement pst = cnx.prepareStatement("INSERT INTO  "
                    + "FR_kardex_detalle ("
                    + "    kar_det_id,"
                    + "    fr_kardex_cabecera_kar_id,"
                    + "    KAR_DET_FECHA,"
                    + "    kar_det_detalle,"
                    + "    kar_det_entr_cantidad,"
                    + "    kar_det_entr_valor_unit,"
                    + "    kar_det_entr_total,"
                    + "    kar_det_sal_cantidad,"
                    +      "kar_det_sal_valor_unit,"
                    + "    kar_det_sal_total,"
                    + "    kar_det_saldo_cantidad,"
                    + "    kar_det_saldo_valor_unit,"
                    + "    kar_det_saldo_total"
                    + "    ) "
                    + "VALUES( ?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, kardex.getId());
            pst.setInt(2, kardex.getCab());
            pst.setDate(3, new java.sql.Date(kardex.getFechaEdit().getTime()));
            pst.setString(4, kardex.getDetalle());
            pst.setInt(5, kardex.getCantEntr());
            pst.setDouble(6, kardex.getValUnit());
            pst.setDouble(7, kardex.getValTotlEnt());
            pst.setInt(8, kardex.getCantSal());
            pst.setDouble(9, kardex.getValUnit());
            pst.setDouble(10, kardex.getValTotlSal());
            pst.setInt(11, kardex.getCantSaldo() );
            pst.setDouble(12, kardex.getValUnit() );
            pst.setDouble(13, kardex.getSaldo() );
            pst.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error Ingresando Detalle:\n"+  ex.getMessage());
        }
    }

}
