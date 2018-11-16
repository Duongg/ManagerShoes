/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.shoes;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class ShoesSizeDTO implements Serializable{
    private String shoesID;
    private String id;
    private int quantity;
    private float price;
    private String country;

    public ShoesSizeDTO() {
    }

    public ShoesSizeDTO(String shoesID, String id, int quantity, float price) {
        this.shoesID = shoesID;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }

    public ShoesSizeDTO(String shoesID, String id, int quantity, float price, String country) {
        this.shoesID = shoesID;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.country = country;
    }

    

    public String getShoesID() {
        return shoesID;
    }

    public void setShoesID(String shoesID) {
        this.shoesID = shoesID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
}
