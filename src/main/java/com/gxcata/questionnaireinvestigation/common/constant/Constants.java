package com.gxcata.questionnaireinvestigation.common.constant;

import java.math.BigDecimal;

/**
 * 通用常量信息
 *
 * @author gxcata
 */
public class Constants {
    /**
     * UTF-8 字符集
     */
    public static final String UTF8 = "UTF-8";

    /**
     * GBK 字符集
     */
    public static final String GBK = "GBK";

    /**
     * http请求
     */
    public static final String HTTP = "http://";

    /**
     * https请求
     */
    public static final String HTTPS = "https://";

    /**
     * 成功标记
     */
    public static final Integer SUCCESS = 200;

    /**
     * 失败标记
     */
    public static final Integer FAIL = 500;

    /**
     * 登录成功
     */
    public static final String LOGIN_SUCCESS = "Success";

    /**
     * 注销
     */
    public static final String LOGOUT = "Logout";

    /**
     * 注册
     */
    public static final String REGISTER = "Register";

    /**
     * 登录失败
     */
    public static final String LOGIN_FAIL = "Error";

    /**
     * 当前记录起始索引
     */
    public static final String PAGE_NUM = "pageNum";

    /**
     * 每页显示记录数
     */
    public static final String PAGE_SIZE = "pageSize";

    /**
     * 排序列
     */
    public static final String ORDER_BY_COLUMN = "orderByColumn";

    /**
     * 排序的方向 "desc" 或者 "asc".
     */
    public static final String IS_ASC = "isAsc";

    /**
     * 验证码 redis key
     */
    public static final String CAPTCHA_CODE_KEY = "captcha_codes:";

    /**
     * 验证码有效期（分钟）
     */
    public static final long CAPTCHA_EXPIRATION = 2;

    /**
     * 令牌有效期（小时）
     */
    public final static long TOKEN_EXPIRE = 120;

    /**
     * 参数管理 cache key
     */
    public static final String SYS_CONFIG_KEY = "sys_config:";

    /**
     * 字典管理 cache key
     */
    public static final String SYS_DICT_KEY = "sys_dict:";

    /**
     * ID生成 cache key
     */
    public static final String PUBLIC_ID_KEY = "public:id:";

    /**
     * 资源映射路径 前缀
     */
    public static final String RESOURCE_PREFIX = "/profile";

    /**
     * 验证码最小值
     */
    public static final int CODE_MIN = 100000;

    /**
     * 验证码最大值
     */
    public static final int CODE_MAX = 999999;

    /**
     * 短信redis的key规则
     */
    public static final String REDIS_SMS = "system:sms_%s_%s";

    /**
     * 产品类目的key规则
     */
    public static final String REDIS_PRODUCT_TYPE = "ruler:product_type";

    /**
     * app redis的key规则
     **/
    public static final String REDIS_APP_CONFIG = "app:config";

    /**
     * 订单厂家习惯
     **/
    public static final String Factory_user_habit = "order:factory:";

    /**
     * 默认议价可设置数量
     */
    public static final Integer BARGAINING = 4;

    /**
     * 默认支付时长 min
     */
    public static final Integer DEFAULT_TIME_SPACE = 30;
    /**
     * 全部产品的key规则
     */
    public static final String REDIS_PRODUCT_ALL = "ruler:product_all";

    public static final Integer ONE = 1;

    /**
     * 数据库中布尔值表示值
     */
    public static final Integer MYSQL_TRUE = 1;
    public static final Integer MYSQL_FALSE = 0;

    /**
     * 退款延时任务时间
     */
    public static final Long REFUND_SECOND = 3L;

    /**
     * 既定支付比例
     */
    public static final BigDecimal BASE_RATIO = new BigDecimal("0.85");
    /**
     * 既定浮动金额
     */
    public static final BigDecimal BASE_FLOAT = new BigDecimal("0");

    /**
     * 自动报价设置：车辆最大装载货物种类
     */
    public static final Integer CAR_MAX_PRODUCT_NUM = 3;

    /**
     * 自动报价设置：车辆最大装载货物种类
     */
    public static final BigDecimal CAR_MAX_LOAD = new BigDecimal(35);

    /**
     * 订单分享的最大好友数的key
     */
    public static final String ORDER_SHARE_MAX_USER_NUMBER_KEY = "order_share_max_user_number";

    /**
     * 包到订单卸货后n天自动确认收货的n
     */
    public static final String ORDER_AUTO_CONFIRM_RECEIVING_DAYS = "order_auto_confirm_receiving_days";

    /**
     * LINE
     */
    public static final String LINE = "-";
}
