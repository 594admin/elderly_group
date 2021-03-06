package cn.lanhuhebi.elderly_group.controller;

import cn.lanhuhebi.elderly_group.model.pojo.Personnel;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * 登录
 * 除了登录页面“/” 、执行登录页面"/doLogin" shiro都拦截判断用户是否登录
 * 暂时没写权限认证
 * /logout 是shiro 做好的退出方法
 */
@Controller
public class LoginController {

    /**
     * 去登录页面
     *
     * @return
     */
    @GetMapping(value = "/")
    public String toLogin() {
        return "login";
    }


    @PostMapping(value = "/doLogin")
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
           if(subject.isPermitted("46")||subject.isPermitted("47")|| subject.isPermitted("48")||subject.isPermitted("49")
                    ||subject.isPermitted("50")
                ||subject.isPermitted("51")){
                //将员工对象传给页面
                Personnel personnel = (Personnel) subject.getPrincipal();
                //将员工对象从Shiro内取出然后传给页面
                session.setAttribute("personnel", personnel);
                //登录成功
                return "redirect:/info";
            }else{
                return "redirect:/notauth";
            }
        } else {
            token.clear();
            //登录失败
            return "redirect:/";
        }
    }

}
