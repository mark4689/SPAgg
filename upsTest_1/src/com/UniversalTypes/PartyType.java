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
    private NameType name;
    
    public PartyType(){
        
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
    public NameType getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(NameType name) {
        this.name = name;
    }
    
    
}
