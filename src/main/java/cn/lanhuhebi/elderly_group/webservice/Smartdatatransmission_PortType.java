/**
 * Smartdatatransmission_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.lanhuhebi.elderly_group.webservice;

public interface Smartdatatransmission_PortType extends java.rmi.Remote {
    public java.lang.String sendsmartequcmd(java.lang.String orgId, byte[] sequence, byte[] md5, java.lang.String smartEquNo, java.lang.String messsage) throws java.rmi.RemoteException;
    public java.lang.String getsmartequrtdata(java.lang.String orgId, byte[] sequence, byte[] md5, java.lang.String smartEquNo) throws java.rmi.RemoteException;
    public java.lang.String getsmartequlistdata(java.lang.String orgId, byte[] sequence, byte[] md5) throws java.rmi.RemoteException;
}
