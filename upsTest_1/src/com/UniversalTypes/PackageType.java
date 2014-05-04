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
public class PackageType {
    private String weight;
    private String length;
    private String width;
    private String height;
    
    public PackageType(){
        
    }
    
    public PackageType(String weight, String length, String width, String height){
        this.weight = weight;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    /**
     * @return the weight
     */
    public String getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }

    /**
     * @return the length
     */
    public String getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(String length) {
        this.length = length;
    }

    /**
     * @return the width
     */
    public String getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(String width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public String getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(String height) {
        this.height = height;
    }
    
    public static PackageType parsePackage(com.fedex.stub.RequestedPackageLineItem rrpl){
        
        PackageType pt = new PackageType();
        pt.setWeight(String.valueOf(rrpl.getWeight().getValue()) + " " + rrpl.getWeight().getUnits().toString());
        pt.setLength(String.valueOf(rrpl.getDimensions().getLength()) + " in");
        pt.setWidth(String.valueOf(rrpl.getDimensions().getWidth()) + " in");
        pt.setHeight(String.valueOf(rrpl.getDimensions().getHeight()) + " in");
        
        return pt;
    }
    
    public static PackageType parsePackage(com.ups.xmlschema.xoltws.rate.v1.PackageType upt){
        
        PackageType pt = new PackageType();
        pt.setWeight(upt.getPackageWeight().getWeight());
        pt.setLength(upt.getDimensions().getLength());
        pt.setWidth(upt.getDimensions().getWidth());
        pt.setHeight(upt.getDimensions().getHeight());
        
        return pt;
    }
    
}
