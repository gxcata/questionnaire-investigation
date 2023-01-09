package com.gxcata.questionnaireinvestigation.common.web.domain;

import cn.hutool.core.date.DateTime;
import com.gxcata.questionnaireinvestigation.common.exception.RRException;
import lombok.Getter;

/**
 * @author wanghailun
 * @date 2022年06月28日 16:35
 */
@Getter
public class ExceptionResult {
    private String status;
    private String message;
    private String timestamp;

    public ExceptionResult(RRException e) {
        this.status = e.getCode();
        this.message = e.getMessage();
        this.timestamp = DateTime.now().toString("yyyy-MM-dd HH:mm:ss");
    }
}
