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
public class SizeDTO implements Serializable{
    private String id;
    private int sizes;
   
    public SizeDTO() {
    }

    public SizeDTO(String id, int sizes) {
        this.id = id;
        this.sizes = sizes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSizes() {
        return sizes;
    }

    public void setSizes(int sizes) {
        this.sizes = sizes;
    }
    
}