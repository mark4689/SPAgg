/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UniversalTypes;

import java.util.ArrayList;

/**
 *
 * @author mak5278
 */
public class UniversalResponse {
    private ArrayList<SingleResponse> responseList;

    /**
     * @return the responseList
     */
    public ArrayList<SingleResponse> getResponseList() {
        return responseList;
    }

    /**
     * @param responseList the responseList to set
     */
    public void setResponseList(ArrayList<SingleResponse> responseList) {
        this.responseList = responseList;
    }
    
}
