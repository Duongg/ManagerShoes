/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.shoesdao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import manager.shoes.ShoesSizeDTO;
import manager.shoesdto.SizeDTO;
import manager.utils.DBUtils;

/**
 *
 * @author DELL
 */
public class SizeDAO implements Serializable{
  
    public int getSize(ShoesSizeDTO dto) throws SQLException, NamingException{
        String sql = "Select sizes from dbo.tbl_sizes where id = ?";
        try (Connection con = DBUtils.makeConnection();
                PreparedStatement pstm = con.prepareStatement(sql)){
           pstm.setString(1, dto.getId());
            try (ResultSet rs = pstm.executeQuery()){
                while(rs.next()){
                    return rs.getInt("sizes");
                }
            }
            
        } 
        return -1;
    }
    public boolean deleteSizeID(String id){
        String sql = "DELETE FROM dbo.tbl_sizes WHERE id = ?";
        try (Connection con = DBUtils.makeConnection();
                PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setString(1, id);
            int row = pstm.executeUpdate();
            if(row > 0){
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
     public boolean updateSize(int size, String id) throws SQLException, NamingException{
         Connection con = null;
         PreparedStatement pstm =null;
         String sql ="UPDATE dbo.tbl_sizes SET sizes = ? WHERE id = ?";
         try {
             con = DBUtils.makeConnection();
             if(con != null){
                 pstm = con.prepareStatement(sql);
                 pstm.setString(1, id);
                 pstm.setInt(2, size);
                 int row = pstm.executeUpdate();
                 if(row > 0){
                 return true;
                 }
             }
         } finally {
             if(pstm != null){
                 pstm.close();
             }
             if(con != null){
                 con.close();
             }
         }
         return false;
     }
    
}
