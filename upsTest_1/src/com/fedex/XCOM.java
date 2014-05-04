/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fedex;

import com.UniversalTypes.SingleResponseType;
import com.UniversalTypes.UniversalResponseType;
import com.fedex.stub.*;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;
import javax.xml.rpc.ServiceException;
import org.apache.axis.types.NonNegativeInteger;
import com.UniversalTypes.*;

/**
 *
 * @author Aaron
 */
public class XCOM {
//    String shipperCityName = "lafayette", 
//            shipperStateCode = "IN", 
//            shipperPostalCode = "47909", 
//            shipperCountryCode = "US";
//    String recipientCityName = "Diamond Bar", 
//            recipientStateCode = "CA", 
//            recipientPostalCode = "91765", 
//            recipientCountryCode = "US";
//    String packageL = "1", 
//            packageW = "1", 
//            packageH = "1", 
//            packageWeight = "15.0";

    public UniversalResponseType process(PartyType shipper, PartyType recipient, PackageType pkg) {
        // Build a RateRequest request object
        boolean getAllRatesFlag = true; // set to true to get the rates for different service types

        UniversalResponseType response = new UniversalResponseType();
        ArrayList<SingleResponseType> singlesList = new ArrayList();
        SingleResponseType srt0 = new SingleResponseType();
        SingleResponseType srt1 = new SingleResponseType();
        SingleResponseType srt2 = new SingleResponseType();

        RateRequest request = new RateRequest();
        request.setClientDetail(createClientDetail());
        request.setWebAuthenticationDetail(createWebAuthenticationDetail());

        //
        TransactionDetail transactionDetail = new TransactionDetail();
        transactionDetail.setCustomerTransactionId("java sample - Rate Available Service Request"); // The client will get the same value back in the response
        request.setTransactionDetail(transactionDetail);

        //
        VersionId versionId = new VersionId("crs", 14, 0, 0);
        request.setVersion(versionId);

        //
        request.setReturnTransitAndCommit(true);
        RequestedShipment requestedShipment = new RequestedShipment();

        requestedShipment.setShipTimestamp(Calendar.getInstance());
        requestedShipment.setDropoffType(DropoffType.REGULAR_PICKUP);
        if (!getAllRatesFlag) {
            requestedShipment.setServiceType(ServiceType.INTERNATIONAL_PRIORITY);
            requestedShipment.setPackagingType(PackagingType.YOUR_PACKAGING);
        }
        requestedShipment.setShipper(addShipper(shipper));
        requestedShipment.setRecipient(addDomesticRecipient(recipient));
        requestedShipment.setShippingChargesPayment(addShippingChargesPayment());
        requestedShipment.setRequestedPackageLineItems(new RequestedPackageLineItem[]{addRequestedPackageLineItem(pkg)});
        requestedShipment.setPackageCount(new NonNegativeInteger("1"));
        requestedShipment.setRateRequestTypes(new RateRequestType[]{RateRequestType.ACCOUNT});
        request.setRequestedShipment(requestedShipment);

        //
        try {
            // Initialize the service
            RateServiceLocator service;
            RatePortType port;
            //
            service = new RateServiceLocator();
            updateEndPoint(service);
            port = service.getRateServicePort();
            // This is the call to the web service passing in a RateRequest and returning a RateReply
            RateReply reply = port.getRates(request); // Service call
            if (isResponseOk(reply.getHighestSeverity())) {
                singlesList = writeServiceOutput(reply, singlesList, srt0, srt1, srt2);
            }
            //printNotifications(reply.getNotifications());

        } catch (RemoteException | ServiceException e) {
        }
        response.setResponseList(singlesList);
        return response;
    }

