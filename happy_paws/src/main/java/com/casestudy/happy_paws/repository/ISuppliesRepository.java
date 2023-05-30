package com.casestudy.happy_paws.repository;


import com.casestudy.happy_paws.model.Supplies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ISuppliesRepository extends JpaRepository<Supplies, Long> {
    @Query(value = "update supplies set is_delete = true where id=:id",nativeQuery = true)
    @Modifying
    @Transactional
    void deletebyId(@Param("id") Long id);
    @Query(value = "select s from Supplies s where s.isDelete = false")
    Page<Supplies> findAllSupplies(Pageable pageable);
}
