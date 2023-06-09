package com.casestudy.happy_paws.service.impl;

import com.casestudy.happy_paws.model.Account;
import com.casestudy.happy_paws.repository.IAccountRepository;
import com.casestudy.happy_paws.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService implements IAccountService{
    @Autowired
    private IAccountRepository accountRepository ;

    @Override
    public void save(Account account) {
accountRepository.save(account);
    }

    @Override
    public List<Account> findAll() {
        return null;
    }

//    @Override
//    public Account findUser(String username) {
//        return null;
//    }

    @Override
    public Account findAccount(Integer accountId) {
        return accountRepository.findAccount(accountId);
    }

    @Override
    public Account findById(Integer id) {
        return accountRepository.findById(id).get();
    }




//    @Override
//    public void save(Account user) {
//
//        accountRepository.save(user);
//    }


//    @Override
//    public List<Account> findAll() {
//        return accountRepository.findAll();
//    }




    //    @Override
//    public Account findAccount() {
//        return accountRepository.findAccount();
//    }
// laf
//    @Override
//    public Account findAccount(Integer userId) {
//        return accountRepository.findAccount(userId);
//    }

//    @Override
//    public Account findUser(String username) {
//        return accountRepository.findUser(username);
//    }


}
