package com.dnp.test.validator;

import org.apache.commons.validator.GenericTypeValidator;
import org.apache.commons.validator.util.ValidatorUtils;
import org.junit.Test;

/**
 * @author huazai
 * @description 验证测试
 * @date 2020/4/10
 */
public class ValidatorTest {

    @Test
    public void validatorTest() {
        Integer xx = GenericTypeValidator.formatInt("11313215");
        System.out.println("xx = " + xx);
    }
}
