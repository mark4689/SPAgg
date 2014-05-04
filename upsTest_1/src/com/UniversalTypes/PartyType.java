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
public class PartyType {
    private AddressType address;
    //private NameType name;
    private String name;
    public PartyType(){
        
    }
    
    public PartyType(AddressType address, String name){
        this.address = address;
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

    /**
     * @return the name
     */
    public String getName(){
        return name;
   }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    
}
