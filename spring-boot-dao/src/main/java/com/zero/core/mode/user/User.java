package com.zero.core.mode.user;

import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @author zero
 * @date 2020/8/27-14:55
 */
@Data
@Alias("user")
public class User {
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private String sex;

}
