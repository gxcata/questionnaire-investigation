package com.gxcata.questionnaireinvestigation.common.web.page;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxcata.questionnaireinvestigation.common.app.AppConfig;
import com.gxcata.questionnaireinvestigation.common.constant.Constants;
import com.gxcata.questionnaireinvestigation.common.utils.DateUtils;
import com.gxcata.questionnaireinvestigation.common.utils.StringUtils;
import com.gxcata.questionnaireinvestigation.common.web.controller.PageDomain;
import com.gxcata.questionnaireinvestigation.common.web.domain.AjaxResult;
import com.gxcata.questionnaireinvestigation.common.web.domain.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.annotation.Resource;
import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * web层通用数据处理
 *
 * @author gxcata
 */
public class BaseController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    RedisTemplate redisTemplate;

    /**
     * 将前台传递过来的日期格式的字符串，自动转化为Date类型
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(DateUtils.parseDate(text));
            }
        });
    }

    /**
     * 设置请求分页数据
     */
    protected void startPage() {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        String defaultCode = pageDomain.getDefaultCode();

        if (pageDomain.getDefaultCode() != null && !pageDomain.getDefaultCode().equals("")) {
            Object object = redisTemplate.opsForValue().get(Constants.REDIS_APP_CONFIG+":"+pageDomain.getDefaultCode());

            if (object != null) {
                AppConfig appConfig = (AppConfig) object;
                pageSize = (Integer.valueOf(appConfig.getValue()));
                if(pageNum==null){
                    pageNum = 1;
                }
            }
        }
        if (StringUtils.isNotNull(pageNum) && StringUtils.isNotNull(pageSize)) {
//            String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
//            String orderBy = pageDomain
            PageHelper.startPage(pageNum, pageSize);
        }
    }


    protected void startPage(Integer pageNum,Integer pageSize,String defaultCode) {
        if (defaultCode != null && !defaultCode.equals("")) {
            Object object = redisTemplate.opsForValue().get(Constants.REDIS_APP_CONFIG+":"+defaultCode);

            if (object != null) {
                AppConfig appConfig = (AppConfig) object;
                pageSize = (Integer.valueOf(appConfig.getValue()));

                if(pageNum==null){
                    pageNum = 1;
                }
            }
        }
        if (StringUtils.isNotNull(pageNum) && StringUtils.isNotNull(pageSize)) {
//            String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
//            String orderBy = pageDomain
            PageHelper.startPage(pageNum, pageSize);
        }
    }

    /**
     * 响应请求分页数据
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    protected Result getDataTable(List<?> list) {
        PageInfo<?> pageInfo = new PageInfo<>(list);
        return Result.ok(list, pageInfo);
    }


    protected Result listToPage(List<?> objectList, Integer pageNum, Integer pageSize) {

        com.gxcata.questionnaireinvestigation.common.web.domain.PageInfo pageInfo = new com.gxcata.questionnaireinvestigation.common.web.domain.PageInfo();
        //如果列表不为空
        if (objectList!=null&&objectList.size()>0) {
            //页数不对或者页数大小不对
            if(pageNum==null||pageSize==null){
                pageInfo.setPageSize(objectList.size());
                pageInfo.setCurrPage(1);
                pageInfo.setPageSize(objectList.size());
                pageInfo.setTotalCount(objectList.size());
                return Result.ok(objectList,pageInfo);
            }
            if(pageNum<=0||pageSize<=0){
                pageInfo.setPageSize(objectList.size());
                pageInfo.setCurrPage(1);
                pageInfo.setPageSize(objectList.size());
                pageInfo.setTotalCount(objectList.size());

                return Result.ok(objectList,pageInfo);
            }

            // 总记录数
            Integer totalCount = objectList.size();
            //总页数
            Integer totalPage = totalCount/pageSize;
            // 开始索引
            int fromIndex = (pageNum - 1) * pageSize;;
            // 结束索引
            int endIndex = 0;

            //分页起始索引fromIndex不能大于结果集总记录数
            if(totalCount >= fromIndex) {
                endIndex = fromIndex + pageSize;
                //最后一条记录的索引大于总记录数
                if (endIndex > totalCount) {
                    //结束索引为集合的最后一个元素索引
                    endIndex = totalCount;
                }
                pageInfo.setTotalCount(totalCount);
                pageInfo.setTotalPage(totalPage);
                pageInfo.setCurrPage(pageNum);
                pageInfo.setPageSize(pageSize);
                return Result.ok(objectList.subList(fromIndex, endIndex),pageInfo);
            }else{
                pageInfo.setPageSize(objectList.size());
                pageInfo.setCurrPage(1);
                pageInfo.setPageSize(objectList.size());
                pageInfo.setTotalCount(objectList.size());
                return Result.ok(new ArrayList<>(),pageInfo);
            }
        }
        pageInfo.setPageSize(0);
        pageInfo.setCurrPage(1);
        pageInfo.setPageSize(0);
        pageInfo.setTotalCount(0);
        return Result.ok(new ArrayList<>(),pageInfo);
    }

    /**
     * 响应返回结果
     *
     * @param rows 影响行数
     * @return 操作结果
     */
    protected AjaxResult toAjax(int rows) {
        return rows > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    /**
     * 响应返回结果
     *
     * @param result 结果
     * @return 操作结果
     */
    protected AjaxResult toAjax(boolean result) {
        return result ? success() : error();
    }

    /**
     * 返回成功
     */
    public AjaxResult success() {
        return AjaxResult.success();
    }

    /**
     * 返回失败消息
     */
    public AjaxResult error() {
        return AjaxResult.error();
    }

    /**
     * 返回成功消息
     */
    public AjaxResult success(String message) {
        return AjaxResult.success(message);
    }

    /**
     * 返回失败消息
     */
    public AjaxResult error(String message) {
        return AjaxResult.error(message);
    }
}
