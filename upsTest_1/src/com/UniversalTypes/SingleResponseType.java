/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.UniversalTypes;

/**
 *
 * @author mak5278
 */
public class SingleResponseType {
    private DeliveryType deliveryType;
    private String price;

    
    public enum DeliveryType{NEXT_DAY, SECOND_DAY, GROUND};
    
    public SingleResponseType(){
        
    }
    
    public SingleResponseType(DeliveryType deliveryType, String price, String deliveryDate){
        this.deliveryType = deliveryType;
        this.price = price;
        //this.deliveryDate = deliveryDate;
    }
    

    /**
     * @param deliveryType the deliveryType to set
     */
    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }
    
    /**
     * @return the deliveryType
     */
    public DeliveryType getDeliveryType(){
        return deliveryType;
    }

    /**
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(String price) {
        this.price = price;
    }
}
