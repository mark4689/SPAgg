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
public class SingleResponse {
    private DeliveryType deliveryType;
    private String price;
    private String deliveryDate;

    
    public enum DeliveryType{NEXT_DAY, SECOND_DAY, GROUND};

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

    /**
     * @return the deliveryDate
     */
    public String getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * @param deliveryDate the deliveryDate to set
     */
    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
    
}
