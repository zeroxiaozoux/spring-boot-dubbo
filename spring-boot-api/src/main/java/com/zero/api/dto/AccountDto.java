package com.zero.api.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author zero
 * @date 2020/8/28-15:43
 */
@Data
public class AccountDto {
    @NotNull(message = "actId 不能为NULL")
    private  Long actId;
}
