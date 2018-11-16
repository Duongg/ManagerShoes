/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.shoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import manager.utils.DBUtils;

/**
 *
 * @author DELL
 */
public class ShoesSizeDAO {
    private List<ShoesSizeDTO> listShoes = new ArrayList<>();

    public List<ShoesSizeDTO> getListShoes() {
        return listShoes;
    }

    public void getShoesSize() throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM dbo.tbl_shoessize";
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);
                rs = pstm.executeQuery();
                while (rs.next()) {
                   
                    String shoesID = rs.getString("shoesID");
                    String id = rs.getString("id");
                    int quantity = rs.getInt("quantity");
                    float price = rs.getFloat("price");
                    String country = rs.getString("country");
             
                    ShoesSizeDTO dto = new ShoesSizeDTO(shoesID, id, quantity, price, country);            
                    listShoes.add(dto);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
   public int checkShoes(String shoesID){
       Connection con = null;
       PreparedStatement pstm = null;
       ResultSet rs=null;
       int count = 0;
       String sql = "SELECT * FROM dbo.tbl_shoessize WHERE shoesID = ?";
       try {
           con = DBUtils.makeConnection();
           if(con != null){
               pstm = con.prepareStatement(sql);
               pstm.setString(1, shoesID);
               rs = pstm.executeQuery();
               while(rs.next()){
                   count ++;
               }
           }
       } catch (Exception e) {
       }
       return count;
   }
    public boolean deleteShoes(String shoesID, String id) throws SQLException, NamingException{
        String sql ="DELETE FROM dbo.tbl_shoessize WHERE shoesID = ? AND id =?";
        try (Connection con = DBUtils.makeConnection();
                PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setString(1, shoesID);
            pstm.setString(2, id);
            return pstm.executeUpdate() >0;
           
        } 
        
    }
    public boolean UpdateShoes(ShoesSizeDTO dto) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement pstm = null;
        String sql ="UPDATE dbo.tbl_shoessize SET quantity = ?, price = ? WHERE shoesID = ? AND id = ?";
       
        try {
            con = DBUtils.makeConnection();
            if(con != null){
                pstm = con.prepareStatement(sql);
                pstm.setInt(1, dto.getQuantity());
                pstm.setFloat(2, dto.getPrice());
                pstm.setString(3, dto.getShoesID());
                pstm.setString(4, dto.getId());
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
    public boolean insertShoes(ShoesSizeDTO newshoes) throws SQLException, NamingException{
        String sql = "INSERT INTO dbo.tbl_shoessize(shoesID,id,quantity,price,country) values(?,?,?,?,?)";
             Connection con = null;
        PreparedStatement pstm = null;
          try {
            con = DBUtils.makeConnection();
            if(con != null){
                pstm = con.prepareStatement(sql);
                pstm.setString(1, newshoes.getShoesID());
                pstm.setString(2, newshoes.getId());
                pstm.setInt(3, newshoes.getQuantity());
                pstm.setFloat(4, newshoes.getPrice());
                pstm.setString(5, newshoes.getCountry());
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
