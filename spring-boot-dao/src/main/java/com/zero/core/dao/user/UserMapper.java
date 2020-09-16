package com.zero.core.dao.user;

import com.zero.core.mode.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zero
 * @date 2020/8/27-18:37
 */
@Mapper
public interface UserDao {

    User getUserById(@Param("id") Long id);

    int insertUser(User user);

    int updateUser(@Param("id") Long id, @Param("name") String name);

    int  countUser(@Param("sex") String sex);
}
