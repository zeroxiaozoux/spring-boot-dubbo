package com.dubbo.job.rest;

import com.dubbo.job.config.RestUrlConfig;
import com.dubbo.job.utils.RestUrlUntils;
import com.zero.api.dto.UserDto;
import com.zero.api.job.StatService;
import com.zero.api.ret.UserRet;
import com.zero.api.util.WebClientUtil;
import com.zero.common.utils.StringCommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zero
 * @date 2020/9/14-14:36
 */
@Slf4j
@Component
public class RestStatServiceImpl implements StatService {

    @Autowired
    private  RestUrlUntils restUrlUntils;

    @Override
    public void countUser(String sex) {
        WebClientUtil.webClientGet(restUrlUntils.getServiceUrl("countUser"), StringCommonUtils.StringsToMap("sex",sex));
    }

    @Override
    public UserRet getUser(UserDto userDto) {
//        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
//        formData.add("id", String.valueOf(userDto.getId()));
        String retStr =  WebClientUtil.webClientPost(restUrlUntils.getServiceUrl("countUser"),userDto, UserDto.class);
        return WebClientUtil.resultDtojsonStringToBean(retStr,UserRet.class);
    }
}
