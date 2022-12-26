package com.yj.lab.common.model.vo.response.common;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangyj21
 */
@Data
@NoArgsConstructor
public class ErrorInfoVo {
    private String path;
    private String method;
    private String exception;
    private String message;
    private String cause;
    private String timestamp;

}
