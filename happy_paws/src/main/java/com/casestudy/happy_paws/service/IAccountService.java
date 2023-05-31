package com.casestudy.happy_paws.service;

import com.casestudy.happy_paws.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IAccountService   {
    Page<Account> getAllPage(int page);

    void save(Account account);

    List<Account> findAll();
    Account findAccount();
}
