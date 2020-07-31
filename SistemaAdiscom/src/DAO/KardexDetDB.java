
package DAO;

import ConexionBD.BaseDeDatos;
import Modelo.KardexCab;
import Modelo.KardexDet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;


public class KardexDetDB {
    
     ArrayList<KardexCab> listKardexCab;

    public KardexDetDB(ArrayList<KardexCab> listKardexCab) {
        this.listKardexCab= listKardexCab;
    }
    
    public ArrayList<KardexDet> ListKardexDet(){
    ArrayList<KardexDet> kardexdet = new ArrayList();
    try{
        
        Connection cnx = BaseDeDatos.getConnection();
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM fr_kardex_detalle");
        while (rs.next()){
            KardexCab karcab = null;
            int codigo= rs.getInt("kar_det_id");
            Date karDetFecha= rs.getDate("kar_det_fecha");
            String karDetDetalle = rs.getString("kar_det_detale");
            double karDetValorUnit = rs.getDouble("kar_det_valor_unit");
            int karDetEnCantidad = rs.getInt("kar_det_entr_cantidad");
            double karDetEnValorTotal = rs.getDouble("kar_det_entr_total");
            int karDetSalCantidad = rs.getInt("kar_det_sal_cantidad");
            double karDetSalValorTotal = rs.getDouble("kar_det_sal_total");
            int karDetSaldoCantidad = rs.getInt("kar_det_saldo_cantidad");
            double karDetSaldoValorTotal = rs.getDouble("kar_det_saldo_total");

            int kardexCabid = rs.getInt("fr_kardex_cabecera_kar_id");
            for (KardexCab kardexCab : listKardexCab) {
                if(kardexCab.getId() == kardexCabid){
                    karcab = kardexCab;
                }
            }
           KardexDet cl =new KardexDet(codigo, karDetFecha, karDetDetalle, karDetValorUnit, codigo, karDetValorUnit, codigo, karDetEnValorTotal, codigo, karDetValorUnit);
                   
         kardexdet.add(cl);
        }
    }catch (SQLException ex){
        System.out.println(ex.getMessage());
        System.out.println("Error en listado");
    }
    return kardexdet;
    }
    
    
    
}
