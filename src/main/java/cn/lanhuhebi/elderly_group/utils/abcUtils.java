package cn.lanhuhebi.elderly_group.utils;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @author dxq
 * @date 2019-08-13 - 22:56
 */
public class abcUtils {

    public static String getMD5Str(String str){
        String hashName = "md5";
        return new SimpleHash(hashName, str, null, 2).toString();
    }
}
