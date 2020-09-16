package com.zero.core.job.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zero.api.dto.UserDto;
import com.zero.api.job.StatService;
import com.zero.api.ret.UserRet;
import com.zero.common.utils.BeanCommonUtils;
import com.zero.core.job.service.StatManager;
import com.zero.core.mode.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zero
 * @date 2020/9/4-12:52
 */
@Slf4j
@Service
public class StatServiceImpl implements StatService {
    @Autowired
    private StatManager statManager;
    @Override
    public void countUser(String sex) {
       int count = statManager.countUser(sex);
       log.debug("测试 Job-dubbo 对外服务 统计用户数: {}",count);
    }

    @Override
    public UserRet getUser(UserDto userDto) {
        User user = statManager.getUser(userDto.getId());
        return BeanCommonUtils.clone(user,UserRet.class);
    }
}
