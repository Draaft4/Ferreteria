
package DAO;

import ConexionBD.BaseDeDatos;
import Modelo.Cliente;
import Modelo.FacturaCab;
import Modelo.MetodoPago;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;


public class FacturaCabecerDB {
     
     ArrayList<MetodoPago> listMetodoPago;
     ArrayList<Cliente> listCliente;

    public FacturaCabecerDB(ArrayList<MetodoPago> listMetodoPago, ArrayList<Cliente> listCliente) {
        this.listMetodoPago = listMetodoPago;
        this.listCliente=listCliente;
    }
    
    
    
    public ArrayList<FacturaCab> ListFacturasCab(){
    ArrayList<FacturaCab> facturaCab = new ArrayList();
    try{
        Connection cnx = BaseDeDatos.getConnection();
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM fr_factura_cabeceras");
        while (rs.next()){
            MetodoPago met=null;
            Cliente cli = null;
            int id= rs.getInt("cab_id");
            String numero= rs.getString("cab_numero");
            Date fechaEmision= rs.getDate("cab_fecha_emision");
            double subtotal= rs.getDouble("cab_subtotal");
            double desc = rs.getDouble("cab_descuento");
            double iva= rs.getDouble("cab_iva");
            double total= rs.getDouble("cab_anulado");
            String anulado= rs.getString("cab_anulado");
            int cliId= rs.getInt("fr_clientes_cli_id");
            for(Cliente cliente:listCliente ){
                if(cliente.getCodigo() == cliId){
                    cli = cliente;
                }
            }
            
            int metodo= rs.getInt("fr_metodos_pago_met_id");
            for (MetodoPago metodoPago : listMetodoPago) {
                if(metodoPago.getCodigo() == metodo){
                    met = metodoPago;
                }
            }
            
            FacturaCab cl= new FacturaCab( id, numero, fechaEmision,  subtotal, desc,  iva,  total, anulado, cli, met );
           facturaCab.add(cl);
        }
    }catch (SQLException ex){
        System.out.println(ex.getMessage());
        System.out.println("Error en listado");
    }
    return facturaCab;
    }

}