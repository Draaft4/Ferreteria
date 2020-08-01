package DAO;

import ConexionBD.BaseDeDatos;
import Modelo.KardexCab;
import Modelo.KardexDet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class KardexCabDB {
    
     ArrayList<KardexDet> detalles;
    
 public ArrayList<KardexCab> ListKardexCab( ArrayList<KardexDet> detalles){
    ArrayList<KardexCab> kardexcab = new ArrayList();
    ArrayList<KardexDet> kardex = new ArrayList();
    this.detalles=detalles;
    try{
        Connection cnx = BaseDeDatos.getConnection();
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM FR_KARDEX_CABECERA");
        while (rs.next()){
            int codigo= rs.getInt("kar_id");
            int valorminimo = rs.getInt("KR_VALOR_MINIMO");
            String kardetalle= rs.getString("kar_det_detalle");
            
            for (KardexDet kardexDet : detalles) {
                if(kardexDet.getCab()==codigo)
                    kardex.add(kardexDet);
            }
                
           KardexCab cl= new KardexCab(codigo, valorminimo, kardetalle,kardex);
           kardexcab.add(cl);
        }
    }catch (SQLException ex){
        System.out.println(ex.getMessage());
        System.out.println("Error en listado Kardex Cabecera");
    }
    return kardexcab;
    }

}