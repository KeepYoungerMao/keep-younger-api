package com.mao.util;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * 加密工具类：BASE64（包含解压）、MD5、SHA
 * @author mao by 11:26 2019/8/30
 */
public class EncryptUtil {

    /**
     * MD5算法类型
     */
    private static final String KEY_MD5 = "MD5";

    /**
     * SHA-1算法类型
     */
    private static final String KEY_SHA = "SHA";

    /**
     * BASE64加密：严格来说属于编码格式，并非加密算法。
     * 加密后产生的字节数是8的倍数，如果不够位数以“=”符号补充。
     * 常用于邮件，HTTP加密，截取HTTP信息
     * @param key byte[]
     * @return String
     */
    public static String BASE64Encode(byte[] key){
        return Base64.getEncoder().encodeToString(key);
    }

    /**
     * BASE64加密：传String
     * @param key String
     * @return String
     */
    public static String BASE64Encode(String key){
        return Base64.getEncoder().encodeToString(key.getBytes());
    }

    /**
     * BASE64解密
     * @param key String
     * @return byte[]
     */
    public static byte[] BASE64Decode(String key){
        byte[] bytes = new byte[0];
        try {
            bytes = Base64.getDecoder().decode(key);
        }catch (Exception e){
            e.printStackTrace();
        }
        return bytes;
    }

    /**
     * byte[]转String
     * @param bytes byte[]
     * @return String
     */
    public static String byteToString(byte[] bytes){
        return new String(bytes, StandardCharsets.UTF_8);
    }

    /**
     * MD5加密：Message-Digest Algorithm(信息摘要算法)
     * 单向加密；生成固定长度加密值（十六进制字符串）
     * MD5加密的特点：
     * 1.压缩性：任意长度的数据，算出的MD5值长度是固定的；
     * 2.易计算：从原始数据计算出MD5值很容易；
     * 3.抗修改性：原始数据作出任意改动，得出的MD5值的差别很大；
     * 4.弱抗碰撞：已知原始数据和MD5值，找到一个具有相同MD5值得数据是非常困难的；
     * 5.强抗碰撞：找2个不同的原始数据，使它们具有相同的MD5值是非常困难的；
     * @param str str
     */
    public static String MD5(String str){
        //md5
        return encrypt(str,KEY_MD5);
    }

    /**
     * SHA加密：Secure Hash Algorithm（安全散列算法）
     * SHA算法被广泛应用到电子商务信息安全领域，虽然SHA和MD5都通过碰撞法破解了，
     * 但SHA任然是公认的安全加密算法，较MD5更安全。
     * SHA-1与MD5的区别：
     * 1.二者都由MD4导出，二者很类似。因此二者的强度和其它特性都很类似。
     * 2.SHA-1的摘要长度要比MD5长32位，使用强行技术，产生任何一个报文要等于给定报文摘要的难度对
     *   MD5是2^128数量级的操作，而对SHA-1是2^160数量级的操作，因此对SHA-1强行攻击的难度更大。
     * 3.相同硬件上，SHA-1的运算速度比MD5慢。
     * @param str String
     * @return String
     */
    public static String SHA(String str){
        //sha1 as same
        return encrypt(str,KEY_SHA);
    }

    /**
     * 加密方法：MD5和SHA加密方法相同，MessageDigest类中已分配好
     * 此方法得到的是一个 <= 32的字符串（极少部分 < 32）
     * @param str String
     * @param type 加密类型
     * @return String
     */
    private static String encrypt(String str, String type){
        byte[] bytes = new byte[0];
        try{
            bytes = MessageDigest.getInstance(type).digest(str.getBytes());
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return new BigInteger(1,bytes).toString(16);
    }

}