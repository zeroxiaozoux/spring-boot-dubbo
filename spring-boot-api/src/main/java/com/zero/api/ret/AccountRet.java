package com.zero.api.ret;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author zero
 * @date 2020/8/28-15:43
 */
@Data
public class AccountRet {
    private  Long actId;
    private  Long userId;
    private BigDecimal userAbleAmt;

}
