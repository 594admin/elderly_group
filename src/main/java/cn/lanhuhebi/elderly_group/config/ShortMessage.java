package cn.lanhuhebi.elderly_group.config;


import cn.lanhuhebi.elderly_group.util.VerificationCode;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * 腾讯云短信验证
 * #短信应用 SDK AppID
 * short.message.appid=1400244027
 * #短信应用 SDK AppKey
 * short.message.appkey=857f3ee049e0499fa4b150730cf3191d
 * #短信模板 ID，需要在短信应用中申请
 * short.message.templateId=409141
 * #签名
 * short.message.smsSign=动力面条
 */
@ConfigurationProperties(prefix = "short.message")
@Component
public class ShortMessage {
    public static Integer appid;
    public static String appkey;
    public static Integer templateId;
    public static Integer registerId;
    public static String smsSign;
    @Autowired
    private static SmsSingleSender smsSingleSender;

    public void setRegisterId(Integer registerId) {
        ShortMessage.registerId = registerId;
    }

    public ShortMessage setAppid(Integer appid) {
        this.appid = appid;
        return this;
    }

    public ShortMessage setAppkey(String appkey) {
        this.appkey = appkey;
        return this;
    }

    public ShortMessage setTemplateId(Integer templateId) {
        this.templateId = templateId;
        return this;
    }

    public ShortMessage setSmsSign(String smsSign) {
        this.smsSign = smsSign;
        return this;
    }

    //初始化装配
    @PostConstruct
    public void init(){
        smsSingleSender =  new SmsSingleSender(appid,appkey);
    }
    //手机登录短信发送成功返回验证码
    public static String loginCode(String phone) {
        String[] phoneNumbers = {phone};
        String coed = VerificationCode.randomCode();
        String[] params = {coed,"3"};
        SmsSingleSenderResult result = null;
        try {
            result = smsSingleSender.sendWithParam("86", phoneNumbers[0], templateId, params, smsSign, "", "");
        } catch (HTTPException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if("OK".equals(result.errMsg)){
            return coed;
        }
        return null;
    }

    //手机注册短信发送成功返回验证码
    public static String addCode(String phone) {
        String[] phoneNumbers = {phone};
        String coed = VerificationCode.randomCode();
        System.out.println("注册手机号："+phone);
        String[] params = {coed,"3","QQ：229004872","【清洁能源】"};
        SmsSingleSenderResult result = null;
        try {
            result = smsSingleSender.sendWithParam("86", phoneNumbers[0], registerId, params, smsSign, "", "");
        } catch (HTTPException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if("OK".equals(result.errMsg)){
            return coed;
        }
        return null;
    }
}
