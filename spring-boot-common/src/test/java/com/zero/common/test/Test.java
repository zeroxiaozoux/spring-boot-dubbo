package com.zero.common.test;

import com.zero.common.utils.BeanCommonUtils;
import org.springframework.beans.BeanUtils;

/**
 * @author zero
 * @date 2020/8/25-16:42
 */
public class Test {

    public static void main(String[] args) {
        A a = new A();
        a.setStr("hello");
        B b = BeanCommonUtils.clone(a,B.class);
        System.out.println(b.getStr());
    }
}
