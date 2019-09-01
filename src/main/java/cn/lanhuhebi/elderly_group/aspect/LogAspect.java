package cn.lanhuhebi.elderly_group.aspect;

import cn.lanhuhebi.elderly_group.annotation.DataLog;
import cn.lanhuhebi.elderly_group.enums.BusinessType;
import cn.lanhuhebi.elderly_group.model.pojo.Personnel;
import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * @author dxq
 * @date 2019-08-20 - 17:25
 */
@Aspect
@Component
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    /**
     * 切点 @DataLog
     */
    @Pointcut("@annotation(cn.lanhuhebi.elderly_group.annotation.DataLog)")
    public void logPointcut(){}

    @AfterThrowing(value = "logPointcut()",throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint,Exception e){
        Long time = System.currentTimeMillis();

    }

    /**
     * 前置增强
     * @param joinPoint
     */
    @Before(value = "logPointcut()")
    public void doBefore(JoinPoint joinPoint) throws Throwable{
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpSession session = request.getSession();
        Personnel personnel = (Personnel) session.getAttribute("personnel");
        DataLog dataLog = getAnnotation(joinPoint);
        BusinessType businessType = dataLog.businessType();
        String desc = dataLog.desc();
        logger.info("========================================== DataLog ==========================================");
        logger.info("USER           :   {}",personnel.getPrePhone());
        logger.info("TYPE           :   {}", businessType.toString());
        logger.info("DESC           :   {}",desc);
        logger.info("URL            :   {}", request.getRequestURL().toString());
        logger.info("HTTP Method    :   {}",request.getMethod());
        // 打印调用 controller 的全路径以及执行方法
        logger.info("Class Method   :   {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        // 打印请求的 IP
        logger.info("IP             :   {}", request.getRemoteAddr());

    }

    @After(value = "logPointcut()")
    public void doAfter() throws Throwable{
        logger.info("=========================================== End ===========================================" + System.lineSeparator());
    }

    @Around(value = "logPointcut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable{
        long startTime = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        logger.info("Args           :   {}",JSON.toJSONString(proceed));
        logger.info("Time-Consuming :   {}",System.currentTimeMillis()-startTime);
        return proceed;
    }

    /**
     * 获取注解
     */
    private DataLog getAnnotation(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if (method != null){
            return method.getAnnotation(DataLog.class);
        }
        return null;
    }

}
