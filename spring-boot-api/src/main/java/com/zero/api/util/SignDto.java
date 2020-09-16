package com.zero.api.util;

import com.alibaba.fastjson.annotation.JSONField;
import com.zero.api.dto.UserDto;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author zero
 * @date 2020/8/31-16:07
 */
@Data
public class SignDto<T> implements Serializable {
    @JSONField(ordinal = 0)
    @NotEmpty(message = "timestamp 不能为空")
    private String timestamp;

    @JSONField(ordinal = 1)
    private String notify_url;
    @JSONField(ordinal = 3)
    @Valid
    @NotNull(message = "item 不能为空")
    private T item;

    @JSONField(ordinal = 9) // 必须保证最后排序
    @NotEmpty(message = "sign 不能为空")
    private String sign; //使用SHA256WithRSA

    private String client_ip;
    private String client_service;
    private String uuid;
    private String version;
    private String client;
}
