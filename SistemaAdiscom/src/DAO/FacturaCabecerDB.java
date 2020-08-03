package DAO;

import ConexionBD.BaseDeDatos;
import Modelo.Cliente;
import Modelo.FacturaCab;
import Modelo.FacturaDet;
import Modelo.MetodoPago;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class FacturaCabecerDB {

    ArrayList<MetodoPago> listMetodoPago;
    ArrayList<Cliente> listCliente;
    ArrayList<FacturaDet> listDetalle;

    public FacturaCabecerDB(ArrayList<MetodoPago> listMetodoPago, ArrayList<Cliente> listCliente, ArrayList<FacturaDet> detalles) {
        this.listMetodoPago = listMetodoPago;
        this.listCliente = listCliente;
        this.listDetalle = detalles;
    }

    public ArrayList<FacturaCab> ListFacturasCab() {
        ArrayList<FacturaCab> facturaCab = new ArrayList();
        ArrayList<FacturaDet> detalles = new ArrayList();
        try {
            Connection cnx = BaseDeDatos.getConnection();
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM fr_factura_cabeceras order by 1");
            while (rs.next()) {
                MetodoPago met = null;
                Cliente cli = null;
                int id = rs.getInt("cab_id");
                String numero = rs.getString("cab_numero");
                Date fechaEmision = rs.getDate("cab_fecha_emision");
                double subtotal = rs.getDouble("cab_subtotal");
                double desc = rs.getDouble("cab_descuento");
                double iva = rs.getDouble("cab_iva");
                double total = rs.getDouble("cab_total");
                String anulado = rs.getString("cab_anulado");
                int cliId = rs.getInt("fr_clientes_cli_id");

                for (Cliente cliente : listCliente) {
                    if (cliente.getCodigo() == cliId) {
                        cli = cliente;
                    }
                }
                int metodo = rs.getInt("fr_metodos_pago_met_id");
                for (MetodoPago metodoPago : listMetodoPago) {
                    if (metodoPago.getCodigo() == metodo) {
                        met = metodoPago;
                    }
                }

                for (FacturaDet facturaDet : listDetalle) {
                    if (id == facturaDet.getCab()) {
                        detalles.add(facturaDet);
                    }
                }

                FacturaCab cl = new FacturaCab(id, numero, fechaEmision, subtotal, desc, iva, total, anulado, cli, met, detalles);
                facturaCab.add(cl);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error en listado Cabecera Fact");
        }
        return facturaCab;
    }

    public void insert(FacturaCab factCab) {
        try {
            Connection cnx = BaseDeDatos.getConnection();
            //permite hacer transacciones eliminar insertar
            PreparedStatement pst = cnx.prepareStatement("INSERT INTO  "
                    + "FR_factura_cabeceras (cab_id,cab_numero,cab_fecha_emision,cab_subtotal, cab_descuento, cab_iva, cab_total, cab_anulado, fr_clientes_cli_id, fr_metodos_pago_met_id) "
                    + "VALUES( ?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, factCab.getId());
            pst.setString(2, factCab.getNumero());
            pst.setDate(3, new java.sql.Date(factCab.getFechaEmision().getTime()));
            pst.setDouble(4, factCab.getSubtotal());
            pst.setDouble(5, factCab.getDesc());
            pst.setDouble(6, factCab.getIVA());
            pst.setDouble(7, factCab.getTotal());
            pst.setString(8, factCab.getAnulado());
            pst.setInt(9, factCab.getCliente().getCodigo());
            pst.setInt(10, factCab.getMetodoPago().getCodigo());
            pst.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Ingresando Cabecera:\n" + ex.getMessage());
        }
    }

}
