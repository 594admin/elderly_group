package cn.lanhuhebi.elderly_group.front.messenger.controller;

import cn.lanhuhebi.elderly_group.model.dto.FamiliesVo;
import cn.lanhuhebi.elderly_group.model.pojo.Family;
import cn.lanhuhebi.elderly_group.model.pojo.Personnel;
import cn.lanhuhebi.elderly_group.service.FamilyService;
import cn.lanhuhebi.elderly_group.service.PersonnelService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName 信息员
 * @Author LiuXin
 * @Date 2019/8/30 0030
 * @Version 1.0
 **/
@RestController
@RequestMapping("messenger")
public class MessengerController {

    @Autowired
    private PersonnelService personnelService;

    @Autowired
    private FamilyService familyService;

    private String code = "111111";
    private String phone;

    /**
     * 发送验证码
     * @param phone
     * @return
     */
    @RequestMapping("/getCode")
    public String code(@RequestParam("phone")String phone){
        System.out.println("获取验证码");
        if (!personnelService.checkPhone(phone)){
            return "error";
        }
        this.phone = phone;
        return code;
    }

    @GetMapping("personl")
    public ResponseEntity<Personnel> persol(@RequestParam("userId")Integer preId){
        Personnel personnelOne = this.personnelService.getPersonnelOne(preId);
        if (personnelOne == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(personnelOne);
    }


    /**
     * 登录
     * @param uname
     * @param pwd
     * @return
     */
//    @RequestMapping("/login")
//    public String login(@RequestParam("uname")String uname, @RequestParam("pwd")String pwd){
//        if (!this.phone.equals(uname) || !this.code.equals(pwd)){
//            return "error";
//        }
//        Personnel personnel = this.personnelService.login(uname);
//        String p = JSON.toJSONString(personnel);
//        return p;
//    }
    @RequestMapping("/login")
    public ResponseEntity<Personnel> login(@RequestParam("uname")String uname, @RequestParam("pwd")String pwd){
        if (!this.phone.equals(uname) || !this.code.equals(pwd)){
            return ResponseEntity.notFound().build();
        }
        Personnel personnel = this.personnelService.login(uname);
        return ResponseEntity.ok(personnel);
    }


    /**
     * 查询当前组所有户信息
     * @param teamId
     * @return
     */
    @RequestMapping("/listFamily")
    public ResponseEntity<List<FamiliesVo>> queryFamilyByTeamId(@RequestParam("teamId")Integer teamId){
        List<Family> families = this.familyService.queryFamilyByTeamId(teamId);
        if (CollectionUtils.isEmpty(families)){
            return ResponseEntity.notFound().build();
        }
        List<FamiliesVo> familyVos = families.stream().map(family -> {
            FamiliesVo familyVo = new FamiliesVo();
            BeanUtils.copyProperties(family, familyVo);
            familyVo.setName(family.getFly_name());
            familyVo.setBirthday(family.getFly_birthday());
            familyVo.setCard(family.getFly_IDcard());
            familyVo.setPhone(family.getFly_phone());
            familyVo.setHouse(family.getFly_doorNum());
            return familyVo;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(familyVos);
    }

}
