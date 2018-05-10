package com.peace.test;

import com.peace.util.RsaUtil;
import org.apache.commons.codec.binary.Base64;

import java.util.Arrays;
import java.util.Map;


public class RsaTest {


    public static void main(String[] args) throws Exception {
        Map<String, Object> keyMap = RsaUtil.initKey();
        //公钥
        byte[] publicKey = RsaUtil.getPublicKey(keyMap);

        //私钥
        byte[] privateKey = RsaUtil.getPrivateKey(keyMap);
        System.out.println("公钥：/n" + Base64.encodeBase64String(publicKey));

        System.out.println("公钥码：/n" + Arrays.toString(publicKey));
        System.out.println("私钥：/n" + Base64.encodeBase64String(privateKey));
        System.out.println("私钥码：/n" + Arrays.toString(privateKey));


        System.out.println("================密钥对构造完毕,甲方将公钥公布给乙方，开始进行加密数据的传输=============");
        String str = "RSA密码交换算法";
        System.out.println("/n===========甲方向乙方发送加密数据==============");
        System.out.println("原文:" + str);
        //甲方进行数据的加密
        byte[] code1 = RsaUtil.encryptByPrivateKey(str.getBytes(), privateKey);
        System.out.println("加密后的数据：" + Base64.encodeBase64String(code1));
        System.out.println("===========乙方使用甲方提供的公钥对数据进行解密==============");
        //乙方进行数据的解密
        byte[] decode1 = RsaUtil.decryptByPublicKey(code1, publicKey);

        System.out.println("乙方解密后的数据：" + new String(decode1) + "/n/n");

        System.out.println("===========反向进行操作，乙方向甲方发送数据==============/n/n");

        str = "乙方向甲方发送数据RSA算法";

        System.out.println("原文:" + str);

        //乙方使用公钥对数据进行加密
        byte[] code2 = RsaUtil.encryptByPublicKey(str.getBytes(), publicKey);
        System.out.println("===========乙方使用公钥对数据进行加密==============");
        System.out.println("加密后的数据：" + Base64.encodeBase64String(code2));

        System.out.println("=============乙方将数据传送给甲方======================");
        System.out.println("===========甲方使用私钥对数据进行解密==============");

        //甲方使用私钥对数据进行解密
        byte[] decode2 = RsaUtil.decryptByPrivateKey(code2, privateKey);

        System.out.println("甲方解密后的数据：" + new String(decode2));
    }
}
