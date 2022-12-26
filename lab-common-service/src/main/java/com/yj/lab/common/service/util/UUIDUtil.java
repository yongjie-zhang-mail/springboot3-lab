package com.yj.lab.common.service.util;

import java.util.UUID;

/**
 * 获取UUID工具类
 */
public class UUIDUtil {
    /**
     * 获取字符串UUID（除掉"-"）
     *
     * @return
     */
    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-", "");
        return uuid;
    }
}
