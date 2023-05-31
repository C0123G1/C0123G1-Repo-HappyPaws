package com.casestudy.happy_paws.repository;

import com.casestudy.happy_paws.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IAccountRepository extends JpaRepository<Account ,Integer> {
    @Query(value = "select c.* from  account c order by c.account_id desc limit 1",nativeQuery = true)
    Account findAccount();
}
// c.* mới đúng * khong van duoc ủa order by cái chi oi quen
