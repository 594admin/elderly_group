package cn.lanhuhebi.elderly_group.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author dxq
 * @date 2019-08-20 - 17:25
 */
@Aspect
@Component
public class LogAspect {

    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("@annotation(cn.lanhuhebi.elderly_group.annotation.DataLog)")
    public void logPointcut(){}


}
