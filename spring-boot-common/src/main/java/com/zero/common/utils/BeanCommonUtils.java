package com.zero.common.utils;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author zero
 * @date 2020/8/25-15:43
 */
public class BeanCommonUtils {
    public  static <T> T clone(Object source, Class<T> clazz){
        T target = null;
        Constructor con = null;
        try {
            con = clazz.getConstructor();
            target = (T) con.newInstance();
            BeanUtils.copyProperties(source,target);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return target;
    }

    public static void main(String[] args) {

    }
}
