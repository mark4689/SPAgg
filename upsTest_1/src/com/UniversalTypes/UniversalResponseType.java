/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.UniversalTypes;

import java.util.ArrayList;

/**
 *
 * @author mak5278
 */
<<<<<<< HEAD:upsTest_1/src/UniversalTypes/UniversalResponse.java
public class UniversalResponse {
    private ArrayList<SingleResponse> responseList;

    public UniversalResponse(){
        responseList = new ArrayList();
    }
=======
public class UniversalResponseType {
    private ArrayList<SingleResponseType> responseList;
>>>>>>> noFedex:upsTest_1/src/com/UniversalTypes/UniversalResponseType.java
    /**
     * @return the responseList
     */
    public ArrayList<SingleResponseType> getResponseList() {
        return responseList;
    }

    /**
     * @param responseList the responseList to set
     */
    public void setResponseList(ArrayList<SingleResponseType> responseList) {
        this.responseList = responseList;
    }
    
}
