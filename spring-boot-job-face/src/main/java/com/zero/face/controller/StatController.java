package com.zero.face.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zero.api.dto.UserDto;
import com.zero.api.job.StatService;
import com.zero.api.ret.UserRet;
import com.zero.api.validGroup.SearchGroup;
import com.zero.api.validGroup.UpdateGroup;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.groups.Default;

/**
 * @author zero
 * @date 2020/9/10-16:46
 */
@RestController
@RequestMapping("/stat/")
public class StatController {
    @Reference
    private StatService statService;

    @RequestMapping(value = "get",method = RequestMethod.GET)
    public void countUser(String sex){
        statService.countUser(sex);
    }


    @RequestMapping(value = "getUser",method = RequestMethod.POST)
    public UserRet getUser(@Validated({UpdateGroup.class}) @RequestBody UserDto userDto){
        return statService.getUser(userDto);
    }

}
