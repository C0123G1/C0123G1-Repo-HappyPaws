package com.casestudy.happy_paws.repository;

import com.casestudy.happy_paws.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IAccountRepository extends JpaRepository<Account,Integer> {
    @Query(value = "SELECT  c FROM  Account c WHERE c.accountId = :userId ")
    Account findAccount(Integer userId);

    @Query(value = "SELECT u FROM Account u WHERE u.username LIKE :username ")
    Account findUser(String username);


}


