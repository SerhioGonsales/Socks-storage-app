package com.lukushin.socks.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Socks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String colour;
    private int cotton;
    private int quantity;

    public Socks() {
    }

    public Socks(int id, String colour, int cotton, int quantity) {
        this.id = id;
        this.colour = colour;
        this.cotton = cotton;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getCotton() {
        return cotton;
    }

    public void setCotton(int cotton) {
        this.cotton = cotton;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Socks{" +
                "id=" + id +
                ", colour='" + colour + '\'' +
                ", cotton=" + cotton +
                ", quantity=" + quantity +
                '}';
    }

    public boolean getValid(){
        boolean valid = false;
        if(this.getColour()!=null
                && this.getCotton() >= 0
                && this.getCotton() < 100
                && this.getQuantity() > 0){
            valid = true;
        }
        return valid;
    }

}
