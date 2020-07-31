
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
     ArrayList<FacturaCab> listFacturaCab;

    public FacturaDetDB(ArrayList<FacturaCab> listFacturaCab, ArrayList<Producto> listProducto) {
        this.listFacturaCab = listFacturaCab;
        this.listProducto=listProducto;
    }
    
    
    
    public ArrayList<FacturaDet> ListFacturaDet(){
    ArrayList<FacturaDet> facturaDet = new ArrayList();
    try{
        Connection cnx = BaseDeDatos.getConnection();
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM fr_factura_detalles");
        while (rs.next()){
            Producto met=null;
            FacturaCab cab = null;
            int id= rs.getInt("det_id");
            int cant= rs.getInt("det_cantidad");
            double precio= rs.getDouble("det_precio");
            double desc = rs.getDouble("det_descuento");
            double subtotal = rs.getDouble("det_subtotal");
            boolean devuelto= rs.getBoolean("det_devuelto");
           
            int productoId= rs.getInt("fr_productos_pro_id");
            for(Producto producto:listProducto ){
                if(producto.getCodigo() == productoId){
                    met = producto;
                }
            }
            
            int factCabId= rs.getInt("fr_factura_cabeceras_cab_id");
            for (FacturaCab facturaCabecera : listFacturaCab) {
                if(facturaCabecera.getId() == factCabId){
                    cab = facturaCabecera;
                }
            }
            
            FacturaDet cl= new FacturaDet(  id,  cant,  precio,  desc,  subtotal,  devuelto, met,  cab );
           facturaDet.add(cl);
        }
    }catch (SQLException ex){
        System.out.println(ex.getMessage());
        System.out.println("Error en listado");
    }
    return facturaDet;
    }
}
