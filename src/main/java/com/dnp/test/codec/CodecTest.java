package com.dnp.test.codec;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

/**
 * @author huazai
 * @description codec工具类测试, 感觉我编解码用的不多。
 * @date 2020/4/10
 */
public class CodecTest {

    @Test
    public void digestUtilsTest() {
        String xx = DigestUtils.md5Hex("123456".getBytes());
        System.out.println("xx = " + xx);

        byte[] md5Digest = DigestUtils.digest(DigestUtils.getMd5Digest(), "123546".getBytes());
        System.out.println("md5Digest = " + Hex.encodeHexString(md5Digest));

    }
}
