package com.zero.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zero
 * @date 2020/8/25-15:28
 */
public class StringCommonUtils extends StringUtils {


    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 规则 第一个是key,第二个是value 内推
     *
     * @param strs
     * @return
     */
    public static Map StringsToMap(String... strs) {
        Map<String, String> map = new HashMap<>();
        if ((strs == null)) return null;
        if (!(strs.length % 2 == 0)) throw new RuntimeException("不符合规则");
        for (int i = 0; i < strs.length; i = i + 2) {
            map.put(strs[i], strs[i + 1]);
        }
        return map;
    }

    public static void main(String[] args) {
//        boolean b = StringCommonUtils.isEmpty(null);
//        System.out.println(b);

        Map<String, String> map = StringsToMap("sex","1","name","22");
        System.out.println(map.toString());
    }
}
