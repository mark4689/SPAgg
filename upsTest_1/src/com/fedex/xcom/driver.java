/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fedex.xcom;

import com.fedex.XCOM;
import com.UniversalTypes.*;


/**
 *
 * @author Aaron
 */
public class driver {
    
    public static void main(String [] args){
        XCOM X = new XCOM();
        UniversalResponseType uni = new UniversalResponseType();
        
        AddressType a = new AddressType("1234 Poop","Erref","PA","16503");
        PartyType p = new PartyType();
        p.setName("Ftancod");
        p.setAddress(a);
        
        AddressType b = new AddressType("1234 Poop","Erref","PA","16503");
        PartyType s = new PartyType();
        s.setName("Ftancod");
        s.setAddress(b);
        
        PackageType k = new PackageType("15","1","1","1");
        
        uni = X.process(p, s, k);
        for(int i = 0; i < uni.getResponseList().size();i++){
            System.out.println(uni.getResponseList().get(i).getDeliveryType());
            System.out.println(uni.getResponseList().get(i).getPrice());
        }
        
    }
}
