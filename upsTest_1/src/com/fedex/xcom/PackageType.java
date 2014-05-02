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
public class PackageType {
    
    private String packageWeight;
    
    private String packageL;
    
    private String packageW;
    
    private String packageH;
    
    public PackageType(){
        
    }
    
    public PackageType(String packageWeight, String packageL, 
            String packageW, String packageH){
        this.packageWeight = packageWeight;
        this.packageL = packageL;
        this.packageW = packageW;
        this.packageH = packageH;
    }

    /**
     * @return the packageWeight
     */
    public String getPackageWeight() {
        return packageWeight;
    }

    /**
     * @param packageWeight the packageWeight to set
     */
    public void setPackageWeight(String packageWeight) {
        this.packageWeight = packageWeight;
    }

    /**
     * @return the packageL
     */
    public String getPackageL() {
        return packageL;
    }

    /**
     * @param packageL the packageL to set
     */
    public void setPackageL(String packageL) {
        this.packageL = packageL;
    }

    /**
     * @return the packageW
     */
    public String getPackageW() {
        return packageW;
    }

    /**
     * @param packageW the packageW to set
     */
    public void setPackageW(String packageW) {
        this.packageW = packageW;
    }

    /**
     * @return the packageH
     */
    public String getPackageH() {
        return packageH;
    }

    /**
     * @param packageH the packageH to set
     */
    public void setPackageH(String packageH) {
        this.packageH = packageH;
    }
    
    
}