    public ArrayList<SingleResponseType> writeServiceOutput(RateReply reply,
            ArrayList<SingleResponseType> list, SingleResponseType srt0,
            SingleResponseType srt1, SingleResponseType srt2) {
        String displayDateStandard = "", displayDate2Day = "";
        int shippingCounter = 0;

        RateReplyDetail[] rrds = reply.getRateReplyDetails();
        for (int i = 0; i < rrds.length; i++) {
            RateReplyDetail rrd = rrds[i];
            //print("\nService type", rrd.getServiceType());
            //print("Packaging type", rrd.getPackagingType());
            //printTime("Delivery Date", rrd.getDeliveryTimestamp(), TimeZone.getTimeZone("PTS"));
            //print("Test Date", getLocalTimeAsStringFromNoneOffsetCalendar(rrd.getDeliveryTimestamp()));
            //if (rrd.getTransitTime() != null) {
                //print("Transit Time: ", rrd.getTransitTime().toString());
           // }
            RatedShipmentDetail[] rsds = rrd.getRatedShipmentDetails();
            for (int j = 0; j < rsds.length; j++) {
               // print("RatedShipmentDetail " + j, "");
                RatedShipmentDetail rsd = rsds[j];
                ShipmentRateDetail srd = rsd.getShipmentRateDetail();
                //print("  Rate type", srd.getRateType());
                //printWeight("  Total Billing weight", srd.getTotalBillingWeight());
                //printMoney("  Total surcharges", srd.getTotalSurcharges());
                //printMoney("  Total net charge", srd.getTotalNetCharge());

                switch (rrd.getServiceType().toString()) {
                    case "STANDARD_OVERNIGHT":
                        if (shippingCounter == 0) {
                            srt0.setDeliveryType(SingleResponseType.DeliveryType.NEXT_DAY);
                            srt0.setPrice(String.valueOf(srd.getTotalNetCharge().getAmount()));
                            list.add(srt0);
//                            System.out.println(list.get(0).getPrice());
//                            System.out.println(list.get(0).getDeliveryType());
                            shippingCounter++;
                        }
                        break;
                    case "FEDEX_2_DAY":
                        if (shippingCounter == 1) {
                            srt1.setDeliveryType(SingleResponseType.DeliveryType.SECOND_DAY);
                            srt1.setPrice(String.valueOf(srd.getTotalNetCharge().getAmount()));
                            list.add(srt1);
//                            System.out.println(list.get(1).getPrice());
//                            System.out.println(list.get(1).getDeliveryType());
                            shippingCounter++;
                        }

                        break;
                        case "FEDEX_GROUND":
                        if (shippingCounter == 2) {
                            srt2.setDeliveryType(SingleResponseType.DeliveryType.GROUND);
                            srt2.setPrice(String.valueOf(srd.getTotalNetCharge().getAmount()));
                            list.add(srt2);
//                            System.out.println(list.get(2).getPrice());
//                            System.out.println(list.get(2).getDeliveryType());
                            shippingCounter++;
                        }

                        break;
                }

                RatedPackageDetail[] rpds = rsd.getRatedPackages();
                if (rpds != null && rpds.length > 0) {
                    //print("  RatedPackageDetails", "");
                    for (RatedPackageDetail rpd1 : rpds) {
                        //print("  RatedPackageDetail " + i, "");
                        RatedPackageDetail rpd = rpd1;
                        PackageRateDetail prd = rpd.getPackageRateDetail();
                        if (prd != null) {
                            //printWeight("    Billing weight", prd.getBillingWeight());
                            //printMoney("    Base charge", prd.getBaseCharge());
                            Surcharge[] surcharges = prd.getSurcharges();
                            if (surcharges != null && surcharges.length > 0) {
                                for (Surcharge surcharge : surcharges) {
                                    //printMoney("    " + surcharge.getDescription() + " surcharge", surcharge.getAmount());
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("");

        return list;
    }

    //If TimeStamp is not offset Java assumes UTC.
    //By setting the TimeZone to UTC the correct time is displayed.
    private String printTime(String description, Calendar calendar, TimeZone timeZone) {
        if (calendar != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy h:mm a");
            dateFormat.setTimeZone(timeZone);
            String displayDate = dateFormat.format(calendar.getTime());
            System.out.println(description + ": " + displayDate);

            return displayDate;

        }
        return null;
    }

    private static void printTime(String description, Calendar calendar) {
        if (calendar != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy h:mm a");
            String displayDate = dateFormat.format(calendar.getTime());
            System.out.println(description + ": " + displayDate);

        }
    }

    private static String getLocalTimeAsStringFromNoneOffsetCalendar(Calendar noneOffsetCalendar) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy h:mm a");
        if (noneOffsetCalendar != null) {
            dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return dateFormat.format(noneOffsetCalendar.getTime());
        }
        return dateFormat.format(Calendar.getInstance().getTime());
    }

//    private static Party addShipper() {
//        Party party = new Party();
//        Address address = new Address(); // Origin information
//        address.setStreetLines(new String[]{"SHIPPER ADDRESS LINE 1"});
//        address.setCity("Lafayette");
//        address.setStateOrProvinceCode("IN");
//        address.setPostalCode("47909");
//        address.setCountryCode("US");
//        party.setAddress(address);
//        return party;
//    }
    private Party addShipper(PartyType shipper) {
        Party party = new Party();
        Address address = new Address(); // Origin information
        address.setStreetLines(new String[]{"SHIPPER ADDRESS LINE 1"});
        address.setCity(shipper.getAddress().getCity());
        address.setStateOrProvinceCode(shipper.getAddress().getState());
        address.setPostalCode(shipper.getAddress().getZip());
        address.setCountryCode("US");
        party.setAddress(address);
        return party;
    }

    private static Party addInternationalRecipient() {
        Party party = new Party();
        Address address = new Address(); // Destination information
        address.setStreetLines(new String[]{"RECIPIENT ADDRESS LINE 1"});
        address.setCity("Anjou");
        address.setStateOrProvinceCode("PQ");
        address.setPostalCode("H1J2V8");
        address.setCountryCode("CA");
        party.setAddress(address);
        return party;
    }

//    private static Party addDomesticRecipient() {
//        Party party = new Party();
//        Address address = new Address(); // Origin information
//        address.setStreetLines(new String[]{"SHIPPER ADDRESS LINE 1"});
//        address.setCity("Diamond Bar");
//        address.setStateOrProvinceCode("CA");
//        address.setPostalCode("91765");
//        address.setCountryCode("US");
//        party.setAddress(address);
//        return party;
//    }
    private Party addDomesticRecipient(PartyType recipient) {
        Party party = new Party();
        Address address = new Address(); // Origin information
        address.setStreetLines(new String[]{"SHIPPER ADDRESS LINE 1"});
        address.setCity(recipient.getAddress().getCity());
        address.setStateOrProvinceCode(recipient.getAddress().getState());
        address.setPostalCode(recipient.getAddress().getZip());
        address.setCountryCode("US");
        party.setAddress(address);
        return party;
    }

    private static Payment addShippingChargesPayment() {
        Payment payment = new Payment();
        payment.setPaymentType(PaymentType.SENDER);
        return payment;
    }

    private RequestedPackageLineItem addRequestedPackageLineItem(PackageType pkg) {
        RequestedPackageLineItem lineItem = new RequestedPackageLineItem();
        lineItem.setGroupPackageCount(new NonNegativeInteger("1"));
        lineItem.setWeight(new Weight(WeightUnits.LB, new BigDecimal(pkg.getWeight())));
        lineItem.setInsuredValue(new Money("USD", new BigDecimal("100.00")));
        lineItem.setDimensions(new Dimensions(new NonNegativeInteger(pkg.getHeight()),
                new NonNegativeInteger(pkg.getLength()),
                new NonNegativeInteger(pkg.getWidth()), LinearUnits.IN));
        return lineItem;
    }

    private static ClientDetail createClientDetail() {
        ClientDetail clientDetail = new ClientDetail();
        String accountNumber = System.getProperty("accountNumber");
        String meterNumber = System.getProperty("meterNumber");

        //
        // See if the accountNumber and meterNumber properties are set,
        // if set use those values, otherwise default them to "XXX"
        //
        if (accountNumber == null) {
            accountNumber = "510087763"; // Replace "XXX" with clients account number
        }
        if (meterNumber == null) {
            meterNumber = "118634416"; // Replace "XXX" with clients meter number
        }
        clientDetail.setAccountNumber(accountNumber);
        clientDetail.setMeterNumber(meterNumber);
        return clientDetail;
    }

    private static WebAuthenticationDetail createWebAuthenticationDetail() {
        WebAuthenticationCredential wac = new WebAuthenticationCredential();
        String key = System.getProperty("key");
        String password = System.getProperty("password");

        //
        // See if the key and password properties are set,
        // if set use those values, otherwise default them to "XXX"
        //
        if (key == null) {
            key = "wmg2chLzHR4icKlr"; // Replace "XXX" with clients key
        }
        if (password == null) {
            password = "2vc1aRlfFpeKzwEeR4Drgh8Ct"; // Replace "XXX" with clients password
        }
        wac.setKey(key);
        wac.setPassword(password);
        return new WebAuthenticationDetail(wac);
    }

    private static void printNotifications(Notification[] notifications) {
        System.out.println("Notifications:");
        if (notifications == null || notifications.length == 0) {
            System.out.println("  No notifications returned");
        }
        for (int i = 0; i < notifications.length; i++) {
            Notification n = notifications[i];
            System.out.print("  Notification no. " + i + ": ");
            if (n == null) {
                System.out.println("null");
                continue;
            } else {
                System.out.println("");
            }
            NotificationSeverityType nst = n.getSeverity();

            System.out.println("    Severity: " + (nst == null ? "null" : nst.getValue()));
            System.out.println("    Code: " + n.getCode());
            System.out.println("    Message: " + n.getMessage());
            System.out.println("    Source: " + n.getSource());
        }
    }

    private static boolean isResponseOk(NotificationSeverityType notificationSeverityType) {
        if (notificationSeverityType == null) {
            return false;
        }
        return notificationSeverityType.equals(NotificationSeverityType.WARNING)
                || notificationSeverityType.equals(NotificationSeverityType.NOTE)
                || notificationSeverityType.equals(NotificationSeverityType.SUCCESS);
    }

    private static void print(String msg, Object obj) {
        if (msg == null || obj == null) {
            return;
        }
        System.out.println(msg + ": " + obj.toString());
    }

    private static void printMoney(String msg, Money money) {
        if (msg == null || money == null) {
            return;
        }
        System.out.println(msg + ": " + money.getAmount() + " " + money.getCurrency());
    }

    private static void printWeight(String msg, Weight weight) {
        if (msg == null || weight == null) {
            return;
        }
        System.out.println(msg + ": " + weight.getValue() + " " + weight.getUnits());
    }

    private static void updateEndPoint(RateServiceLocator serviceLocator) {
        String endPoint = System.getProperty("endPoint");
        if (endPoint != null) {
            serviceLocator.setRateServicePortEndpointAddress(endPoint);
        }
    }
}
