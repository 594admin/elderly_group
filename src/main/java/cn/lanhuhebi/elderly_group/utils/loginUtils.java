package cn.lanhuhebi.elderly_group.utils;

import cn.lanhuhebi.elderly_group.common.constant.UserConstant;

/**
 * @author dxq
 * @date 2019-08-13 - 21:50
 */
public class loginUtils {

    public static boolean maybeEmail(String username) {
        if (!username.matches(UserConstant.EMAIL_PATTERN)) {
            return false;
        }
        return true;
    }

    public static boolean maybeMobilePhoneNumber(String username) {
        if (!username.matches(UserConstant.MOBILE_PHONE_NUMBER_PATTERN)) {
            return false;
        }
        return true;
    }
}
