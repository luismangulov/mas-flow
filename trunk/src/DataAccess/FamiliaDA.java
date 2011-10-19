/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BD.conexion;
import BusinessEntity.FamiliaBE;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DIEGO
 */
public class FamiliaDA {
    
    public String insertar(FamiliaBE objFamilia) throws SQLException{
        conexion cnn = new conexion();
        cnn.estableceCnn();
        PreparedStatement pstmt = null;
       
        String sql = "INSERT INTO Familia(idfamilia,nombre, descripcion, indactivo) VALUES('"+ objFamilia.getCodigo() +"','"+ objFamilia.getNombre() +"','"+ objFamilia.getDescripcion() +"','"+ objFamilia.getEstado() +"');";
        pstmt = cnn.cnn.prepareStatement(sql);
        try{
            pstmt.executeUpdate(); 
         }catch (SQLException e) {			
			e.printStackTrace();
		} finally{
			//6. Se cierran todos los objetos de conexion. ES EL MAS IMPORTANTE
			if (pstmt !=null) {try{pstmt.close();}catch(Exception e){e.printStackTrace();}}
			if (cnn.cnn !=null) {try{cnn.cnn.close();}catch(Exception e){e.printStackTrace();}}
		}
        
        
        return null;
    }
    
    public ArrayList<FamiliaBE> queryAllFamilia(){
        conexion cnn = new conexion();
        cnn.estableceCnn();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<FamiliaBE> arrFamilia = new ArrayList<FamiliaBE>();
        try{
             pstmt = cnn.cnn.prepareStatement("SELECT * FROM Familia WHERE IndActivo = 1");
             String strCodigo;
             String strNombre;
             String strDescripcion;
             String strEstado;
             while (rs.next()) {
                strCodigo = rs.getString(1);
                strNombre = rs.getString(2);
                strDescripcion = rs.getString(3);
                strEstado = rs.getString(4);
                arrFamilia.add(new FamiliaBE(strCodigo,strNombre,strDescripcion,strEstado));
            }
             
        }catch (SQLException e) {			
			e.printStackTrace();
		} finally{
			//6. Se cierran todos los objetos de conexion. ES EL MAS IMPORTANTE
			if (pstmt !=null) {try{pstmt.close();}catch(Exception e){e.printStackTrace();}}
			if (cnn.cnn !=null) {try{cnn.cnn.close();}catch(Exception e){e.printStackTrace();}}
			if (rs !=null) {try{rs.close();}catch(Exception e){e.printStackTrace();}}
		}
      
        
        return arrFamilia;
    }
}
