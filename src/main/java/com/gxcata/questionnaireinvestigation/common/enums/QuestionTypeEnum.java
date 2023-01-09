package com.gxcata.questionnaireinvestigation.common.enums;

import java.util.HashMap;

/**
 * @author wanghailun
 * @date 2022年12月31日 10:42
 */

public enum QuestionTypeEnum {

    /**
     * 问题类型
     */
    MULTIPLE_CHOICE("10000201","多选"),
    SINGLE_CHOICE("10000202","单选"),
    QUESTION_AND_ANSWERS("10000203","问答"),
    ;

    public String val;
    public String des;

    QuestionTypeEnum(String val, String des) {
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

        for (QuestionTypeEnum typeEnum : QuestionTypeEnum.values()) {
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

        QuestionTypeEnum[] values = QuestionTypeEnum.values();
        for (QuestionTypeEnum status : values) {
            result.put(status.getVal(), status.getDes());
        }
        return result;
    }
}
