/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com;

import com.ups.uCom;
import com.UniversalTypes.*;

/**
 *
 * @author brendanburbules
 */
public class theServe {
   public static void main(String[] args){

       uCom client = new uCom();
       PartyType a = new PartyType();
       AddressType aa = new AddressType("this street","Erie","PA","16509");
       a.setName("Silly Goat");
       a.setAddress(aa);
       
       PartyType b = new PartyType();
       AddressType ba = new AddressType("that street","Atlanta","GA","30303");
       a.setName("Farting Goat");
       b.setAddress(ba);
       
       PackageType p = new PackageType("2","2","1","5");
       
       
       
       
       String temp = client.process(a,b,p);
       System.out.print(temp);
   }
}
