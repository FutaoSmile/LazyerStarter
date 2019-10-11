package com.lazy.foundation.utils;

import com.lazy.constant.ErrorMessage;
import com.lazy.foundation.model.BaseEntity;
import com.lazy.rest.exception.LogicException;
import com.lazy.tools.DateTools;

import java.lang.reflect.Method;
import java.util.UUID;

/**
 * Service层工具类
 *
 * @author futao
 * Created on 2019-03-05.
 */
public class ServiceTools {

    private static final String GETTER_PREFIX = "get";
    private static final String SETTER_PREFIX = "set";
    private static final String IS_PREFIX = "is";


    /**
     * 获取一个32位的uuid
     *
     * @return
     */
    public static String get() {
        return String.valueOf(UUID.randomUUID()).replace("-", "");
    }

    /**
     * 获取getter或setter对应的字段名称
     *
     * @param method getter or setter
     * @return fieldName
     */
    public static String getFieldName(Method method) {
        String name = method.getName();
        if (name.startsWith(GETTER_PREFIX) || name.startsWith(SETTER_PREFIX)) {
            return name.substring(3, 4).toLowerCase() + name.substring(4);
        } else if (name.startsWith(IS_PREFIX)) {
            return name.substring(2, 3).toLowerCase() + name.substring(3);
        } else {
            throw LogicException.le(ErrorMessage.LogicErrorMessage.FIELD_NO_GETTER_OR_SETTER);
        }
    }

    /**
     * 检查结果是否为空，如果为空则抛出异常提示
     *
     * @param t   判断的对象
     * @param <T> 类型
     * @return
     */
    public static <T> T checkResultNullAndThrow(T t, String entityName) {
        if (t == null) {
            throw LogicException.le(String.format(ErrorMessage.LogicErrorMessage.RESULT_NULL, entityName));
        }
        return t;
    }

    /**
     * 设置创建时间与最后修改时间
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T extends BaseEntity> T setCreateAndLastModifyTimeNow(T t) {
        t.setCreateTime(DateTools.currentTimeStamp());
        t.setLastModifyTime(DateTools.currentTimeStamp());
        return t;
    }

    /**
     * 设置最后修改时间
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T extends BaseEntity> T setLastModifyTimeNow(T t) {
        t.setLastModifyTime(DateTools.currentTimeStamp());
        return t;
    }
}
