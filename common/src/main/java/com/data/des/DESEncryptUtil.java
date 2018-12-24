package com.data.des;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;

/**
 * @author : ganjiaxin
 * create at:  2018/12/19  12:28 PM
 * @description:
 */
public class DESEncryptUtil {

    /**
     * 创建密钥
     *
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static Key createKey() throws NoSuchAlgorithmException {
        Security.insertProviderAt(new com.sun.crypto.provider.SunJCE(), 1);
        KeyGenerator generator = KeyGenerator.getInstance("DES");
        generator.init(new SecureRandom());
        Key key = generator.generateKey();
        return key;
    }

    /**
     * 获取密钥
     *
     * @param is
     * @return
     */
    public static Key getKey(InputStream is) {
        try {
            ObjectInputStream ois = new ObjectInputStream(is);
            return (Key) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 根据密钥解密
     *
     * @param key
     * @param in
     * @return
     */
    public static InputStream doDecrypt(Key key, InputStream in) {
        try {
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            byte[] tmpbuf = new byte[1024];
            int count = 0;
            while ((count = in.read(tmpbuf)) != -1) {
                bout.write(tmpbuf, 0, count);
                tmpbuf = new byte[1024];
            }
            in.close();
            byte[] orgData = bout.toByteArray();
            byte[] raw = cipher.doFinal(orgData);
            ByteArrayInputStream bin = new ByteArrayInputStream(raw);
            return bin;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
