package cn.lanhuhebi.elderly_group.webservice.utils;

import java.util.UUID;

/**
 * @author dxq
 * @date 2019-09-02 - 12:08
 */
public class SequenceUtils {

    public static final String KEY = "chinashanghaijky";

    public static final String ORGID = "01000A001";

    public static final String CODE = "8948112EFF8F43A5";

    private static String UUID;

    public static byte[] sequence(){
        UUID = new UuidUtil().get32UUID();
        return AesUtils.AES_CBC_Encrypt(UUID.getBytes(), KEY);
    }

    public static byte[] md5(){
        String CodeID = CODE + UUID;
        return AesUtils.AES_CBC_Encrypt(MD5.md5(CodeID).getBytes(), KEY);
    }

}
