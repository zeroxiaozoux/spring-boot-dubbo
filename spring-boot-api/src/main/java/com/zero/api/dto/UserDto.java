package com.zero.api.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.zero.api.validGroup.AddGroup;
import com.zero.api.validGroup.SearchGroup;
import com.zero.api.validGroup.UpdateGroup;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author zero
 * @date 2020/8/24-17:56
 */
@Data

public class UserDto implements Serializable {

    // 分组验证
    @JSONField(ordinal = 11)
    @NotNull(message = "id 不能为空",groups = {SearchGroup.class, UpdateGroup.class})
    private Long id;
    @JSONField(ordinal = 12)
    @NotNull(message = "name 不能为空")
    private  String name;
    @JSONField(ordinal = 13)
    @NotNull(message = "sex 不能为空",groups = {AddGroup.class})
    private String sex;
    @JSONField(ordinal = 14)
    @NotNull(message = "age 不能为空",groups = {AddGroup.class})
    private  Integer age;
    @JSONField(ordinal = 15)
    @NotNull(message = "email 不能为空",groups = {AddGroup.class})
    @Email(message = "邮箱格式不正确",groups = {AddGroup.class})
    private String email;
}
