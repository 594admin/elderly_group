package cn.lanhuhebi.elderly_group.app;

import cn.lanhuhebi.elderly_group.model.pojo.Family;
import cn.lanhuhebi.elderly_group.model.pojo.Personnel;
import cn.lanhuhebi.elderly_group.service.FamilyService;
import cn.lanhuhebi.elderly_group.service.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

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
    @CrossOrigin
    public String code(@RequestParam("phone")String phone){
        System.out.println("获取验证码");
        if (!personnelService.checkPhone(phone)){
            return "error";
        }
        this.phone = phone;
        return code;
    }

    @GetMapping("personl")
    @CrossOrigin
    public ResponseEntity<Personnel> persol(@RequestParam("userId")Integer preId){
        Personnel personnelOne = this.personnelService.getPersonnelOne(preId);

        if (personnelOne == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(personnelOne);
    }


    /**
     * 登录
     * @param
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
    @CrossOrigin
    public ResponseEntity<Personnel> login(@RequestParam("uname")String pre_phone, @RequestParam("pwd")String pwd){

        System.out.println(pre_phone+"?????????????????");
        Personnel personnel = this.personnelService.login(pre_phone);

        return ResponseEntity.ok(personnel);
    }


    /**
     * 查询当前组所有户信息
     * @param pre_id
     * @return
     */
    @RequestMapping("/listFamily")
    @CrossOrigin
    public ResponseEntity<List<Family>> queryFamilyByTeamId(@RequestParam("pre_id")Integer pre_id){
        List<Family> families = this.familyService.queryAllByFlyId(pre_id);
        return ResponseEntity.ok(families);
    }


    /**
     *
     * @param fly_id
     * @return
     */
    @RequestMapping("/deletefamily")
    @CrossOrigin
    public ResponseEntity<Boolean> updatefamilystatus(@RequestParam("fly_id")Integer fly_id){
        System.out.println("删除操作开始》》》》》》》》》》》》》");
        boolean result = this.familyService.updateFamilyStatus(fly_id);

        if(result){
            return ResponseEntity.ok(result);
        }else{
            return ResponseEntity.notFound().build();
        }


    }

    /**
     *
     * @return
     */
    @RequestMapping("/addFamilyFirst")
    @CrossOrigin
    public ResponseEntity<Boolean> addFamilyFirst(@RequestParam("shuju")String shuju,
                                                  @RequestParam("address02")String fly_address,
                                                  @RequestParam(value = "menpai",required = false)String fly_doorNum,
                                                  @RequestParam("huzhu")String fly_name,
                                                  @RequestParam("shenfenzheng")String fly_IDcard,
                                                  @RequestParam("lainxidianhua")String fly_phone,
                                                  @RequestParam("jianzhu")Double fly_buldArea,
                                                  @RequestParam("qunuan")Double fly_heatArea,
                                                  @RequestParam(value = "beizhu",required = false)String fly_notes,
                                                  @RequestParam("date")String fly_birthday,
                                                  @RequestParam(value = "index",required = false)Integer fly_ispoor
                                                    ,@RequestParam(value = "userId",required = false)String userId){
        System.out.println(userId + "$$$$$$$$$$$$");
        Family family=new Family();
        if(fly_doorNum!=null){
            family.setFly_doorNum(fly_doorNum);
        }
        if(fly_ispoor!=null){
            family.setFly_ispoor(fly_ispoor);
        }
        if(fly_notes!=null){
            family.setFly_notes(fly_notes);
        }
        family.setFly_address(fly_address);
        family.setFly_name(fly_name);
        family.setFly_IDcard(fly_IDcard);
        family.setFly_phone(fly_phone);
        family.setFly_buldArea(fly_buldArea);
        family.setFly_heatArea(fly_heatArea);
        family.setFly_status(2);
        try {
            family.setFly_birthday( new SimpleDateFormat("yyyy-MM-dd").parse(fly_birthday) );
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(family.toString());



//
//        fly_area_id=#{fly_area_id},
//        fly_tem_id=#{fly_tem_id},fly_status=2,fly_date=Now()
//



        return null;
    }



}
