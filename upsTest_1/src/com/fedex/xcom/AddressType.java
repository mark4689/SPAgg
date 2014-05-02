/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fedex.xcom;

/**
 *
 * @author Aaron
 */
public class AddressType {
    private String streetLine, city, state, zip;
    public AddressType(){
        
    }
    
    public AddressType(String streetLine, String city, 
            String state, String zip){
        
        this.streetLine = streetLine;
        this.city = city;
        this.state = state;
        this.zip = zip;
        
    }

    /**
     * @return the streetLine
     */
    public String getStreetLine() {
        return streetLine;
    }

    /**
     * @param streetLine the streetLine to set
     */
    public void setStreetLine(String streetLine) {
        this.streetLine = streetLine;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * @param zip the zip to set
     */
    public void setZip(String zip) {
        this.zip = zip;
    }
}
