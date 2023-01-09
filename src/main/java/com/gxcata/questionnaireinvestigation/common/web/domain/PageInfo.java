package com.gxcata.questionnaireinvestigation.common.web.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 分页信息对象
 * @author wanghailun
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageInfo {
    @ApiModelProperty(value = "当前第几页")
    private int currPage;
    @ApiModelProperty(value = "每页条数")
    private int pageSize;
    @ApiModelProperty(value = "总条数")
    private int totalCount;
    @ApiModelProperty(value = "总页数")
    private int totalPage;



    /**
     * 分页
     * @param totalCount  总记录数
     * @param pageSize    每页记录数
     * @param currPage    当前页数
     */
    public PageInfo(int totalCount, int pageSize, int currPage) {
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.currPage = currPage;
        this.totalPage = (int) Math.ceil((double)totalCount/pageSize);
    }


}