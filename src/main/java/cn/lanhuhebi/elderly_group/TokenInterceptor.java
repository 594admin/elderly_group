package cn.lanhuhebi.elderly_group;

import cn.lanhuhebi.elderly_group.model.dto.PersonnelVo;
import cn.lanhuhebi.elderly_group.util.RedisUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * java.io.PrintWriter out = response.getWriter();
 * out.println("<html>");
 * out.println("<script>");
 * out.println("window.open ('/smpc/login/login.jsp','_top')");
 * out.println("</script>");
 * out.println("</html>");
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisUtils redisUtils;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag = false;
        String token = request.getHeader("Authorization");
        System.out.println("token +++++>>>>>>>>>>>>>>+++++++" + token);
        // 请求是否携带token
        if (!(token == null || token.isEmpty())) {
            // redis是否有该token的映射
            if (redisUtils.exist(token)) {
                flag = true;
                // personnelVo对象
                String JSON_OBJ_STR = (String) redisUtils.get(token);
                PersonnelVo personnelVo = JSON.parseObject(JSON_OBJ_STR, new TypeReference<PersonnelVo>() {
                });
                System.out.println("personnelVo========>>>>> " + personnelVo);
                request.setAttribute("personnelVo", personnelVo);
            }
        } else {
            // tokenKey不存在, tokenKey, token无映射跳转到login页
            response.sendRedirect("/fail");
        }
        return flag;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }

}
