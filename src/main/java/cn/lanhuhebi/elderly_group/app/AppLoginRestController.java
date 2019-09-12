package cn.lanhuhebi.elderly_group.app;

import cn.lanhuhebi.elderly_group.model.dto.PersonnelVo;
import cn.lanhuhebi.elderly_group.model.pojo.Personnel;
import cn.lanhuhebi.elderly_group.service.PersonnelService;
import cn.lanhuhebi.elderly_group.util.RedisUtils;
import cn.lanhuhebi.elderly_group.util.TokenUtils;
import cn.lanhuhebi.elderly_group.util.VerificationCode;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


@RestController
@RequestMapping("/login")
public class AppLoginRestController {
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private PersonnelService personnelService;
    @Autowired
    private TokenUtils tokenUtils;
    //可以登录的角色
    private Integer[] roles = {2, 3, 4, 5, 6};


    @GetMapping("/aaa")
    public String applogin(String phone) {
        String code = null;
        if(personnelService.checkPhone(phone)){
            //这个是暂时的普通Code生成方法
            code = VerificationCode.randomCode();
            // 手机验证
            //code = ShortMessage.loginCode(phone);
            redisUtils.set(phone,180,code);
        }else {
            code = "手机号未注册";
        }
        System.out.println("手机号:"+phone);
        System.out.println("验证码:"+code);

        return code;
    }

    @PostMapping(value = "/bbb")
    public String appdoXinXiYuanLogin(String phone, String code, Integer auth) {
        System.out.println("========>>>>" + phone);
        String data = null;
        String o = (String) redisUtils.get(phone);
        boolean flagPhone = true;
//        flagPhone = code.equals(o);
        Personnel personnleOne = personnelService.getPersonnleOne(phone);
        if (flagPhone) {
            Integer preRoleId = personnleOne.getPreRoleId();
            if (preRoleId != auth) {
                return "登录角色不符";
            }
            if (Arrays.asList(roles).contains(preRoleId)) {
                //组装信息
                PersonnelVo personnelVo=new PersonnelVo();
                //Vo现在与Personnel是一致的,如有其他需要可以增加属性
                BeanUtils.copyProperties(personnleOne,personnelVo);
                //更新信息(如有必要)

                try {
                    //生成token,回传页面
                    data = JSON.toJSONString(tokenUtils.login(personnelVo));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                data = "您没有权限登录";
            }
        } else {
            data = "验证码或手机号错误";
        }
        System.out.println("=================>>" + data);
        return data;
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (redisUtils.exist(token)) {
            String JSON_OBJ_STR = (String) redisUtils.get(token);
            PersonnelVo personnelVo = JSON.parseObject(JSON_OBJ_STR, new TypeReference<PersonnelVo>() {});
            redisUtils.delete("laonian-" + personnelVo.getPreId());
            redisUtils.delete(token);
        }
        return "success";
    }

    @RequestMapping("/fail")
    public String fail() {
        System.out.println("======fail======");
        return JSON.toJSONString("fail");
    }

}
