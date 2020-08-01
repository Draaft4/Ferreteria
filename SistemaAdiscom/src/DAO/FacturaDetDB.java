package DAO;

import ConexionBD.BaseDeDatos;
import Modelo.FacturaCab;
import Modelo.FacturaDet;
import Modelo.Producto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
            ResultSet rs = st.executeQuery("SELECT * FROM fr_factura_detalles");
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
}
