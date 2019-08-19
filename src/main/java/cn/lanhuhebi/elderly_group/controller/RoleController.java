package cn.lanhuhebi.elderly_group.controller;

import cn.lanhuhebi.elderly_group.model.pojo.Auth;
import cn.lanhuhebi.elderly_group.service.RoleService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 去角色列表
     * @return
     */
    @GetMapping(value = "/tolistrole")
    public String tolistrole(Model model){
        model.addAttribute("roles",roleService.getListRoleAndAuth());
        return "role/listrole";
    }

    /**
     * 执行新增角色方法
     * @param roleName
     * @param redirectAttributes
     * @return
     */
    @PostMapping(value = "/doAddRole")
    public String doAddRole(String roleName, RedirectAttributes redirectAttributes){
        if(roleService.addRole(roleName)){
            redirectAttributes.addFlashAttribute("addmsg","添加角色成功");
        }else {
            redirectAttributes.addFlashAttribute("addmsg","添加角色失败");
        }
        return "redirect:/tolistrole";
    }

    /**
     * ajax判断角色名是否重复
     * @param roleName
     * @return
     */
    @PostMapping(value = "/ajaxGetRoleByRoleName")
    @ResponseBody
    public boolean ajaxGetRoleByRoleName(String roleName){
        return roleService.getRoleByroleName(roleName);
    }

    //去菜单及权限配置
    @GetMapping("/toUpdateAuth")
    public String toUpdateAuth(Integer rlId, Model model, String rlName){
        model.addAttribute("rlId",rlId);
        model.addAttribute("rlName",rlName);
        return "role/updateAuth";
    }

    //获得当前角色所有权限
    @PostMapping("/ajaxgetSysRoleAuthByRoleId")
    @ResponseBody
    public String ajaxgetSysRoleAuthByRoleId(Integer rlId){
        List<Auth> auths = roleService.getSysRoleAuthByRoleId(rlId);
        Gson gson = new Gson();
        return gson.toJson(auths);
    }
    //执行修改方法
    @PostMapping(value = "/doUpdateAuth")
    public String doUpdateAuth(@RequestParam(value = "authId",required = false) Set<Integer> authId, String rlName,Integer roleId,RedirectAttributes attributes){
        if(authId.size()>0){
            Integer[] integers = roleService.updateAUthsByRoleId(authId, roleId);
            attributes.addFlashAttribute("addauthmsg",integers[0]);
            attributes.addFlashAttribute("delauthmsg",integers[1]);
            attributes.addFlashAttribute("rlName",rlName);
        }
        return "redirect:/tolistrole";
    }
    //如果没有权限执行这个方法，返回登录页面
    @RequestMapping("/notauth")
    public String notauth(HttpSession session){
        session.setAttribute("msg", "您没有权限请联系管理员");
        return "login";
    }


}
