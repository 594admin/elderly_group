package cn.lanhuhebi.elderly_group.controller;

import cn.lanhuhebi.elderly_group.model.pojo.Personnel;
import cn.lanhuhebi.elderly_group.service.PersonnelService;
import cn.lanhuhebi.elderly_group.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PersonnelController {

    @Autowired
    private PersonnelService personnelService;
    @Autowired
    private RoleService roleService;

    /**
     * 去账户列表页面
     * @param model
     * @return
     */
    @GetMapping(value = "/listPersonnels")
    public String listPersonnels(Model model){
        //查詢所有的员工信息
        model.addAttribute("listPersonnel",personnelService.listPersonnel());
        //查询所有的角色
        model.addAttribute("listRole",roleService.getListRoles());
        return "/personnel/listpersonnel";
    }

    /**
     * 执行新增员工
     * @return
     */
    @PostMapping(value = "/doAddPersonnels")
    public String doAddPersonnels(Personnel personnel, RedirectAttributes redirectAttributes){
        if(personnelService.addPersonnel(personnel)){
            redirectAttributes.addFlashAttribute("addmsg","添加成功");
        }else{
            redirectAttributes.addFlashAttribute("addmsg","添加失败");
        }

        return "redirect:/listPersonnels";
    }

    /**
     * 判断手机号是否重复
     * @param prePhone
     * @return
     */
    @PostMapping(value = "/ajaxCheckPhone")
    @ResponseBody
    public boolean ajaxCheckPhone(String prePhone){
        return  personnelService.checkPhone(prePhone);
    }

    /**
     * 判断邮箱是否重复
     * @param preEmail
     * @return
     */
    @PostMapping(value = "/ajaxCheckEmail")
    @ResponseBody
    public boolean ajaxCheckEmail(String preEmail){
        return personnelService.checkEmail(preEmail);
    }

    /**
     * 去修改页面
     * @param preId
     * @param model
     * @return
     */
    @GetMapping(value = "/toUpdatePersonnel")
    public String toUpdatePersonnel(Integer preId,Model model){
        model.addAttribute("personnel",personnelService.getPersonnelOne(preId));
        return "/personnel/updatepersonnel";
    }
    /**
     * 执行修改员工
     * @return
     */
    @PostMapping(value = "/doUpdatePersonnels")
    public String doUpdatePersonnels(Personnel personnel, RedirectAttributes redirectAttributes){
        if(personnelService.updatePersonnel(personnel)){
            redirectAttributes.addFlashAttribute("addmsg","修改成功");
        }else{
            redirectAttributes.addFlashAttribute("addmsg","修改失败");
        }
        return "redirect:/listPersonnels";
    }

    /**
     * 修改时判断电话是否重复
     * @param prePhone
     * @param preId
     * @return
     */
    @PostMapping(value = "/ajaxCheckPhoneById")
    @ResponseBody
    public Integer ajaxCheckPhoneById(String prePhone,Integer preId){
        return personnelService.checkPhoneByPreId(prePhone, preId);
    }

    /**
     * 修改时判读手机号是否重复
     * @param preEmail
     * @param preId
     * @return
     */
    @PostMapping(value = "/ajaxCheckEmailById")
    @ResponseBody
    public Integer ajaxCheckEmailById(String preEmail,Integer preId){
        return personnelService.checkEmailByPreId(preEmail, preId);
    }

    /**
     * 执行新增权限操作
     * @return
     */
    @PostMapping(value = "/doAddPerRole")
    public String doAddPerRole(Integer roleId,Integer preId,RedirectAttributes redirectAttributes){
        System.out.println("roleId =====> " + roleId);
        System.out.println("preId =====> " + preId);
        if(personnelService.addPerRole(roleId, preId)){
            redirectAttributes.addFlashAttribute("addmsg","修改角色成功");
        }else{
            redirectAttributes.addFlashAttribute("addmsg","修改角色失败");
        }
        return "redirect:/listPersonnels";
    }
}
