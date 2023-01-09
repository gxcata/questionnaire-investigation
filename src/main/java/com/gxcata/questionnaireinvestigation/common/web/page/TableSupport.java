package com.gxcata.questionnaireinvestigation.common.web.page;

import com.gxcata.questionnaireinvestigation.common.utils.ServletUtils;
import com.gxcata.questionnaireinvestigation.common.web.controller.PageDomain;

/**
 * 表格数据处理
 * 
 * @author gxcata
 */
public class TableSupport
{
    /**
     * 当前记录起始索引
     */
    public static final String PAGE_NUM = "pageNum";

    /**
     * 每页显示记录数
     */
    public static final String PAGE_SIZE = "pageSize";

    public static final  String DEFAULT_CODE= "defaultCode";

    /**
     * 排序列
     */
    public static final String ORDER_BY_COLUMN = "orderByColumn";

    /**
     * 排序的方向 "desc" 或者 "asc".
     */
    public static final String IS_ASC = "isAsc";

    /**
     * 封装分页对象
     */
    public static PageDomain getPageDomain()
    {
        PageDomain pageDomain = new PageDomain();
        pageDomain.setPageNum(ServletUtils.getParameterToInt(PAGE_NUM));
        pageDomain.setPageSize(ServletUtils.getParameterToInt(PAGE_SIZE));
        pageDomain.setDefaultCode(ServletUtils.getParameter(DEFAULT_CODE));
//        pageDomain.setOrderBy(ServletUtils.getParameter(ORDER_BY_COLUMN));
//        pageDomain.setIsAsc(ServletUtils.getParameter(IS_ASC));
        return pageDomain;
    }

    public static PageDomain buildPageRequest()
    {
        return getPageDomain();
    }
}
