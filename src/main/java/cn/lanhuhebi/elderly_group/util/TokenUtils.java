package cn.lanhuhebi.elderly_group.util;

import cn.lanhuhebi.elderly_group.model.dto.PersonnelVo;
import cn.lanhuhebi.elderly_group.service.PersonnelService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Component
public class TokenUtils {

    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private PersonnelService personnelService;


    public Object[] login(PersonnelVo personnelVo)throws Exception{

        //生成用户token
        String token=this.generateToken(personnelVo);
        //保存用户token到redis
        this.saveToken(token,personnelVo);
        return new Object[]{personnelVo,token};
    }




    //生成Token
    private String generateToken(PersonnelVo personnelVo){
        StringBuilder builder=new StringBuilder();
        builder.append("token-");
        builder.append("APP-"+"-");
        String info=MD5Utils.getSaltMD5(personnelVo.getPrePhone());
        builder.append(info+"-");
        builder.append(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        builder.append(UUID.randomUUID().toString().substring(0,6));
        return builder.toString();
    }

    private void saveToken(String token,PersonnelVo personnelVo){

        String tokenKey="laonian-"+personnelVo.getPreId();
        String tokenValue=null;
        if ((tokenValue=(String)redisUtils.get(tokenKey))!=null){
            //说明用户已经登录了
            redisUtils.delete(tokenKey);
            redisUtils.delete(token);
        }
        //缓存用户token
        redisUtils.set(tokenKey,1800,token);
        System.out.println("tokenKey================>"+tokenKey);
        //缓存用户详细信息
        redisUtils.set(token,1800, JSON.toJSONString(personnelVo));
        System.out.println("tokenVO============>"+token);
    }
}
