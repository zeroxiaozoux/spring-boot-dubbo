package com.zero.core.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zero.api.ret.AccountRet;
import com.zero.api.dto.AccountDto;
import com.zero.api.service.AccountService;
import com.zero.core.service.AccountManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zero
 * @date 2020/8/28-15:48
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private  AccountManager accountManager;

    @Override
    public AccountRet getAccountById(Long id) {
        return null;
    }

    @Override
    public void addAccount(AccountDto accountVo) {
        accountManager.addAccount(accountVo);
    }
}
