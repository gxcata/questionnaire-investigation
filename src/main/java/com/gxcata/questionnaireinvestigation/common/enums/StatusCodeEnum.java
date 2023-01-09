package com.gxcata.questionnaireinvestigation.common.enums;

import java.util.HashMap;

/**
 * @author wanghailun
 * @date 2022年11月18日 12:21
 */
public enum StatusCodeEnum {
    /**
     *状态类型
     */
    ENABLE("10000401","启用"),
    DEACTIVATE("10000402","停用"),
    ;
    public String val;
    public String des;

    StatusCodeEnum(String val, String des) {
        this.val = val;
        this.des = des;
    }

    public String getVal() {
        return val;
    }

    public String getDes() {
        return des;
    }

    /**
     * 通过code获取中文名
     */
    public static String getDesByCode(String code) {

        for (StatusCodeEnum typeEnum : StatusCodeEnum.values()) {
            if (typeEnum.getVal().equals(code)) {
                return typeEnum.getDes();
            }
        }

        return "";
    }

    /**
     * 枚举类型转HashMap
     */
    public static HashMap<String, String> StatusEnum() {
        HashMap<String, String> result = new HashMap<>();

        StatusCodeEnum[] values = StatusCodeEnum.values();
        for (StatusCodeEnum status : values) {
            result.put(status.getVal(), status.getDes());
        }
        return result;
    }
}
