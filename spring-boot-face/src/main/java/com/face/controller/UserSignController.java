package com.face.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zero.api.dto.IdDto;
import com.zero.api.dto.UserDto;
import com.zero.api.ret.UserRet;
import com.zero.api.service.UserService;
import com.zero.api.util.SignDto;
import com.zero.api.validGroup.AddGroup;
import com.zero.api.validGroup.SearchGroup;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.groups.Default;

/**
 * @author zero
 * @date 2020/8/26-17:07
 */
@RestController
@RequestMapping("/sign/")
public class UserSignController {
    @Reference
    private UserService userService;

    @RequestMapping(value = "user/get", method = RequestMethod.POST)
    public UserRet getUserDto(@Validated({SearchGroup.class, Default.class}) @RequestBody SignDto<UserDto> signDto) {
        return userService.getUserByParam(signDto.getItem());
    }

   // @RequestMapping(value = "user/obtain", method = RequestMethod.GET)
//    public UserRet getUserDto2(@RequestParam("id") Long id) {
//        return userService.getUserById(id);
//    }
    @RequestMapping(value = "user/obtain", method = RequestMethod.POST)
    public UserRet getUserDto2(@Validated({SearchGroup.class, Default.class}) @RequestBody SignDto<IdDto> signDto) {
        return userService.getUserById(signDto.getItem().getId());
    }

    // 分组验证  @Valid 替换 @Validated
    @RequestMapping(value = "user/add", method = RequestMethod.POST)
    public void addUser(@Validated({AddGroup.class, Default.class}) @RequestBody SignDto<UserDto> signDto) {
        userService.addUser(signDto.getItem());
    }
}
