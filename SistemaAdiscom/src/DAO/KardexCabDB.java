package DAO;

import ConexionBD.BaseDeDatos;
import Modelo.KardexCab;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class KardexCabDB {
 public ArrayList<KardexCab> ListKardexCab(){
    ArrayList<KardexCab> kardexcab = new ArrayList();
    try{
        Connection cnx = BaseDeDatos.getConnection();
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM FR_KARDEX_CABECERA");
        while (rs.next()){
            int codigo= rs.getInt("kar_id");
            int valorminimo = rs.getInt("kar_valor_minimo");
            String kardetalle= rs.getString("kar_det_detalle");
           KardexCab cl= new KardexCab(codigo, valorminimo, kardetalle);
           kardexcab.add(cl);
        }
    }catch (SQLException ex){
        System.out.println(ex.getMessage());
        System.out.println("Error en listado");
    }
    return kardexcab;
    }

}