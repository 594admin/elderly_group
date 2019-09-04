package cn.lanhuhebi.elderly_group.webservice;

import cn.lanhuhebi.elderly_group.model.domain.Msg;
import cn.lanhuhebi.elderly_group.model.pojo.Smartequ;
import cn.lanhuhebi.elderly_group.webservice.generator.SmartdatatransmissionServiceLocator;
import cn.lanhuhebi.elderly_group.webservice.generator.Smartdatatransmission_PortType;
import cn.lanhuhebi.elderly_group.webservice.utils.AesUtils;
import cn.lanhuhebi.elderly_group.webservice.utils.MD5;
import cn.lanhuhebi.elderly_group.webservice.utils.UuidUtil;
import com.alibaba.fastjson.JSON;
import org.json.JSONObject;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;
import java.util.List;

/**
 * @author dxq
 * @date 2019-08-30 - 13:34
 */
public class test {

    public static void main(String[] args) throws RemoteException, ServiceException {

        SmartdatatransmissionServiceLocator locator = new SmartdatatransmissionServiceLocator();

        Smartdatatransmission_PortType smartdatatransmission = locator.getsmartdatatransmission();

        String key = "chinashanghaijky";

        String OrgId = "01000A001";

        String Code = "8948112EFF8F43A5";

        String UUID = new UuidUtil().get32UUID();

        String CodeID = Code + UUID;

        byte[] sequence = AesUtils.AES_CBC_Encrypt(UUID.getBytes(), key);

        byte[] md5 = AesUtils.AES_CBC_Encrypt(MD5.md5(CodeID).getBytes(), key);

        String s = smartdatatransmission.getsmartequlistdata(OrgId, sequence, md5);
        System.out.println("----------------------------------------------------------");
        System.out.println(s);

//        List<Smartequ> students = JSON.parseObject(s,new TypeReference<List<Smartequ>>(){});
//        System.out.println(students);

        JSONObject jsonObject = new JSONObject(s);
        Object message = jsonObject.get("message");
        System.out.println(message.toString());
        List<Smartequ> smartequs = JSON.parseArray(message.toString(), Smartequ.class);
        smartequs.forEach(System.out::println);

//        System.out.println("----------------------------------------------------------");
//        //15304809
//        //String orgId, byte[] sequence, byte[] md5, String smartEquNo
//        String getsmartequrtdata = smartdatatransmission.getsmartequrtdata(SequenceUtils.ORGID, SequenceUtils.sequence(), SequenceUtils.md5(), "00987528");
//        System.out.println("----------------------------------------------------------");
//        System.out.println(getsmartequrtdata);
//        System.out.println("----------------------------------------------------------");



    }
}
