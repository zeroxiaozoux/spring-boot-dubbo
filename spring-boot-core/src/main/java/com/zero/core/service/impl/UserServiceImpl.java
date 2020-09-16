package com.zero.core.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zero.api.ret.UserRet;
import com.zero.api.dto.UserDto;
import com.zero.api.service.UserService;
import com.zero.common.utils.BeanCommonUtils;
import com.zero.core.config.LogAnnotation;
import com.zero.core.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zero
 * @date 2020/8/24-18:06
 */

@Service
public  class UserServiceImpl implements UserService {
    @Autowired
    private UserManager userManager;

    @LogAnnotation
    public UserRet getUserByParam(UserDto userVo) {
        UserRet userDto =BeanCommonUtils.clone(userVo, UserRet.class);
        return userDto;
    }

    @Override
    public UserRet getUserById(Long id) {
//        UserDto userDto = new UserDto();
//        userDto.setAge(10);
//        userDto.setEmail("234@qq.com");
//        userDto.setName("hello");
//        userDto.setSex("男");
        return userManager.getUserDto(id);
    }

    @Override
    public void addUser(UserDto userDto) {
//        try {
//            userManager.addUser(userVo);
//        } catch (DubboServiceException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        userManager.addUser(userDto); // 异常会被包裹
    }


}
