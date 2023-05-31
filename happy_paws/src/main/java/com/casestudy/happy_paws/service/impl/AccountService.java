package com.casestudy.happy_paws.service.impl;

import com.casestudy.happy_paws.model.Account;
import com.casestudy.happy_paws.repository.IAccountRepository;
import com.casestudy.happy_paws.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository ;
    @Override
    public Page<Account> getAllPage(int page) {
        return accountRepository.findAll(PageRequest.of(page,2));
    }

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findAccount() {
        return accountRepository.findAccount(); // ua cho
    }


}
