/**
 * RateRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.fedex.stub;

public class RateRequest  implements java.io.Serializable {
    /* Descriptive data to be used in authentication of the sender's
     * identity (and right to use FedEx web services). */
    private com.fedex.stub.WebAuthenticationDetail webAuthenticationDetail;

    private com.fedex.stub.ClientDetail clientDetail;

    private com.fedex.stub.TransactionDetail transactionDetail;

    private com.fedex.stub.VersionId version;

    /* Allows the caller to specify that the transit time and commit
     * data are to be returned in the reply. */
    private java.lang.Boolean returnTransitAndCommit;

    /* Candidate carriers for rate-shopping use case. This field is
     * only considered if requestedShipment/serviceType is omitted. */
    private com.fedex.stub.CarrierCodeType[] carrierCodes;

    /* Contains zero or more service options whose combinations are
     * to be considered when replying with available services. */
    private com.fedex.stub.ServiceOptionType[] variableOptions;

    /* The shipment for which a rate quote (or rate-shopping comparison)
     * is desired. */
    private com.fedex.stub.RequestedShipment requestedShipment;

    public RateRequest() {
    }

    public RateRequest(
           com.fedex.stub.WebAuthenticationDetail webAuthenticationDetail,
           com.fedex.stub.ClientDetail clientDetail,
           com.fedex.stub.TransactionDetail transactionDetail,
           com.fedex.stub.VersionId version,
           java.lang.Boolean returnTransitAndCommit,
           com.fedex.stub.CarrierCodeType[] carrierCodes,
           com.fedex.stub.ServiceOptionType[] variableOptions,
           com.fedex.stub.RequestedShipment requestedShipment) {
           this.webAuthenticationDetail = webAuthenticationDetail;
           this.clientDetail = clientDetail;
           this.transactionDetail = transactionDetail;
           this.version = version;
           this.returnTransitAndCommit = returnTransitAndCommit;
           this.carrierCodes = carrierCodes;
           this.variableOptions = variableOptions;
           this.requestedShipment = requestedShipment;
    }


    /**
     * Gets the webAuthenticationDetail value for this RateRequest.
     * 
     * @return webAuthenticationDetail   * Descriptive data to be used in authentication of the sender's
     * identity (and right to use FedEx web services).
     */
    public com.fedex.stub.WebAuthenticationDetail getWebAuthenticationDetail() {
        return webAuthenticationDetail;
    }


    /**
     * Sets the webAuthenticationDetail value for this RateRequest.
     * 
     * @param webAuthenticationDetail   * Descriptive data to be used in authentication of the sender's
     * identity (and right to use FedEx web services).
     */
    public void setWebAuthenticationDetail(com.fedex.stub.WebAuthenticationDetail webAuthenticationDetail) {
        this.webAuthenticationDetail = webAuthenticationDetail;
    }


    /**
     * Gets the clientDetail value for this RateRequest.
     * 
     * @return clientDetail
     */
    public com.fedex.stub.ClientDetail getClientDetail() {
        return clientDetail;
    }


    /**
     * Sets the clientDetail value for this RateRequest.
     * 
     * @param clientDetail
     */
    public void setClientDetail(com.fedex.stub.ClientDetail clientDetail) {
        this.clientDetail = clientDetail;
    }


    /**
     * Gets the transactionDetail value for this RateRequest.
     * 
     * @return transactionDetail
     */
    public com.fedex.stub.TransactionDetail getTransactionDetail() {
        return transactionDetail;
    }


    /**
     * Sets the transactionDetail value for this RateRequest.
     * 
     * @param transactionDetail
     */
    public void setTransactionDetail(com.fedex.stub.TransactionDetail transactionDetail) {
        this.transactionDetail = transactionDetail;
    }


    /**
     * Gets the version value for this RateRequest.
     * 
     * @return version
     */
    public com.fedex.stub.VersionId getVersion() {
        return version;
    }


    /**
     * Sets the version value for this RateRequest.
     * 
     * @param version
     */
    public void setVersion(com.fedex.stub.VersionId version) {
        this.version = version;
    }


    /**
     * Gets the returnTransitAndCommit value for this RateRequest.
     * 
     * @return returnTransitAndCommit   * Allows the caller to specify that the transit time and commit
     * data are to be returned in the reply.
     */
    public java.lang.Boolean getReturnTransitAndCommit() {
        return returnTransitAndCommit;
    }


    /**
     * Sets the returnTransitAndCommit value for this RateRequest.
     * 
     * @param returnTransitAndCommit   * Allows the caller to specify that the transit time and commit
     * data are to be returned in the reply.
     */
    public void setReturnTransitAndCommit(java.lang.Boolean returnTransitAndCommit) {
        this.returnTransitAndCommit = returnTransitAndCommit;
    }


    /**
     * Gets the carrierCodes value for this RateRequest.
     * 
     * @return carrierCodes   * Candidate carriers for rate-shopping use case. This field is
     * only considered if requestedShipment/serviceType is omitted.
     */
    public com.fedex.stub.CarrierCodeType[] getCarrierCodes() {
        return carrierCodes;
    }


    /**
     * Sets the carrierCodes value for this RateRequest.
     * 
     * @param carrierCodes   * Candidate carriers for rate-shopping use case. This field is
     * only considered if requestedShipment/serviceType is omitted.
     */
    public void setCarrierCodes(com.fedex.stub.CarrierCodeType[] carrierCodes) {
        this.carrierCodes = carrierCodes;
    }

    public com.fedex.stub.CarrierCodeType getCarrierCodes(int i) {
        return this.carrierCodes[i];
    }

    public void setCarrierCodes(int i, com.fedex.stub.CarrierCodeType _value) {
        this.carrierCodes[i] = _value;
    }


    /**
     * Gets the variableOptions value for this RateRequest.
     * 
     * @return variableOptions   * Contains zero or more service options whose combinations are
     * to be considered when replying with available services.
     */
    public com.fedex.stub.ServiceOptionType[] getVariableOptions() {
        return variableOptions;
    }


    /**
     * Sets the variableOptions value for this RateRequest.
     * 
     * @param variableOptions   * Contains zero or more service options whose combinations are
     * to be considered when replying with available services.
     */
    public void setVariableOptions(com.fedex.stub.ServiceOptionType[] variableOptions) {
        this.variableOptions = variableOptions;
    }

    public com.fedex.stub.ServiceOptionType getVariableOptions(int i) {
        return this.variableOptions[i];
    }

    public void setVariableOptions(int i, com.fedex.stub.ServiceOptionType _value) {
        this.variableOptions[i] = _value;
    }


    /**
     * Gets the requestedShipment value for this RateRequest.
     * 
     * @return requestedShipment   * The shipment for which a rate quote (or rate-shopping comparison)
     * is desired.
     */
    public com.fedex.stub.RequestedShipment getRequestedShipment() {
        return requestedShipment;
    }


    /**
     * Sets the requestedShipment value for this RateRequest.
     * 
     * @param requestedShipment   * The shipment for which a rate quote (or rate-shopping comparison)
     * is desired.
     */
    public void setRequestedShipment(com.fedex.stub.RequestedShipment requestedShipment) {
        this.requestedShipment = requestedShipment;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RateRequest)) return false;
        RateRequest other = (RateRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.webAuthenticationDetail==null && other.getWebAuthenticationDetail()==null) || 
             (this.webAuthenticationDetail!=null &&
              this.webAuthenticationDetail.equals(other.getWebAuthenticationDetail()))) &&
            ((this.clientDetail==null && other.getClientDetail()==null) || 
             (this.clientDetail!=null &&
              this.clientDetail.equals(other.getClientDetail()))) &&
            ((this.transactionDetail==null && other.getTransactionDetail()==null) || 
             (this.transactionDetail!=null &&
              this.transactionDetail.equals(other.getTransactionDetail()))) &&
            ((this.version==null && other.getVersion()==null) || 
             (this.version!=null &&
              this.version.equals(other.getVersion()))) &&
            ((this.returnTransitAndCommit==null && other.getReturnTransitAndCommit()==null) || 
             (this.returnTransitAndCommit!=null &&
              this.returnTransitAndCommit.equals(other.getReturnTransitAndCommit()))) &&
            ((this.carrierCodes==null && other.getCarrierCodes()==null) || 
             (this.carrierCodes!=null &&
              java.util.Arrays.equals(this.carrierCodes, other.getCarrierCodes()))) &&
            ((this.variableOptions==null && other.getVariableOptions()==null) || 
             (this.variableOptions!=null &&
              java.util.Arrays.equals(this.variableOptions, other.getVariableOptions()))) &&
            ((this.requestedShipment==null && other.getRequestedShipment()==null) || 
             (this.requestedShipment!=null &&
              this.requestedShipment.equals(other.getRequestedShipment())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getWebAuthenticationDetail() != null) {
            _hashCode += getWebAuthenticationDetail().hashCode();
        }
        if (getClientDetail() != null) {
            _hashCode += getClientDetail().hashCode();
        }
        if (getTransactionDetail() != null) {
            _hashCode += getTransactionDetail().hashCode();
        }
        if (getVersion() != null) {
            _hashCode += getVersion().hashCode();
        }
        if (getReturnTransitAndCommit() != null) {
            _hashCode += getReturnTransitAndCommit().hashCode();
        }
        if (getCarrierCodes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCarrierCodes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCarrierCodes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getVariableOptions() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getVariableOptions());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getVariableOptions(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRequestedShipment() != null) {
            _hashCode += getRequestedShipment().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RateRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://fedex.com/ws/rate/v14", "RateRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("webAuthenticationDetail");
        elemField.setXmlName(new javax.xml.namespace.QName("http://fedex.com/ws/rate/v14", "WebAuthenticationDetail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://fedex.com/ws/rate/v14", "WebAuthenticationDetail"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clientDetail");
        elemField.setXmlName(new javax.xml.namespace.QName("http://fedex.com/ws/rate/v14", "ClientDetail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://fedex.com/ws/rate/v14", "ClientDetail"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transactionDetail");
        elemField.setXmlName(new javax.xml.namespace.QName("http://fedex.com/ws/rate/v14", "TransactionDetail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://fedex.com/ws/rate/v14", "TransactionDetail"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("version");
        elemField.setXmlName(new javax.xml.namespace.QName("http://fedex.com/ws/rate/v14", "Version"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://fedex.com/ws/rate/v14", "VersionId"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("returnTransitAndCommit");
        elemField.setXmlName(new javax.xml.namespace.QName("http://fedex.com/ws/rate/v14", "ReturnTransitAndCommit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("carrierCodes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://fedex.com/ws/rate/v14", "CarrierCodes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://fedex.com/ws/rate/v14", "CarrierCodeType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("variableOptions");
        elemField.setXmlName(new javax.xml.namespace.QName("http://fedex.com/ws/rate/v14", "VariableOptions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://fedex.com/ws/rate/v14", "ServiceOptionType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestedShipment");
        elemField.setXmlName(new javax.xml.namespace.QName("http://fedex.com/ws/rate/v14", "RequestedShipment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://fedex.com/ws/rate/v14", "RequestedShipment"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
