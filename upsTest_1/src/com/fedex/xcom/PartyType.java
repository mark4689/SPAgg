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
public class PartyType {
    
    private String name;
    
    private AddressType address;
    
    public PartyType(){
        
    }
    
    public PartyType(String name, AddressType address){
        this.name = name;
        this.address = address;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the address
     */
    public AddressType getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(AddressType address) {
        this.address = address;
    }
}
