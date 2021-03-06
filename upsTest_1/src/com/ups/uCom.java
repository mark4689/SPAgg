/* 
 ** 
 ** Filename: JAXBTrackClient.java 
  ** Authors: United Parcel Service of America
 ** 
 ** The use, disclosure, reproduction, modification, transfer, or transmittal 
 ** of this work for any purpose in any form or by any means without the 
 ** written permission of United Parcel Service is strictly prohibited. 
 ** 
 ** Confidential, Unpublished Property of United Parcel Service. 
 ** Use and Distribution Limited Solely to Authorized Personnel. 
 ** 
 ** Copyright 2009 United Parcel Service of America, Inc.  All Rights Reserved. 
 ** 
 */
package com.ups;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.net.URL;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceRef;

import com.ups.wsdl.xoltws.rate.v1.RateErrorMessage;
import com.ups.wsdl.xoltws.rate.v1.RatePortType;
import com.ups.wsdl.xoltws.rate.v1.RateService;
import com.ups.xmlschema.xoltws.common.v1.RequestType;
import com.ups.xmlschema.xoltws.rate.v1.AddressType;
import com.ups.xmlschema.xoltws.rate.v1.CodeDescriptionType;
import com.ups.xmlschema.xoltws.rate.v1.PackageType;
import com.ups.xmlschema.xoltws.rate.v1.PackageWeightType;
import com.ups.xmlschema.xoltws.rate.v1.RateRequest;
import com.ups.xmlschema.xoltws.rate.v1.RateResponse;
import com.ups.xmlschema.xoltws.rate.v1.ShipFromType;
import com.ups.xmlschema.xoltws.rate.v1.ShipToAddressType;
import com.ups.xmlschema.xoltws.rate.v1.ShipToType;
import com.ups.xmlschema.xoltws.rate.v1.ShipmentType;
import com.ups.xmlschema.xoltws.rate.v1.ShipperType;
import com.ups.xmlschema.xoltws.upss.v1.UPSSecurity;
import com.ups.xmlschema.xoltws.rate.v1.RatedShipmentType;
import com.UniversalTypes.*;
import java.util.ArrayList;
public class uCom {	    
    static RateService service;
    

    private static final String LICENSE_NUMBER = "ECD16D575C349EA6 ";
    private static final String USER_NAME = "mak5278";
    private static final String PASSWORD = "MakJunior4689";
    private static final String ENDPOINT_URL="url";
    private static final String OUT_FILE_LOCATION = "out_file_location";
    private static final String TOOL_OR_WEB_SERVICE_NAME = "tool_or_webservice_name";
    private static Properties props = null;
    private static String statusCode = null;
    private static String description = null;

