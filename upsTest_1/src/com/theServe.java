/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com;

import com.ups.uCom;
import com.fedex.XCOM;
import com.UniversalTypes.*;

/**
 *
 * @author brendanburbules
 */
public class theServe {
   public static void main(String[] args){

       uCom U = new uCom();
       XCOM X = new XCOM();
       UniversalResponseType uni = new UniversalResponseType();
       UniversalResponseType uni2 = new UniversalResponseType();
       
       PartyType a = new PartyType();
       AddressType aa = new AddressType("this street","Erie","PA","16509");
       a.setName("Silly Goat");
       a.setAddress(aa);
       
       PartyType b = new PartyType();
       AddressType ba = new AddressType("that street","Atlanta","GA","30303");
       a.setName("Farting Goat");
       b.setAddress(ba);
       
       PackageType p = new PackageType("2","2","1","5");
       
        
        uni = X.process(a, b, p);
        for(int i = 0; i < uni.getResponseList().size();i++){
            System.out.println("F"+uni.getResponseList().get(i).getDeliveryType());
            System.out.println("F"+uni.getResponseList().get(i).getPrice());
        }
        
        uni2 = U.process(a,b,p);
        for(int i = 0; i < uni2.getResponseList().size();i++){
            System.out.println("U"+uni2.getResponseList().get(i).getDeliveryType());
            System.out.println("U"+uni2.getResponseList().get(i).getPrice());
        }
    
       
 
   }
}
