package com.gxcata.questionnaireinvestigation.common.web.domain;


import java.util.HashMap;

/**
 * 错误码枚举
 * 1 ~ 9999 前端可以显示在页面
 * 10001 以上   前端不可以显示在页面
 *
 * @author wanghailun
 */
public enum ErrorCodeEnum {
    SUCCESS(200, "请求成功"),
    ERROR(500, "服务器异常，请联系管理员"),
    ERROR_501(501, "服务器繁忙，请稍后再试"),
    ERROR_502(502, "权限不足，无法访问"),
    ERROR_503(503, "账号或密码错误"),
    ERROR_REPEAT(504, "数据重复"),
    INFO_USER_MISS(1001, "获取用户信息失败，请重新登录"),
    ERROR_PARAM(500, "参数错误"),
    ERROR_PARAM_TYPE(500, "参数类型错误"),
    ERROR_ADD(10002, "添加错误"),
    ERROR_UPDATE(10003, "修改错误"),
    ERROR_DELETE(10004, "删除错误"),
    ERROR_NULL_PARAM(503, "参数不全"),
    ERROR_NOT_EXIST(10005, "信息不存在"),
    ERROR_TOKEN(10006, "token格式非法或已失效"),
    ERROR_TOKEN_MISS(10007, "token缺失"),
    ERROR_DATABASE(11001, "数据库操作失败"),
    ERROR_CODE_DATA_HAVEUSER(505, "数据已被使用"),
    ERROR_DATA_REPEAT(12001, "数据重复"),
    ERROR_UNTREATED(505, "有待审核未处理"),
    ERROR_PRODUCT_TYPE_HAS_CHILD(506, "含有子类目"),
    ERROR_PRODUCT_TYPE_HAS_PRODUCT(507, "类目包含产品"),
    ERROR_REVIEW_FAIL(508, "审核失败"),
    ERROR_REVIEW_DATA_LACK(509, "审核数据缺失"),
    ERROR_SMS_TEMPLATE_LOSE(510, "未找到短信模板"),
    ERROR_SMS_SEND(511, "短信发送失败"),
    ERROR_SMS_CODE_V_DISABLE(512, "验证码已过期"),
    ERROR_SMS_CODE_V_ERROR(513, "验证码错误"),
    ERROR_SMS_CODE_SAVE(514, "验证码缓存异常"),
    ERROR_COMPANY_LACK(515, "公司信息查询失败"),
    ERROR_BONUS_COIN_INSUFFICIENT(516, "钢镚不足"),
    ERROR_BALANCE_INSUFFICIENT(517, "余额不足"),
    ID_BUILD_FAILED(518, "ID生成失败"),
    ERROR_SERVICE(519, "服务调用失败"),
    ERROR_ORDER_STATUS(520, "数据状态已更新，无法执行此操作"),
    ERROR_UPDATE_RULE(521, "调价规则获取失败"),
    ERROR_UPDATE_PRICE_EXCEED(522, "超出调价范围"),
    ERROR_UPDATE_PRICE_RECKON(523, "钢镚计算出错"),
    ERROR_USER_MESSAGE(524, "用户信息有误"),
    ERROR_PAY_OUT_TYPE(525, "支付方式有误"),
    ERROR_USER_ACCOUNT_UPDATE(526, "用户账户更新失败"),
    ERROR_USER_ACCOUNT_QUERY(527, "用户账户获取失败"),
    ERROR_BONUS_COIN_LOCKING(528, "钢镚锁定失败"),
    ERROR_PAY_APPLY(529, "支付申请出错"),
    ERROR_CASH_OUT(530, "提现申请出错"),
    ERROR_BARGAINING_MAX(531, "议价设置最大量，无法增加"),
    ERROR_BARGAINING_MIN(532, "议价设置至少保留一条"),
    ERROR_ACCOUNT_BALANCE_NOT_SUPPLIES(533, "账户余额不足"),
    ERROR_COEFFICIENT_HAS_PRODUCT(534, "包含产品信息，不能删除"),
    ERROR_REFUND_DEPOSIT_COST(535, "退定金出错"),
    ERROR_REPLACE_SURETY_COST(536, "退代付保证金出错"),
    ERROR_SURETY_COST(537, "退保证金出错"),
    ERROR_GOODS_COST(538, "退货款出错"),
    ERROR_QUOTE_PRICE_OUT(539,"报价价格超过系统设置价格"),
    ERROR_QUOTE_PRICE(540,"报价失败"),
    ERROR_BACK(541, "无银行信息"),
    ERROR_COMPANY_DELETE(542, "个人公司无法删除"),
    ERROR_CONTRACT_ORDER_NO_MATE(543, "订单与合同不匹配"),
    ERROR_CONTRACT_FLOAT_OUT(544, "合同金额或数量超出浮动比例"),
    ERROR_ORDER_HAS_CONTRACT(545, "订单已签订合同"),
    ERROR_CONTRACT_STATUS(546, "合同状态非执行中"),
    ERROR_WORKFLOW_CALLBACK(547, "流程召回失败"),
    ERROR_NAME_MISMATCH(548,"名字不匹配"),
    ERROR_ID_CARD_MISMATCH(549,"身份证号码不匹配"),
    ERROR_START_TIME(550,"签发日期不匹配"),
    ERROR_END_TIME(551,"失效日期不匹配"),
    ERROR_ID(552,"ID有误"),
    THE_PICTURE_IS_NOT_CLEAR(553,"图片不够清晰，请重新拍照"),
    FILE_CREATION_FAILED(554,"文件夹创建失败"),
    COMPANY_AND_USER_DO_NOT_MATCH(555,"公司和用户不匹配"),
    ERROR_DEPRECATED(556,"调用已作废的方法"),
    ERROR_CONFIGURATION(557,"系统配置不正确"),
    ERROR_HANDLED(558,"已处理"),
    ;


    private int val;
    private String des;

    public int getVal() {
        return val;
    }

    public String getDes() {
        return des;
    }

    ErrorCodeEnum(int value, String des) {
        this.val = value;
        this.des = des;
    }

    /**
     * 返回错误码和错误信息
     *
     * @param errorCodeEnum
     * @return
     */
    public static Result returnError(com.gxcata.questionnaireinvestigation.common.web.domain.ErrorCodeEnum errorCodeEnum) {
        return Result.error(errorCodeEnum.getVal(), errorCodeEnum.getDes());
    }

    /**
     * 返回错误码和错误信息
     *
     * @param errorCodeEnum
     * @return
     */
    public static Result returnError(com.gxcata.questionnaireinvestigation.common.web.domain.ErrorCodeEnum errorCodeEnum, String errorInfo) {
        return Result.error(errorCodeEnum.getVal(), errorInfo);
    }


    /**
     * 枚举类型转HashMap
     *
     * @return
     */
    public static HashMap<Integer, String> getHashMap() {
        HashMap<Integer, String> result = new HashMap<>();

        for (ErrorCodeEnum typeEnum : ErrorCodeEnum.values()) {
            result.put(typeEnum.getVal(), typeEnum.getDes());
        }
        return result;
    }


}
