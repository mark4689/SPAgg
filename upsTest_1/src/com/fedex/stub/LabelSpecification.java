/**
 * LabelSpecification.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.fedex.stub;

public class LabelSpecification  implements java.io.Serializable {
    private com.fedex.stub.LabelFormatType labelFormatType;

    private com.fedex.stub.ShippingDocumentImageType imageType;

    private com.fedex.stub.LabelStockType labelStockType;

    private com.fedex.stub.LabelPrintingOrientationType labelPrintingOrientation;

    private com.fedex.stub.LabelRotationType labelRotation;

    private com.fedex.stub.ContactAndAddress printedLabelOrigin;

    private com.fedex.stub.CustomerSpecifiedLabelDetail customerSpecifiedDetail;

    public LabelSpecification() {
    }

    public LabelSpecification(
           com.fedex.stub.LabelFormatType labelFormatType,
           com.fedex.stub.ShippingDocumentImageType imageType,
           com.fedex.stub.LabelStockType labelStockType,
           com.fedex.stub.LabelPrintingOrientationType labelPrintingOrientation,
           com.fedex.stub.LabelRotationType labelRotation,
           com.fedex.stub.ContactAndAddress printedLabelOrigin,
           com.fedex.stub.CustomerSpecifiedLabelDetail customerSpecifiedDetail) {
           this.labelFormatType = labelFormatType;
           this.imageType = imageType;
           this.labelStockType = labelStockType;
           this.labelPrintingOrientation = labelPrintingOrientation;
           this.labelRotation = labelRotation;
           this.printedLabelOrigin = printedLabelOrigin;
           this.customerSpecifiedDetail = customerSpecifiedDetail;
    }


    /**
     * Gets the labelFormatType value for this LabelSpecification.
     * 
     * @return labelFormatType
     */
    public com.fedex.stub.LabelFormatType getLabelFormatType() {
        return labelFormatType;
    }


    /**
     * Sets the labelFormatType value for this LabelSpecification.
     * 
     * @param labelFormatType
     */
    public void setLabelFormatType(com.fedex.stub.LabelFormatType labelFormatType) {
        this.labelFormatType = labelFormatType;
    }


    /**
     * Gets the imageType value for this LabelSpecification.
     * 
     * @return imageType
     */
    public com.fedex.stub.ShippingDocumentImageType getImageType() {
        return imageType;
    }


    /**
     * Sets the imageType value for this LabelSpecification.
     * 
     * @param imageType
     */
    public void setImageType(com.fedex.stub.ShippingDocumentImageType imageType) {
        this.imageType = imageType;
    }


    /**
     * Gets the labelStockType value for this LabelSpecification.
     * 
     * @return labelStockType
     */
    public com.fedex.stub.LabelStockType getLabelStockType() {
        return labelStockType;
    }


    /**
     * Sets the labelStockType value for this LabelSpecification.
     * 
     * @param labelStockType
     */
    public void setLabelStockType(com.fedex.stub.LabelStockType labelStockType) {
        this.labelStockType = labelStockType;
    }


    /**
     * Gets the labelPrintingOrientation value for this LabelSpecification.
     * 
     * @return labelPrintingOrientation
     */
    public com.fedex.stub.LabelPrintingOrientationType getLabelPrintingOrientation() {
        return labelPrintingOrientation;
    }


    /**
     * Sets the labelPrintingOrientation value for this LabelSpecification.
     * 
     * @param labelPrintingOrientation
     */
    public void setLabelPrintingOrientation(com.fedex.stub.LabelPrintingOrientationType labelPrintingOrientation) {
        this.labelPrintingOrientation = labelPrintingOrientation;
    }


    /**
     * Gets the labelRotation value for this LabelSpecification.
     * 
     * @return labelRotation
     */
    public com.fedex.stub.LabelRotationType getLabelRotation() {
        return labelRotation;
    }


    /**
     * Sets the labelRotation value for this LabelSpecification.
     * 
     * @param labelRotation
     */
    public void setLabelRotation(com.fedex.stub.LabelRotationType labelRotation) {
        this.labelRotation = labelRotation;
    }


    /**
     * Gets the printedLabelOrigin value for this LabelSpecification.
     * 
     * @return printedLabelOrigin
     */
    public com.fedex.stub.ContactAndAddress getPrintedLabelOrigin() {
        return printedLabelOrigin;
    }


    /**
     * Sets the printedLabelOrigin value for this LabelSpecification.
     * 
     * @param printedLabelOrigin
     */
    public void setPrintedLabelOrigin(com.fedex.stub.ContactAndAddress printedLabelOrigin) {
        this.printedLabelOrigin = printedLabelOrigin;
    }


    /**
     * Gets the customerSpecifiedDetail value for this LabelSpecification.
     * 
     * @return customerSpecifiedDetail
     */
    public com.fedex.stub.CustomerSpecifiedLabelDetail getCustomerSpecifiedDetail() {
        return customerSpecifiedDetail;
    }


    /**
     * Sets the customerSpecifiedDetail value for this LabelSpecification.
     * 
     * @param customerSpecifiedDetail
     */
    public void setCustomerSpecifiedDetail(com.fedex.stub.CustomerSpecifiedLabelDetail customerSpecifiedDetail) {
        this.customerSpecifiedDetail = customerSpecifiedDetail;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LabelSpecification)) return false;
        LabelSpecification other = (LabelSpecification) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.labelFormatType==null && other.getLabelFormatType()==null) || 
             (this.labelFormatType!=null &&
              this.labelFormatType.equals(other.getLabelFormatType()))) &&
            ((this.imageType==null && other.getImageType()==null) || 
             (this.imageType!=null &&
              this.imageType.equals(other.getImageType()))) &&
            ((this.labelStockType==null && other.getLabelStockType()==null) || 
             (this.labelStockType!=null &&
              this.labelStockType.equals(other.getLabelStockType()))) &&
            ((this.labelPrintingOrientation==null && other.getLabelPrintingOrientation()==null) || 
             (this.labelPrintingOrientation!=null &&
              this.labelPrintingOrientation.equals(other.getLabelPrintingOrientation()))) &&
            ((this.labelRotation==null && other.getLabelRotation()==null) || 
             (this.labelRotation!=null &&
              this.labelRotation.equals(other.getLabelRotation()))) &&
            ((this.printedLabelOrigin==null && other.getPrintedLabelOrigin()==null) || 
             (this.printedLabelOrigin!=null &&
              this.printedLabelOrigin.equals(other.getPrintedLabelOrigin()))) &&
            ((this.customerSpecifiedDetail==null && other.getCustomerSpecifiedDetail()==null) || 
             (this.customerSpecifiedDetail!=null &&
              this.customerSpecifiedDetail.equals(other.getCustomerSpecifiedDetail())));
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
        if (getLabelFormatType() != null) {
            _hashCode += getLabelFormatType().hashCode();
        }
        if (getImageType() != null) {
            _hashCode += getImageType().hashCode();
        }
        if (getLabelStockType() != null) {
            _hashCode += getLabelStockType().hashCode();
        }
        if (getLabelPrintingOrientation() != null) {
            _hashCode += getLabelPrintingOrientation().hashCode();
        }
        if (getLabelRotation() != null) {
            _hashCode += getLabelRotation().hashCode();
        }
        if (getPrintedLabelOrigin() != null) {
            _hashCode += getPrintedLabelOrigin().hashCode();
        }
        if (getCustomerSpecifiedDetail() != null) {
            _hashCode += getCustomerSpecifiedDetail().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LabelSpecification.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://fedex.com/ws/rate/v14", "LabelSpecification"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("labelFormatType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://fedex.com/ws/rate/v14", "LabelFormatType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://fedex.com/ws/rate/v14", "LabelFormatType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("imageType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://fedex.com/ws/rate/v14", "ImageType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://fedex.com/ws/rate/v14", "ShippingDocumentImageType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("labelStockType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://fedex.com/ws/rate/v14", "LabelStockType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://fedex.com/ws/rate/v14", "LabelStockType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("labelPrintingOrientation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://fedex.com/ws/rate/v14", "LabelPrintingOrientation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://fedex.com/ws/rate/v14", "LabelPrintingOrientationType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("labelRotation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://fedex.com/ws/rate/v14", "LabelRotation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://fedex.com/ws/rate/v14", "LabelRotationType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("printedLabelOrigin");
        elemField.setXmlName(new javax.xml.namespace.QName("http://fedex.com/ws/rate/v14", "PrintedLabelOrigin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://fedex.com/ws/rate/v14", "ContactAndAddress"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerSpecifiedDetail");
        elemField.setXmlName(new javax.xml.namespace.QName("http://fedex.com/ws/rate/v14", "CustomerSpecifiedDetail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://fedex.com/ws/rate/v14", "CustomerSpecifiedLabelDetail"));
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
