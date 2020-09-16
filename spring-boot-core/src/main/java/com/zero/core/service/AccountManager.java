package com.zero.core.service;

import com.zero.api.dto.AccountDto;
import com.zero.core.dao.account.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zero
 * @date 2020/8/28-15:50
 */
@Component
public class AccountManager {
    @Autowired
    private AccountDao accountDao;

    public void addAccount(AccountDto accountVo) {
        // todo
    }
}
