package cn.lanhuhebi.elderly_group.controller;

import cn.lanhuhebi.elderly_group.model.pojo.Equipment;
import cn.lanhuhebi.elderly_group.service.EquipmentService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName EquipmentController
 * @Author Oblivion
 * @Date 2019/8/13
 * @Version 1.0
 **/

@Controller
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @RequestMapping("/eptlist")
    @ResponseBody
    public String eptList() {
        List<Equipment> listEpt = equipmentService.getAllEquipment(null, 1);
        return JSON.toJSONString(listEpt);
    }
}
