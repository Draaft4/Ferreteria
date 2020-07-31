
package DAO;

import ConexionBD.BaseDeDatos;
import Modelo.MetodoPago;
import Modelo.TarjetaCredito;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class MetodoPagoDB {
     ArrayList<TarjetaCredito> listTarjeta;

    public MetodoPagoDB(ArrayList<TarjetaCredito> listTarjeta) {
        this.listTarjeta= listTarjeta;
    }
    
    public ArrayList<MetodoPago> ListMetodoPago(){
    ArrayList<MetodoPago> metodopago = new ArrayList();
    try{
        Connection cnx = BaseDeDatos.getConnection();
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM fr_metodos_pago");
        while (rs.next()){
            TarjetaCredito tar = null;
            int codigo= rs.getInt("met_id");
            String tipo= rs.getString("met_tipo");
            int tarid = rs.getInt("fr_tarjetas_tar_id");
            for (TarjetaCredito tarjeta : listTarjeta) {
                if(tarjeta.getCodigo() == tarid){
                    tar = tarjeta;
                }
            }
           MetodoPago cl =new MetodoPago(codigo, tipo, tar);
                   
           metodopago.add(cl);
        }
    }catch (SQLException ex){
        System.out.println(ex.getMessage());
        System.out.println("Error en listado");
    }
    return metodopago;
    }
    
    
}
