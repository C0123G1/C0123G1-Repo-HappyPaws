package com.casestudy.happy_paws.repository;

import com.casestudy.happy_paws.model.PetService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IPetServiceRepository extends JpaRepository<PetService, Long> {
    @Query(value = "SELECT p FROM PetService AS p WHERE ( p.isDelete=false ) AND (p.name LIKE :search) ORDER BY p.updateTime DESC ")
    Page<PetService> searchPage(String search, Pageable pageable);
}
