package com.zero.api.service;

import com.zero.api.ret.UserRet;
import com.zero.api.dto.UserDto;

/**
 * @author zero
 * @date 2020/8/24-17:44
 */
public interface UserService {

    UserRet getUserByParam(UserDto userDto);

    UserRet getUserById(Long id);

    void addUser(UserDto userDto) ;

}
