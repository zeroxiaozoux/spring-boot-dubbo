package com.zero.core.job.service;

import com.zero.core.dao.user.UserDao;
import com.zero.core.mode.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zero
 * @date 2020/9/4-12:49
 */
@Component
public class StatManager {
    @Autowired
    private UserDao userDao;
    public  int countUser(String sex){
         return  userDao.countUser(sex);
    }

    public User getUser(Long id){
        return  userDao.getUserById(id);
    }
}
