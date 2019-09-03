package org.sang.bean;

import lombok.Data;

/**
 * @description:
 * @author: yangzheng
 * @time: 2019/9/3 18:24
 */
@Data
public class Result<T> {
    private String code;
    private T data;
}
