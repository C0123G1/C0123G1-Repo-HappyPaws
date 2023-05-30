package com.casestudy.happy_paws.repository;

import com.casestudy.happy_paws.model.PetService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPetServiceRepository extends JpaRepository<PetService,Integer> {
}
