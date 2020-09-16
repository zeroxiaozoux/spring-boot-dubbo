package com.zero.api.dto;

import com.zero.api.validGroup.SearchGroup;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author zero
 * @date 2020/8/31-16:23
 */
@Data
public class IdDto {
    @NotNull(message = "id 不能为空", groups = SearchGroup.class)
    private Long id;
}
