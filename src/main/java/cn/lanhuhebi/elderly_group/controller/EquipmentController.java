package cn.lanhuhebi.elderly_group.controller;

import cn.lanhuhebi.elderly_group.model.pojo.Equipment;
import cn.lanhuhebi.elderly_group.model.pojo.Liblogs;
import cn.lanhuhebi.elderly_group.model.pojo.Personnel;
import cn.lanhuhebi.elderly_group.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
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
    public String eptList(Model model) {
        List<Equipment> listEpt = equipmentService.getAllEquipment(null, 1);
        model.addAttribute("elist", listEpt);
        return "equipment/eptlist";
    }

    @RequestMapping("/upstock")
    public String upStock(Equipment equipment, Liblogs liblogs, HttpSession session) {
        Personnel personnel = (Personnel) session.getAttribute("personnel");
        equipmentService.updateStock(equipment, liblogs, personnel);
        return "redirect:/eptlist";
    }
}
