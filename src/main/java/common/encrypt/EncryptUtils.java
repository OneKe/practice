package common.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class EncryptUtils {
    public static final String DES = "DES";
    public static final String AES = "AES";
    public static final String SHA1 = "SHA1";
    public static final String MD5 = "MD5";

    public static String encrypt(String info, String sign) throws NoSuchAlgorithmException {
        byte[] digest = null;
        //得到一个MD5的消息摘要
        MessageDigest md = MessageDigest.getInstance(sign);
        //添加要进行计算摘要的信息
        md.update(info.getBytes());
        //得到该摘要
        digest = md.digest();
        return byte2hex(digest).toLowerCase();  //将摘要转为字符串
    }

    /**
     * 二进制转化为16进制字符串
     *
     * @param b
     * @return
     */
    public static String byte2hex(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String s;
        for (byte value : b) {
            s = Integer.toHexString(value & 0XFF);
            if (s.length() == 1) {
                hs.append("0").append(s);
            } else {
                hs.append(s);
            }
        }
        return hs.toString();
    }

    /**
     * key 排序后 SHA1加密
     */
    public static String getFinalUrl(Map<String, Object> params, String url) {
        Random rand = new Random();
        int nonce = rand.nextInt(Integer.MAX_VALUE);
        long second = Instant.now().getEpochSecond();
        Map<String, Object> treeMap = new TreeMap<>(params);
        treeMap.put("nonce", nonce);
        treeMap.put("timestamp", second);
        StringBuilder builder = new StringBuilder(url);
        builder.append("?nonce=").append(nonce).append("&timestamp=").append(second);
        String sign = null;
        String origin = treeMap.entrySet().stream()
                .map(e -> String.join("=", e.getKey(), e.getValue().toString()))
                .collect(Collectors.joining("&"));
        try {
            sign = encrypt(origin, SHA1);
        } catch (NoSuchAlgorithmException e) {
            // process error
        }
        if (sign != null) {
            sign = sign.toUpperCase();
            builder.append("&sign=").append(sign);
        }
        return builder.toString();
    }
}
