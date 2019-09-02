/**
 * SmartdatatransmissionServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.lanhuhebi.elderly_group.webservice.generator;

import javax.xml.rpc.ServiceException;

public class SmartdatatransmissionServiceLocator extends org.apache.axis.client.Service implements SmartdatatransmissionService {

    public SmartdatatransmissionServiceLocator() {
    }


    public SmartdatatransmissionServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SmartdatatransmissionServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for smartdatatransmission
    private java.lang.String smartdatatransmission_address = "http://125.72.17.218:7050/hy360dm/services/smartdatatransmission";

    public java.lang.String getsmartdatatransmissionAddress() {
        return smartdatatransmission_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String smartdatatransmissionWSDDServiceName = "smartdatatransmission";

    public java.lang.String getsmartdatatransmissionWSDDServiceName() {
        return smartdatatransmissionWSDDServiceName;
    }

    public void setsmartdatatransmissionWSDDServiceName(java.lang.String name) {
        smartdatatransmissionWSDDServiceName = name;
    }

    public Smartdatatransmission_PortType getsmartdatatransmission() throws ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(smartdatatransmission_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new ServiceException(e);
        }
        return getsmartdatatransmission(endpoint);
    }

    public Smartdatatransmission_PortType getsmartdatatransmission(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            SmartdatatransmissionSoapBindingStub _stub = new SmartdatatransmissionSoapBindingStub(portAddress, this);
            _stub.setPortName(getsmartdatatransmissionWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setsmartdatatransmissionEndpointAddress(java.lang.String address) {
        smartdatatransmission_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (Smartdatatransmission_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                SmartdatatransmissionSoapBindingStub _stub = new SmartdatatransmissionSoapBindingStub(new java.net.URL(smartdatatransmission_address), this);
                _stub.setPortName(getsmartdatatransmissionWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("smartdatatransmission".equals(inputPortName)) {
            return getsmartdatatransmission();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://wsdl.controller.hyit.com", "smartdatatransmissionService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://wsdl.controller.hyit.com", "smartdatatransmission"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        if ("smartdatatransmission".equals(portName)) {
            setsmartdatatransmissionEndpointAddress(address);
        } else { // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
