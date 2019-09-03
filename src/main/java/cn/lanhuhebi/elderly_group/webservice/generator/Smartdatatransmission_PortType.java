/**
 * Smartdatatransmission_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.lanhuhebi.elderly_group.webservice.generator;

public interface Smartdatatransmission_PortType extends java.rmi.Remote {
    String sendsmartequcmd(String orgId, byte[] sequence, byte[] md5, String smartEquNo, java.lang.String messsage) throws java.rmi.RemoteException;
    String getsmartequrtdata(String orgId, byte[] sequence, byte[] md5, String smartEquNo) throws java.rmi.RemoteException;
    String getsmartequlistdata(String orgId, byte[] sequence, byte[] md5) throws java.rmi.RemoteException;
}
