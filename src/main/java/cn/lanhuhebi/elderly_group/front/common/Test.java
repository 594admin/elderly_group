package cn.lanhuhebi.elderly_group.front.common;

import com.github.qcloudsms.SmsMultiSender;
import com.github.qcloudsms.SmsMultiSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;

import java.io.IOException;

/**
 * @ClassName Test
 * @Author LiuXin
 * @Date 2019/8/30 0030
 * @Version 1.0
 **/
public class Test {

    public static void main(String[] args) throws HTTPException, IOException {
            int appid = 1400198346; // 1400开头
            String appkey = "070c76ddf1f88fc76da165ba8688ce4b";
            String phone = "17600850307";
            String[] phoneNumbers = {phone};
            int templateId = 309426;
            String smsSign = "星芒科技";
            String[] params = {"3","2"};
            SmsMultiSender msender = new SmsMultiSender(appid, appkey);
            SmsMultiSenderResult result =  msender.sendWithParam("86", phoneNumbers,
                    templateId, params, smsSign, "", "");
        if(result.errMsg.equals("OK")) {
            System.out.println("success");
        }

    }



}
