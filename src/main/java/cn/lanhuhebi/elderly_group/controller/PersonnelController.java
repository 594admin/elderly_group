package cn.lanhuhebi.elderly_group.controller;

import cn.lanhuhebi.elderly_group.service.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonnelController {

    @Autowired
    private PersonnelService personnelService;

    @GetMapping(value = "/listPersonnels")
    public String listPersonnels(Model model){
        model.addAttribute("listPersonnel",personnelService.listPersonnel());
        return "/personnel/listpersonnel";
    }
}
