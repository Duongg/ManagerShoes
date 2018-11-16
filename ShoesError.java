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
public class ShoesError implements Serializable{
    private String shoesID;
    private String descriptionErr;
    private String priceErr;
    private String quantityErr;
    private String sizesErr;

    public ShoesError() {
    }

    public ShoesError(String shoesID, String descriptionErr, String priceErr, String quantityErr, String sizesErr) {
        this.shoesID = shoesID;
        this.descriptionErr = descriptionErr;
        this.priceErr = priceErr;
        this.quantityErr = quantityErr;
        this.sizesErr = sizesErr;
    }

    public String getShoesID() {
        return shoesID;
    }

    public void setShoesID(String shoesID) {
        this.shoesID = shoesID;
    }

   

    public String getDescriptionErr() {
        return descriptionErr;
    }

    public void setDescriptionErr(String descriptionErr) {
        this.descriptionErr = descriptionErr;
    }

    public String getPriceErr() {
        return priceErr;
    }

    public void setPriceErr(String priceErr) {
        this.priceErr = priceErr;
    }

    public String getQuantityErr() {
        return quantityErr;
    }

    public void setQuantityErr(String quantityErr) {
        this.quantityErr = quantityErr;
    }

    public String getSizesErr() {
        return sizesErr;
    }

    public void setSizesErr(String sizesErr) {
        this.sizesErr = sizesErr;
    }

  
    
    
}
