package cn.lanhuhebi.elderly_group.app;

import cn.lanhuhebi.elderly_group.model.dto.PersonnelVo;
import cn.lanhuhebi.elderly_group.model.pojo.Family;
import cn.lanhuhebi.elderly_group.model.pojo.Order;
import cn.lanhuhebi.elderly_group.model.pojo.Purchase;
import cn.lanhuhebi.elderly_group.service.FamilyService;
import cn.lanhuhebi.elderly_group.service.OrderService;
import cn.lanhuhebi.elderly_group.service.PurchaseService;
import cn.lanhuhebi.elderly_group.util.IdWorker;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName AppMessengerRestController
 * @Author Oblivion
 * @Date 2019/9/4
 * @Version 1.0
 **/
@RequestMapping("messenger")
@RestController
public class AppMessengerRestController {

    @Autowired
    private FamilyService familyService;

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private OrderService orderService;

    @PostMapping("listFly")
    /*public ResponseEntity<List<Family>> listfamily(@RequestAttribute("personnelVo") PersonnelVo personnelVo) {
        System.out.println(" <<<<<===personnelVo===>>>> " + personnelVo);
        return ResponseEntity.ok(familyService.queryAllByPerId(personnelVo.getPreId()));
    }*/
    public ResponseEntity<List<Family>> listfamily(@RequestParam("per_id") Integer per_id) {
        //System.out.println(" <<<<<===personnelVo===>>>> " + personnelVo);
        return ResponseEntity.ok(familyService.queryAllByPerId(per_id));
    }

    @PostMapping("delFly")
    public String deleteFamily(@RequestParam("flyId") Integer flyId) {
        boolean b = familyService.updateFamilyStatus(flyId);
        return b ? "success" : "fail";
    }

    @PostMapping("addFamilyFirsty")
    public String addFamilyFirst(@RequestParam("address")String address,
                                 @RequestParam("fly_address")String fly_address,
                                 @RequestParam(value = "fly_doorNum",required = false)String fly_doorNum,
                                 @RequestParam("fly_name")String fly_name,
                                 @RequestParam("fly_IDcard")String fly_IDcard,
                                 @RequestParam("fly_phone")String fly_phone,
                                 @RequestParam("fly_buldArea")Double fly_buldArea,
                                 @RequestParam("fly_heatArea")Double fly_heatArea,
                                 @RequestParam(value = "fly_notes",required = false)String fly_notes,
                                 @RequestParam("date")String fly_birthday,
                                 @RequestParam(value = "index",required = false)Integer fly_ispoor,
                                 @RequestParam("per_id")String per_id){

        address="386725";//鹤山区新华街道新华街南居委会
       // System.out.println(per_id + "$$$$$$$$$$$$");
        Family family=new Family();
        family.setFly_area_id(Integer.parseInt(address));
        if(fly_doorNum!=null){
            family.setFly_doorNum(fly_doorNum);
        }
        if(fly_ispoor!=null){
            family.setFly_ispoor(fly_ispoor);
        }
        if(fly_notes!=null){
            family.setFly_notes(fly_notes);
        }
        family.setFly_tem_id(familyService.queryTeamIdByPerId((Integer.parseInt(per_id)) ));
        family.setFly_address(fly_address);
        family.setFly_name(fly_name);
        family.setFly_IDcard(fly_IDcard);
        family.setFly_phone(fly_phone);
        family.setFly_buldArea(fly_buldArea);
        family.setFly_heatArea(fly_heatArea);
        family.setFly_status(2);

        System.out.println("区域是：   "+family.getFly_area_id());
        try {
            family.setFly_birthday( new SimpleDateFormat("yyyy-MM-dd").parse(fly_birthday) );
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(family.toString());
        Map<String,Object> map=new HashMap<>();
        if(familyService.addFamFirst(family)>0){
            map.put("fly_id",family.getFly_id());
            map.put("purse_num", IdWorker.getId());
            map.put("addmsg","ok");
        }else{
            map.put("addmsg","bad");
        }
        return JSON.toJSONString(map,true);
    }

    //添加户信息第二步：录入设备信息
    @RequestMapping(value = "/doAddPurchase", method = RequestMethod.POST)
    @Transactional
    public String doAddPurchase(@RequestParam("index")Integer purse_payMethod,
                                @RequestParam("purseNum")String purse_num,
                                @RequestParam("date")String purse_purseDate,
                                @RequestParam("purseReceipt")String purse_receipt,
                                @RequestParam("purseInstPtl")String purse_instPtl,
                                @RequestParam("purseFlyId")Integer purse_fly_id,
                                @RequestParam("orEptId") List<Integer> orEptId,
                                @RequestParam("orEptNum") List<Integer> orEptNum,
                                @RequestParam("orEptPrice") List<Double> orEptPrice
                                ) throws Exception{
       //date: this.date,//付款时间
        //						index: 1,//付款方式
        //						purseReceipt:"56565635", //收据编号
        //						purseInstPtl:"1111563685" ,//安装协议编号
        //						purseFlyId:this.purseFlyId,//安装户id
        //						purseNum:this.purse_num,//这是上一个页面的返回数据
        //						orEptId:[2,17],//设备id
        //						orEptNum:[1,1],//设备数量
        //						orEptPrice:[1000,1250]//设备单价
        System.out.println(purse_payMethod);
        System.out.println(purse_num);
        System.out.println(purse_purseDate);
        System.out.println(purse_receipt);
        System.out.println(purse_instPtl);
        System.out.println(purse_fly_id);
        System.out.println(orEptId.size());
        System.out.println(orEptNum.size());
        System.out.println(orEptPrice.size());
        Purchase purchase=new Purchase();
        purchase.setPurseFlyId(purse_fly_id);
        purchase.setPurseInstPtl(purse_instPtl);
        purchase.setPurseReceipt(purse_receipt);
        purchase.setPurseNum(purse_num);
        purchase.setPursePayMethod(purse_payMethod);
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
        purchase.setPursePayDate(sdf.parse(purse_purseDate));
        int i1 = this.purchaseService.addOnePurchase(purchase);
        Integer or_purse_id = purchase.getPurseId();
        Order order = new Order();
        for (int i = 0; i < orEptId.size(); i++) {
            order.setOrEptId(orEptId.get(i));
            order.setOrEptNum(orEptNum.get(i));
            order.setOrEptPrice((orEptPrice.get(i) * orEptNum.get(i)));
            order.setOrPurseId(or_purse_id);
            this.orderService.addOrder(order);
        }
        Map<String,Object> map=new HashMap<>();
        if (i1 > 0) {
            this.familyService.updateFamilyAddStatus(3, purse_fly_id);
            map.put("fly_status", 3);
            map.put("fly_id", purse_fly_id);
            map.put("addmsg", "ok");
        } else {
            map.put("addmsg", "bad");
        }
        return JSON.toJSONString(map,SerializerFeature.PrettyFormat);
    }
}
