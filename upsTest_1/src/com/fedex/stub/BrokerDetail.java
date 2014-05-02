/**
 * BrokerDetail.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.fedex.stub;

public class BrokerDetail  implements java.io.Serializable {
    private com.fedex.stub.BrokerType type;

    private com.fedex.stub.Party broker;

    public BrokerDetail() {
    }

    public BrokerDetail(
           com.fedex.stub.BrokerType type,
           com.fedex.stub.Party broker) {
           this.type = type;
           this.broker = broker;
    }


    /**
     * Gets the type value for this BrokerDetail.
     * 
     * @return type
     */
    public com.fedex.stub.BrokerType getType() {
        return type;
    }


    /**
     * Sets the type value for this BrokerDetail.
     * 
     * @param type
     */
    public void setType(com.fedex.stub.BrokerType type) {
        this.type = type;
    }


    /**
     * Gets the broker value for this BrokerDetail.
     * 
     * @return broker
     */
    public com.fedex.stub.Party getBroker() {
        return broker;
    }


    /**
     * Sets the broker value for this BrokerDetail.
     * 
     * @param broker
     */
    public void setBroker(com.fedex.stub.Party broker) {
        this.broker = broker;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BrokerDetail)) return false;
        BrokerDetail other = (BrokerDetail) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
            ((this.broker==null && other.getBroker()==null) || 
             (this.broker!=null &&
              this.broker.equals(other.getBroker())));
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
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        if (getBroker() != null) {
            _hashCode += getBroker().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BrokerDetail.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://fedex.com/ws/rate/v14", "BrokerDetail"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("http://fedex.com/ws/rate/v14", "Type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://fedex.com/ws/rate/v14", "BrokerType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("broker");
        elemField.setXmlName(new javax.xml.namespace.QName("http://fedex.com/ws/rate/v14", "Broker"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://fedex.com/ws/rate/v14", "Party"));
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
