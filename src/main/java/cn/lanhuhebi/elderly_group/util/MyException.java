package cn.lanhuhebi.elderly_group.util;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用来捕获 没有权限异常 并重定向Url
 */
@ControllerAdvice
public class MyException {
   @ExceptionHandler(value = UnauthorizedException.class)
    public void defaultErrorHandler(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/notauth");
    }
}
