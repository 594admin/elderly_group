package cn.lanhuhebi.elderly_group.webservice;

import org.apache.commons.codec.binary.Base64;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;

/**
 * @author dxq
 * @date 2019-08-30 - 13:34
 */
public class test {

    public static void main(String[] args) throws RemoteException, ServiceException {

        SmartdatatransmissionServiceLocator locator = new SmartdatatransmissionServiceLocator();
        Smartdatatransmission_PortType smartdatatransmission = locator.getsmartdatatransmission();

        SmartdatatransmissionService service = new SmartdatatransmissionServiceLocator();
        Smartdatatransmission_PortType getsmartdatatransmission = service.getsmartdatatransmission();
        String uuid = UuidUtil.get32UUID();
        String s1 = MD5.md5(uuid);
        //AES_CBC_Encrypt(byte[] content,String keyBytes)

        byte[] bytes1 = Base64.decodeBase64(s1);

        byte[] bytes = AesUtils.AES_CBC_Encrypt(bytes1,"8948112EFF8F43A5");

        byte[] bytes2 = Base64.decodeBase64(bytes);

        //String orgId, byte[] sequence, byte[] md5

        String s = smartdatatransmission.getsmartequlistdata("01000A001", bytes1, bytes2);
        //String s = getsmartdatatransmission.getsmartequlistdata("01000A001", bytes1, bytes2);
        System.out.println(s);

    }
}
