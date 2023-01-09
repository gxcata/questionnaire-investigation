package com.gxcata.questionnaireinvestigation.common.web.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 定义统一返回格式
 * @param <T>泛型
 * @author  wanghailun
 */
@Data
public class Result<T> implements Serializable {
    @ApiModelProperty(value = "状态码")
    private int code;
    @ApiModelProperty(value = "提示信息")
    private String msg;
    @ApiModelProperty(value = "分页信息,需要分页时有值")
    private PageInfo pageInfo;
    @ApiModelProperty(value = "数据内容")
    private T data;

    public boolean isSuccess() {
        return code == com.gxcata.questionnaireinvestigation.common.web.domain.ErrorCodeEnum.SUCCESS.getVal();
    }

    public Result(){
        setStatus(com.gxcata.questionnaireinvestigation.common.web.domain.ErrorCodeEnum.SUCCESS);
    }

    public Result(com.gxcata.questionnaireinvestigation.common.web.domain.ErrorCodeEnum status){
        this.setStatus(status);
    }

    public Result(int code, String msg){
        this.code = code;
        this.msg = msg;
    }


    public Result(T data) {
        setStatus(com.gxcata.questionnaireinvestigation.common.web.domain.ErrorCodeEnum.SUCCESS);
        this.data = data;
    }


    public Result(T data, PageInfo pageInfo) {
        setStatus(com.gxcata.questionnaireinvestigation.common.web.domain.ErrorCodeEnum.SUCCESS);
        this.data = data;
        this.pageInfo = pageInfo;
    }

    public Result(T data, int totalCount, int pageSize, int currPage) {
        setStatus(com.gxcata.questionnaireinvestigation.common.web.domain.ErrorCodeEnum.SUCCESS);
        this.data = data;
        this.pageInfo = new PageInfo(totalCount,pageSize,currPage);
    }


    public com.gxcata.questionnaireinvestigation.common.web.domain.Result<T> setStatus(com.gxcata.questionnaireinvestigation.common.web.domain.ErrorCodeEnum status) {
        this.code = status.getVal();
        this.msg = status.getDes();

        return this;
    }


    /**
     * 成功返回
     * @param <T>
     * @return
     */
    public static <T> com.gxcata.questionnaireinvestigation.common.web.domain.Result<T> ok() {
        com.gxcata.questionnaireinvestigation.common.web.domain.Result result = new com.gxcata.questionnaireinvestigation.common.web.domain.Result();
        return result;
    }

    /**
     * 成功返回
     * @param data
     * @param <T>
     * @return
     */
    public static <T> com.gxcata.questionnaireinvestigation.common.web.domain.Result<T> ok(T data) {
        com.gxcata.questionnaireinvestigation.common.web.domain.Result result = new com.gxcata.questionnaireinvestigation.common.web.domain.Result(data);
        return result;
    }

    /**
     * 成功返回
     * @param data
     * @param pageInfo
     * @param <T>
     * @return
     */
    public static <T> com.gxcata.questionnaireinvestigation.common.web.domain.Result<T> ok(T data, PageInfo pageInfo) {
        com.gxcata.questionnaireinvestigation.common.web.domain.Result result = new com.gxcata.questionnaireinvestigation.common.web.domain.Result(data, pageInfo);
        return result;
    }

    /**
     * 成功返回
     * @param data
     * @param pageInfo
     * @param <T>
     * @return
     */
    public static <T> com.gxcata.questionnaireinvestigation.common.web.domain.Result<T> ok(T data, com.github.pagehelper.PageInfo pageInfo) {
        com.gxcata.questionnaireinvestigation.common.web.domain.Result result = new com.gxcata.questionnaireinvestigation.common.web.domain.Result(data, (int) pageInfo.getTotal(),pageInfo.getPageSize(),pageInfo.getPageNum());
        return result;
    }


    /**
     * 成功返回
     * @param data
     * @return
     */
    public static <T> com.gxcata.questionnaireinvestigation.common.web.domain.Result<T> ok(T data, int totalCount, int pageSize, int currPage) {
        com.gxcata.questionnaireinvestigation.common.web.domain.Result result = new com.gxcata.questionnaireinvestigation.common.web.domain.Result(data, totalCount,pageSize,currPage);
        return result;
    }



    /**
     * 错误返回
     * @param <T>
     * @return
     */
    public static <T> com.gxcata.questionnaireinvestigation.common.web.domain.Result<T> error() {
        com.gxcata.questionnaireinvestigation.common.web.domain.Result result = new com.gxcata.questionnaireinvestigation.common.web.domain.Result(com.gxcata.questionnaireinvestigation.common.web.domain.ErrorCodeEnum.ERROR);
        return result;
    }

    /**
     * 错误返回
     * @param status
     * @param <T>
     * @return
     */
    public static <T> com.gxcata.questionnaireinvestigation.common.web.domain.Result<T> error(com.gxcata.questionnaireinvestigation.common.web.domain.ErrorCodeEnum status) {
        com.gxcata.questionnaireinvestigation.common.web.domain.Result result = new com.gxcata.questionnaireinvestigation.common.web.domain.Result(status);
        return result;
    }

    /**
     * 错误返回
     * @param <T>
     * @return
     */
    public static <T> com.gxcata.questionnaireinvestigation.common.web.domain.Result<T> error(String msg) {
        com.gxcata.questionnaireinvestigation.common.web.domain.Result result = new com.gxcata.questionnaireinvestigation.common.web.domain.Result(com.gxcata.questionnaireinvestigation.common.web.domain.ErrorCodeEnum.ERROR.getVal(),msg);
        return result;
    }

    /**
     * 错误返回
     * @param code
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> com.gxcata.questionnaireinvestigation.common.web.domain.Result<T> error(int code, String msg) {
        com.gxcata.questionnaireinvestigation.common.web.domain.Result result = new com.gxcata.questionnaireinvestigation.common.web.domain.Result(code,msg);
        return result;
    }

    /**
     * 错误返回
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> com.gxcata.questionnaireinvestigation.common.web.domain.Result<T> error(com.gxcata.questionnaireinvestigation.common.web.domain.ErrorCodeEnum status, String msg) {
        com.gxcata.questionnaireinvestigation.common.web.domain.Result result = new com.gxcata.questionnaireinvestigation.common.web.domain.Result(status.getVal(),msg);
        return result;
    }

    /**
     * 错误返回
     * @param t
     * @param status
     * @param <T>
     * @return
     */
    public static <T> com.gxcata.questionnaireinvestigation.common.web.domain.Result<T> error(T t, com.gxcata.questionnaireinvestigation.common.web.domain.ErrorCodeEnum status) {
        com.gxcata.questionnaireinvestigation.common.web.domain.Result result = new com.gxcata.questionnaireinvestigation.common.web.domain.Result(t);
        result.setStatus(status);
        return result;
    }




    public com.gxcata.questionnaireinvestigation.common.web.domain.Result<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public com.gxcata.questionnaireinvestigation.common.web.domain.Result<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public com.gxcata.questionnaireinvestigation.common.web.domain.Result<T> setPage(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
        return this;
    }

    public com.gxcata.questionnaireinvestigation.common.web.domain.Result<T> setData(T data) {
        this.data = data;
        return this;
    }

    public T getData() {
        return data;
    }
}
