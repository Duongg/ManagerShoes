/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.shoesdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import manager.shoes.ShoesSizeDTO;
import manager.shoesdto.ShoesDTO;
import manager.utils.DBUtils;

/**
 *
 * @author DELL
 */
public class ShoesDAO {

    public boolean checkLogin(String username, String password) throws SQLException, NamingException {
        String sql = "SELECT * FROM dbo.tbl_account WHERE username = ? AND password = ?";
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);
                pstm.setString(1, username);
                pstm.setString(2, password);
                rs = pstm.executeQuery();
                if (rs.next()) {
                    return true;
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
        return false;
    }
    


    public String getDescription(ShoesSizeDTO shoes) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "SELECT description FROM dbo.tbl_shoes WHERE shoesID = ?";
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);
                pstm.setString(1, shoes.getShoesID());
                rs = pstm.executeQuery();
                if( rs.next()) {               
                    return rs.getString("description");
                    

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
        return null;
    }
    public boolean deleteShoeID(String shoesID) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement pstm = null;
    
        String sql = "DELETE FROM dbo.tbl_shoes WHERE shoesID = ?";
        try {
            con = DBUtils.makeConnection();
            if(con != null){
                pstm = con.prepareStatement(sql);
                pstm.setString(1, shoesID);
                int row = pstm.executeUpdate();
                if(row > 0){
                    return true;
                }
            }
        } finally {
            if(pstm !=null){
                pstm.close();
            }
            if(con != null){
                con.close();
            }
        }
        return false;
    }
    public boolean updateDescription(String shoesID,String description) throws NamingException, SQLException{
        Connection con = null;
        PreparedStatement pstm = null;
        String sql ="UPDATE dbo.tbl_shoes SET description = ? WHERE shoesID = ?";
        try {
            con = DBUtils.makeConnection();
            if(con != null){
                pstm = con.prepareStatement(sql);
                pstm.setString(1,shoesID);
                pstm.setString(2, description);
                int row = pstm.executeUpdate();
                if(row > 0){
                    return true;
                }
            }
        } finally{
            if(pstm != null){
                pstm.close();
            }
            if(con != null){
                con.close();
            }
        }
        return false;
    }
    public boolean insertShoes(String shoesID, String description) throws NamingException, SQLException{
    Connection con = null;
        PreparedStatement pstm = null;
        String sql ="INSERT INTO dbo.tbl_shoes" +
"		          ( shoesID, description )" +
"		  VALUES  (?,?)";
        try {
            con = DBUtils.makeConnection();
            if(con != null){
                pstm = con.prepareStatement(sql);
                pstm.setString(1,shoesID);
                pstm.setString(2, description);
                int row = pstm.executeUpdate();
                if(row > 0){
                    return true;
                }
            }
        } finally{
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
