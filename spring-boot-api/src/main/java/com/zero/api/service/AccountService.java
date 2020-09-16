package com.zero.api.service;

import com.zero.api.ret.AccountRet;
import com.zero.api.dto.AccountDto;

/**
 * @author zero
 * @date 2020/8/28-15:39
 */
public interface AccountService {
    AccountRet getAccountById(Long id);

    void addAccount(AccountDto accountVo);
}
