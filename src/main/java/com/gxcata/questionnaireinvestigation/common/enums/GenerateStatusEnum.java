package com.gxcata.questionnaireinvestigation.common.enums;

import java.util.HashMap;

/**
 * @author wanghailun
 * @date 2022年12月31日 10:42
 */

public enum GenerateStatusEnum {

    /**
     * 生成状态
     */
    GENERATED("10000301","已生成"),
    NOT_GENERATED("10000302","未生成"),
    ;

    public String val;
    public String des;

    GenerateStatusEnum(String val, String des) {
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

        for (GenerateStatusEnum typeEnum : GenerateStatusEnum.values()) {
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

        GenerateStatusEnum[] values = GenerateStatusEnum.values();
        for (GenerateStatusEnum status : values) {
            result.put(status.getVal(), status.getDes());
        }
        return result;
    }
}
