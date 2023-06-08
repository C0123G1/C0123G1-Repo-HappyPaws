package com.casestudy.happy_paws.service;


import com.casestudy.happy_paws.model.Account;

import java.util.List;


public interface IAccountService {
//    Page<com.casestudy.happy_paws.model.Account> getAllPage(int page);

    void save(Account account);

    List<Account> findAll();
//    Account findAccount();

//    Account findUser(String username);

    Account findAccount(Integer accountId);


    Account findById(Integer id);
}
