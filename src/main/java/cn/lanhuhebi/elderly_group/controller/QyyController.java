package cn.lanhuhebi.elderly_group.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * 以后可以删除
 */
@Controller
public class QyyController {

    @RequiresRoles(value = "1")
    @RequestMapping("/testShiro")
    public String testShiro(){
        return "login";
    }

    @RequestMapping("/test")
    public String textAuth(){
        return "role/auth";
    }


    @PostMapping(value = "/doAuth")
    public String doLogin(RedirectAttributes redirectAttributes,
                          @RequestParam(value = "account") String account,
                          @RequestParam(value = "password") String password, HttpSession session) {
        //shiro对象方法，需要账号与密码
        UsernamePasswordToken token = new UsernamePasswordToken(account, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            //执行认证
            subject.login(token);
        } catch (UnknownAccountException u) {
            redirectAttributes.addFlashAttribute("msg", "用户账号不正确");
        } catch (IncorrectCredentialsException e) {
            redirectAttributes.addFlashAttribute("msg", "密码不正确");
        }
        if (subject.isAuthenticated()) {
            return "testAuto";
        } else {
            token.clear();
            //登录失败
            return "redirect:/test";
        }
    }

}
