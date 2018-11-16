/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.shoesdto;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class ShoesDTO implements Serializable{
    private String shoesID;
    private String description;


    public ShoesDTO() {
    }

    public ShoesDTO(String shoesID, String description) {
        this.shoesID = shoesID;
        this.description = description;
    }

    public String getShoesID() {
        return shoesID;
    }

    public void setShoesID(String shoesID) {
        this.shoesID = shoesID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   
    
}