    /**
     * @param args the command line arguments
     */
    public UniversalResponseType process(PartyType from, PartyType to, com.UniversalTypes.PackageType pkg) {
       
        UniversalResponseType uRes = new UniversalResponseType();
        ArrayList<SingleResponseType> singlesList = new ArrayList();
        SingleResponseType srt0 = new SingleResponseType();
        SingleResponseType srt1 = new SingleResponseType();
        SingleResponseType srt2 = new SingleResponseType();
       try {
            service = new RateService();
            
            RatePortType ratePortType = service.getRatePort(); 
           
            BindingProvider bp = (BindingProvider)ratePortType;
           
            bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "https://wwwcie.ups.com/webservices/Rate");
           
            RateResponse rateResponse = ratePortType.processRate(populateRateRequest(from, to, pkg), populateUPSSecurity());
            //System.out.print(rateResponse.getRatedShipment().get(0).getTotalCharges().getMonetaryValue());
            statusCode = rateResponse.getResponse().getResponseStatus().getCode();
            description = rateResponse.getResponse().getResponseStatus().getDescription();
            //updateResultsToString(statusCode, description);
            
             List<RatedShipmentType> k = rateResponse.getRatedShipment();
             
            String resStr = "";
            for (int i=0; i<k.size();i++){
                resStr += "("+k.get(i).getService().getDescription()+k.get(i).getService().getCode()+")";
               
            }
            System.out.println(resStr);
            String one = "01";
            String two = "02";
            String three = "03";
           
            for (int i=0; i<k.size();i++){
                if(k.get(i).getService().getCode().equals("01")){
                    srt0.setDeliveryType(SingleResponseType.DeliveryType.NEXT_DAY);
                    srt0.setPrice(k.get(i).getTotalCharges().getMonetaryValue()); 
                    singlesList.add(srt0);
                }
                if(k.get(i).getService().getCode().equals(two)){
                    srt1.setDeliveryType(SingleResponseType.DeliveryType.SECOND_DAY);
                    srt1.setPrice(k.get(i).getTotalCharges().getMonetaryValue()); 
                    singlesList.add(srt1);
                }
                if(k.get(i).getService().getCode().equals(three)){
                    srt2.setDeliveryType(SingleResponseType.DeliveryType.GROUND);
                    srt2.setPrice(k.get(i).getTotalCharges().getMonetaryValue());   
                    singlesList.add(srt2);
                }
            }
       
           
            //resStr = statusCode + " " + description;
            //resStr = statusCode + " " + description;
           
        } catch(Exception e) {
            System.out.println(e);
        	if(e instanceof RateErrorMessage){
        		RateErrorMessage rateErrMsg = ((RateErrorMessage)e);
        		statusCode = rateErrMsg.getFaultInfo().getErrorDetail().get(0).getPrimaryErrorCode().getCode();
        		description = rateErrMsg.getFaultInfo().getErrorDetail().get(0).getPrimaryErrorCode().getDescription();
        		//updateResultsToString(statusCode, description);
                        //resStr = statusCode + " " + description;
        	} else {
        		statusCode = e.getMessage();
        		description = e.toString();
        		//updateResultsToString(statusCode, description);
                        //resStr = statusCode + " " + description;
        	}    		        	
            e.printStackTrace();
        }
        uRes.setResponseList(singlesList);
        return uRes;
    }
    
    private static RateRequest populateRateRequest(PartyType from, PartyType to, com.UniversalTypes.PackageType pkg){
    	RateRequest rateRequest = new RateRequest();
		RequestType request = new RequestType();
		//String[] requestOption = { "rate" };
		//request.setRequestOption(requestOption);
		List<String> requestOptionList = request.getRequestOption();
		requestOptionList.add("shop");
                
		rateRequest.setRequest(request);

		ShipmentType shpmnt = new ShipmentType();

		/** *******Shipper*********************/
		ShipperType shipper = new ShipperType();
		shipper.setName(from.getName());
		shipper.setShipperNumber("222006");
		AddressType shipperAddress = new AddressType();
		
		//String[] addressLines = { "Southam Rd", "Apt 3B" };
		//shipperAddress.setAddressLine(addressLines);
		List<String> addressLine = shipperAddress.getAddressLine();
		addressLine.add(from.getAddress().getLine1());
		//addressLine.add("Apt 3B");
		
		shipperAddress.setCity(from.getAddress().getCity());
		shipperAddress.setPostalCode(from.getAddress().getZip());
		shipperAddress.setStateProvinceCode(from.getAddress().getState());
		shipperAddress.setCountryCode("US");
		shipper.setAddress(shipperAddress);
		shpmnt.setShipper(shipper);
		/** ******Shipper**********************/

		/** ************ShipFrom*******************/
		ShipFromType shipFrom = new ShipFromType();
		shipFrom.setName(from.getName());
		AddressType shipFromAddress = new AddressType();
		//shipFromAddress.setAddressLine(addressLines);
		List<String> shipFromAddressLine = shipFromAddress.getAddressLine();
		shipFromAddressLine.add(from.getAddress().getLine1());
		//shipFromAddressLine.add("Apt 3B");
		
		shipFromAddress.setCity(from.getAddress().getCity());
		shipFromAddress.setPostalCode(from.getAddress().getZip());
		shipFromAddress.setStateProvinceCode(from.getAddress().getState());
		shipFromAddress.setCountryCode("US");
		shipFrom.setAddress(shipFromAddress);
		shpmnt.setShipFrom(shipFrom);
		/** ***********ShipFrom**********************/

		/** ************ShipTo*******************/
		ShipToType shipTo = new ShipToType();
		shipTo.setName(to.getName());
		ShipToAddressType shipToAddress = new ShipToAddressType();
		//String[] shipToAddressLines = { "SomeUnknownStreet" };
		//shipToAddress.setAddressLine(shipToAddressLines);
		List<String> shipToAddresLine = shipToAddress.getAddressLine();
		shipToAddresLine.add(to.getAddress().getLine1());
		shipToAddress.setCity(to.getAddress().getCity());
		shipToAddress.setPostalCode(to.getAddress().getZip());
		shipToAddress.setStateProvinceCode(to.getAddress().getState());
		shipToAddress.setCountryCode("US");
		shipTo.setAddress(shipToAddress);
		shpmnt.setShipTo(shipTo);
		/** ***********ShipTo**********************/

		/**********Service********************** */
		CodeDescriptionType service = new CodeDescriptionType();
		service.setCode("03");
             
		service.setDescription("Ground");
		shpmnt.setService(service);
		/** ********Service***********************/

		/********************Package***************** */
		PackageType pkg1 = new PackageType();
		CodeDescriptionType pkgingType = new CodeDescriptionType();
		pkgingType.setCode("02");
		//pkgingType.setDescription("UPS Letter");
		pkg1.setPackagingType(pkgingType);
		PackageWeightType pkgWeight = new PackageWeightType();
		CodeDescriptionType UOMType = new CodeDescriptionType();
		UOMType.setCode("lbs");
		UOMType.setDescription("Pounds");
		pkgWeight.setUnitOfMeasurement(UOMType);
		pkgWeight.setWeight(pkg.getWeight());
		pkg1.setPackageWeight(pkgWeight);
		//PackageType[] pkgArray = { pkg1 };
		
		//shpmnt.set_package(pkgArray);
		List<PackageType> pTypeList = shpmnt.getPackage();
		pTypeList.add(pkg1);
		/********************Package******************/
		rateRequest.setShipment(shpmnt);
    	return rateRequest;
    }
    
    private static UPSSecurity populateUPSSecurity(){
    	UPSSecurity upss = new UPSSecurity();
    	UPSSecurity.ServiceAccessToken upsSvcToken = new UPSSecurity.ServiceAccessToken();
		upsSvcToken.setAccessLicenseNumber(LICENSE_NUMBER);
		upss.setServiceAccessToken(upsSvcToken);
		UPSSecurity.UsernameToken upsSecUsrnameToken = new UPSSecurity.UsernameToken();
		upsSecUsrnameToken.setUsername(USER_NAME);
		upsSecUsrnameToken.setPassword(PASSWORD);
		upss.setUsernameToken(upsSecUsrnameToken);
		return upss;
    }
    
    /**
     * This method updates the XOLTResult.xml file with the received status and description
     * @param statusCode
     * @param description
     */
	   private static String updateResultsToString(String statusCode, String description){
	    	BufferedWriter bw = null;
	    	try{    		
	    		
	    		//File outFile = new File(props.getProperty(OUT_FILE_LOCATION));
	    		//System.out.println("Output file deletion status: " + outFile.delete());
	    		//utFile.createNewFile();
	    		//System.out.println("Output file location: " + outFile.getCanonicalPath());
	    		//bw = new BufferedWriter(new FileWriter(outFile));
	    		StringBuffer strBuf = new StringBuffer();
	    		strBuf.append("<ExecutionAt>");
	    		strBuf.append(Calendar.getInstance().getTime());
	    		strBuf.append("</ExecutionAt>\n");
	    		strBuf.append("<ToolOrWebServiceName>");
	    		//strBuf.append(props.getProperty(TOOL_OR_WEB_SERVICE_NAME));
	    		strBuf.append("</ToolOrWebServiceName>\n");
	    		strBuf.append("\n");
	    		strBuf.append("<ResponseStatus>\n");
	    		strBuf.append("<Code>");
	    		strBuf.append(statusCode);
	    		strBuf.append("</Code>\n");
	    		strBuf.append("<Description>");
	    		strBuf.append(description);
	    		strBuf.append("</Description>\n");
	    		strBuf.append("</ResponseStatus>");
	    		//bw.write(strBuf.toString());
	    		//bw.close(); 
                        return (strBuf.toString());
	    	}catch (Exception e) {
				e.printStackTrace();
			}finally{
				try{
					if (bw != null){
						bw.close();
						bw = null;
					}
				}catch (Exception e) {
					e.printStackTrace();
				}			
			}		
        return null;
	    }
}
