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
public class ProductShoeSize implements Serializable{
    private ShoesSizeDTO shoes;
    private String description;
    private int sizes;

    public ProductShoeSize() {
    }

    public ProductShoeSize(ShoesSizeDTO shoes, String description, int sizes) {
        this.shoes = shoes;
        this.description = description;
        this.sizes = sizes;
    }

    public ShoesSizeDTO getShoes() {
        return shoes;
    }

    public void setShoes(ShoesSizeDTO shoes) {
        this.shoes = shoes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSizes() {
        return sizes;
    }

    public void setSizes(int sizes) {
        this.sizes = sizes;
    }
    
}
