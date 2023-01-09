package com.gxcata.questionnaireinvestigation.common.enums;

import java.util.HashMap;

/**
 * @author wanghailun
 * @date 2022年11月18日 12:21
 */
public enum CompanyNatureEnum {
    /**
     *公司性质
     */
    GOVERNMENT_SECTOR("10000101","政府部门"),
    STATE_OWNED_ENTERPRISES("10000102","国资企业"),
    SCIENTIFIC_RESEARCH_INSTITUTION("10000103","科研机构"),
    MEDICAL_INSTITUTION("10000104","医疗机构"),
    FINANCIAL_INSTITUTION("10000105","金融机构"),
    AUTHORITY("10000106","权力机构"),
    PRIVATE_ENTERPRISE("10000107","民营企业"),
    OTHER_CUSTOMERS("10000108","其他客户"),
    ;

    public String val;
    public String des;

    CompanyNatureEnum(String val, String des) {
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

        for (CompanyNatureEnum typeEnum : CompanyNatureEnum.values()) {
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

        CompanyNatureEnum[] values = CompanyNatureEnum.values();
        for (CompanyNatureEnum status : values) {
            result.put(status.getVal(), status.getDes());
        }
        return result;
    }
}
