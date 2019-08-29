package cn.lanhuhebi.elderly_group.controller;

import cn.lanhuhebi.elderly_group.model.pojo.Equipment;
import cn.lanhuhebi.elderly_group.model.pojo.Liblogs;
import cn.lanhuhebi.elderly_group.model.pojo.Personnel;
import cn.lanhuhebi.elderly_group.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        List<Equipment> listEpt = equipmentService.getAllEquipment();
        model.addAttribute("elist", listEpt);
        return "equipment/eptlist";
    }

    @RequestMapping("/upstock")
    public String upStock(Equipment equipment, Liblogs liblogs, HttpSession session, RedirectAttributes attributes) {
        Personnel personnel = (Personnel) session.getAttribute("personnel");
        boolean b = equipmentService.updateStock(equipment, liblogs, personnel);
        if (!b) {
            attributes.addFlashAttribute("upInfo", "修改失败");
        }
        return "redirect:/eptlist";
    }

    @RequestMapping("/addept")
    public String addept(Equipment equipment, RedirectAttributes attributes) {
        boolean b = equipmentService.addEquipment(equipment);
        if (!b) {
            attributes.addFlashAttribute("AddInfo", "添加失败");
        }
        return "redirect:/eptlist";
    }
}
