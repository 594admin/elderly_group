package cn.lanhuhebi.elderly_group.webservice.utils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author dxq
 * @date 2019-08-29 - 16:04
 */
public class AesUtils {

    //	public static void main(String[] args) throws InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchPaddingException {
//		// TODO Auto-generated method stub
//		String content="hello,world!";
//		 String key="chinashanghaijky";
//		 byte[] encrypted=AES_CBC_Encrypt(content.getBytes(), key);
//		 System.out.println(encrypted);
//		 String jiami16 = bytesToHexString(encrypted);
//		System.out.println(jiami16);
//		String s = new String(decryptAES(encrypted, "chinashanghaijky".getBytes("utf-8")));
//		System.out.println(s);
//	}

    public static byte[] decryptAES(byte[] content, byte[] key)
            throws UnsupportedEncodingException, IllegalBlockSizeException,
            BadPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchPaddingException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec ivps=new IvParameterSpec(key);
        SecretKeySpec sKey = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.DECRYPT_MODE , sKey,ivps);
        return cipher.doFinal(content);
    }

    public static byte[] AES_CBC_Encrypt(byte[] content, String keyBytes){
        try{
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] raw = keyBytes.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            IvParameterSpec iv = new IvParameterSpec(keyBytes.getBytes("utf-8"));//使用CBC模式，需要一个向量iv，可增加加密算法的强度
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
            byte[] encrypted = cipher.doFinal(content);

            //return new BASE64Encoder().encode(encrypted).getBytes("UTF-8");//此处使用BASE64做转码。
            return encrypted;
        }catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("exception:"+e.toString());
        }
        return null;
    }

    public static String bytesToHexString(byte[] src){
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        byte[] bytes = AES_CBC_Encrypt("hello,world!".getBytes(), "chinashanghaijky");
        for (int i = 0; i < bytes.length ;i ++){
            System.out.print(bytes[i]+",");
        }
        System.out.println();
        String s = bytesToHexString(bytes);
        System.out.println(s);

    }


}
