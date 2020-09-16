package com.zero.api.job;

import com.zero.api.dto.UserDto;
import com.zero.api.ret.UserRet;

/**
 * @author zero
 * @date 2020/9/4-12:50
 */
public interface StatService {
    void  countUser(String sex);

    UserRet  getUser(UserDto userDto);
}
