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
    
//     public void insert(TarjetaCredito tarjetaCredito) {
//        try {
//            Connection cnx = BaseDeDatos.getConnection();
//            //permite hacer transacciones eliminar insertar
//            PreparedStatement pst = cnx.prepareStatement("INSERT INTO  "
//                    + "FR_Productos (  pro_id,pro_nombre ,pro_descripcion,pro_precio_unitario,"
//                    + "pro_stock,pro_procedencia,fr_categorias_cat_id, fr_kardex_cabecera_kar_id) "
//                    + "VALUES(  FR_productos_SEQ.nextval, ?, ?, ? ,?,?,?,?)");
//            pst.setString(1, producto.getNombre());
//            pst.setString(2, producto.getDesc());
//            pst.setDouble(3, producto.getPrecio());
//            pst.setInt(4, producto.getStock());
//            pst.setString(5, producto.getProcedencia());
//            pst.setInt(6, producto.getCat().getCodigo());
//            pst.setInt(7, producto.getIdKardexCab());
//            pst.executeUpdate();
//
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage());
//        }
//    }

}
