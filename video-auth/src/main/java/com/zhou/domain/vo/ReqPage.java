package com.zhou.domain.vo;

import lombok.Data;

import javax.validation.constraints.Min;

/**
 * ReqPage
 *
 * @author zhouhoujun
 * @date 2020/8/27
 */
@Data
public class ReqPage {

    @Min(value = 0)
    private Integer current;

    @Min(value = 0)
    private Integer size;
}
