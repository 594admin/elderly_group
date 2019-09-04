package cn.lanhuhebi.elderly_group.util;

import java.util.Random;

/**
 * 验证码
 */
public class VerificationCode {

    //生成6位验证码
    public static String randomCode() {
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }

}
