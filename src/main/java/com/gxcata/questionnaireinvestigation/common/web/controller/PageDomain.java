package com.gxcata.questionnaireinvestigation.common.web.controller;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 分页数据
 * 
 * @author gxcata
 */
@Data
public class PageDomain
{
    @ApiModelProperty(value = "默认分页 为1时默认一页10条，分页大小可不传")
    private  String defaultCode;

    @ApiModelProperty(value = "当前记录起始索引")
    private Integer pageNum;

    @ApiModelProperty(value = "每页显示记录数")
    private Integer pageSize;


    /** 排序列 */
//    private String orderBy;

    /** 排序的方向desc或者asc */
//    private String isAsc = "asc";


    public void addDefaultValue() {
        if (this.getPageNum() == null) {
            this.setPageNum(1);
        }

//        if (this.defaultSize != null && !this.defaultSize.equals("")) {
//            Object object = redisTemplate.opsForValue().get(this.defaultSize);
//
//            if (object != null) {
//                AppConfig appConfig = (AppConfig) object;
//                this.setPageSize(Integer.valueOf(appConfig.getValue()));
//            }

            if (this.getPageSize() == null) {
                this.setPageSize(Integer.MAX_VALUE);
            }
//        }
    }
}
