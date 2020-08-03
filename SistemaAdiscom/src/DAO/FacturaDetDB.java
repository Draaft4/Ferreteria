package DAO;

import ConexionBD.BaseDeDatos;
import Modelo.FacturaCab;
import Modelo.FacturaDet;
import Modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FacturaDetDB {

    ArrayList<Producto> listProducto;

    public FacturaDetDB(ArrayList<Producto> listProducto) {
        this.listProducto = listProducto;
    }

    public ArrayList<FacturaDet> ListFacturaDet() {
        ArrayList<FacturaDet> facturaDet = new ArrayList();
        try {
            Connection cnx = BaseDeDatos.getConnection();
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM fr_factura_detalles order by 1");
            while (rs.next()) {
                Producto met = null;
                int id = rs.getInt("det_id");
                int cant = rs.getInt("det_cantidad");
                double precio = rs.getDouble("det_precio");
                double desc = rs.getDouble("det_descuento");
                double subtotal = rs.getDouble("det_subtotal");
                boolean devuelto = rs.getBoolean("det_devuelto");
                int cab = rs.getInt("FR_FACTURA_CABECERAS_CAB_ID");
                int productoId = rs.getInt("fr_productos_pro_id");
                for (Producto producto : listProducto) {
                    if (producto.getCodigo() == productoId) {
                        met = producto;
                    }
                }

                FacturaDet cl = new FacturaDet(id, cant, precio, desc, subtotal, devuelto, met, cab);
                facturaDet.add(cl);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error en listado Factura Detalle");
        }
        return facturaDet;
    }

    public void insert(FacturaDet det) {
        try {
            Connection cnx = BaseDeDatos.getConnection();
            // permite hacer transacciones eliminar insertar
            PreparedStatement pst = cnx.prepareStatement("INSERT INTO  "
                    + "FR_Factura_Detalles ("
                    + "det_id,"
                    + "det_cantidad,"
                    + "det_precio,"
                    + "det_descuento,"
                    + "det_subtotal,"
                    + "det_devuelto,"
                    + "fr_productos_pro_id,"
                    + "fr_factura_cabeceras_cab_id"
                    + ") "
                    + "VALUES(?,?,?,?,?,?,?,?)");
            pst.setInt(1, det.getId());
            pst.setInt(2, det.getCant());
            pst.setDouble(3, det.getPrecio());
            pst.setDouble(4, det.getDesc());
            pst.setDouble(5, det.getSubtotal());
            if (det.isDevuelto()) {
                pst.setString(6, "D");
            } else {
                pst.setString(6, "");
            }
            pst.setDouble(7, det.getProducto().getCodigo());
            pst.setDouble(8, det.getCab());

            pst.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Ingresando Detalle: \n" + ex.getMessage());
        }
    }
}
