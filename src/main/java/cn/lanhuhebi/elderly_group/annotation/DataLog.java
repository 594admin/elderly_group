package cn.lanhuhebi.elderly_group.annotation;

import cn.lanhuhebi.elderly_group.enums.BusinessType;

import java.lang.annotation.*;

/**
 * @author dxq
 * @date 2019-08-20 - 17:21
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataLog {

    /**
     * 功能
     */
    BusinessType businessType() default BusinessType.OTHER;

    /**
     * 描述
     */
    String desc() default "";

}
