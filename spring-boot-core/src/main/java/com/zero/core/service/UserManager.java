package com.zero.core.service;

import com.zero.api.ret.UserRet;
import com.zero.api.dto.UserDto;
import com.zero.common.utils.BeanCommonUtils;
import com.zero.api.exception.DubboServiceException;
import com.zero.core.dao.user.UserDao;
import com.zero.core.mode.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zero
 * @date 2020/8/27-14:51
 *  管理DAO 和 事务
 */
@Component
public class UserManager {
    @Autowired
    private UserDao userDao; //红色警告 idea 自身问题（@mapper 找不到对应的bean）

    @Transactional(rollbackFor = Exception.class)
    public void addUser(UserDto userDto) throws DubboServiceException {
        User user = BeanCommonUtils.clone(userDto,User.class);
        int count = userDao.insertUser(user);
       // if(1==1) throw  new  DubboServiceException("测试异常"); // 测试业务异常
       // int i = 1/0; // 测试异常
        userDao.updateUser(7L,user.getName());
    }

    public UserRet getUserDto(Long id) {
       User user =  userDao.getUserById(id);
       return  BeanCommonUtils.clone(user, UserRet.class);
    }
}
