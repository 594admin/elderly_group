package cn.lanhuhebi.elderly_group.app;

import cn.lanhuhebi.elderly_group.model.dto.PersonnelVo;
import cn.lanhuhebi.elderly_group.model.pojo.Personnel;
import cn.lanhuhebi.elderly_group.service.PersonnelService;
import cn.lanhuhebi.elderly_group.util.RedisUtils;
import cn.lanhuhebi.elderly_group.util.TokenUtils;
import cn.lanhuhebi.elderly_group.util.VerificationCode;
import com.google.gson.Gson;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class AppLoginRestController {
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private PersonnelService personnelService;
    @Autowired
   private  TokenUtils tokenUtils ;
    //可以登录的角色
    private Integer[] roles = {2,3,4,5,6};


    @GetMapping("/aaa")
    public String applogin(String phone){
        String code = null;
        if(personnelService.checkPhone(phone)){
            code = VerificationCode.randomCode();
            redisUtils.set(phone,60,code);
        }else {
            code = "手机号未注册";
        }
        System.out.println("邀请码"+code);
        System.out.println("手机号"+phone);
        return code;
    }
    @GetMapping(value = "/bbb")
    public String appdoXinXiYuanLogin(String phone,String code){
        String data = null;
        String o = (String)redisUtils.get(phone);
        boolean flagPhone = true;
//        flagPhone = code.equals(o);
        Personnel personnleOne = personnelService.getPersonnleOne(phone);
        if(flagPhone){
            Integer preRoleId = personnleOne.getPreRoleId();
            if(Arrays.asList(roles).contains(preRoleId)){
                //组装信息
                PersonnelVo personnelVo=new PersonnelVo();
                BeanUtils.copyProperties(personnleOne,personnelVo);
                //更新信息(如有必要)
                //生成token
                try {
                    Object[] login = tokenUtils.login(personnelVo);
                    Gson gson = new Gson();
                    data = gson.toJson(login);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else{
                data = "您没有权限登录";
            }
        }else{
            data = "验证码或手机号错误";
        }
        System.out.println("=================>>"+data);
        return data;
    }





}
