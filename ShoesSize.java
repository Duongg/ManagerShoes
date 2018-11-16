/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.shoes;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import manager.shoesdao.ShoesDAO;
import manager.shoesdao.SizeDAO;

/**
 *
 * @author DELL
 */
public class ShoesSize implements Serializable {

    private List<ShoesSizeDTO> listShoes;
    private List<ProductShoeSize> listProduct = new ArrayList<>();
    
  

    public List<ProductShoeSize> getShoesSizeList() throws SQLException, NamingException {
        ShoesSizeDAO dao = new ShoesSizeDAO();
      
        dao.getShoesSize();
         
        for (ShoesSizeDTO shoesdto : dao.getListShoes()) {
             
            SizeDAO sizedao = new SizeDAO();
            ShoesDAO shoesdao = new ShoesDAO();
            String description = shoesdao.getDescription(shoesdto);          
            int size = sizedao.getSize(shoesdto);           
            ProductShoeSize product = new ProductShoeSize(shoesdto, description, size);         
            listProduct.add(product);
        }
  
        return listProduct;
    }

}
