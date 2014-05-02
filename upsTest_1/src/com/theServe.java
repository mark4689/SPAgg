/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com;

import com.ups.uCom;

/**
 *
 * @author brendanburbules
 */
public class theServe {
   public static void main(String[] args){

       uCom client = new uCom();
       String temp = client.process();
       System.out.print(temp);
   }
}
