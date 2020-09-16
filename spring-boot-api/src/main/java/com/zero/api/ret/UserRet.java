package com.zero.api.ret;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author admin
 * @date 2020/8/24-17:32
 */
@Data
public class UserRet implements Serializable {
    private  String name;
    private String sex;
    private  Integer age;
    private String email;
}
