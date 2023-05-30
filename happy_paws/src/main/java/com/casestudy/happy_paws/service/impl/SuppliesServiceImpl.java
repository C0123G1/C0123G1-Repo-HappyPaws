package com.casestudy.happy_paws.service.impl;


import com.casestudy.happy_paws.model.Supplies;
import com.casestudy.happy_paws.repository.ISuppliesRepository;
import com.casestudy.happy_paws.service.ISuppliesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SuppliesServiceImpl implements ISuppliesService {
    @Autowired
    private ISuppliesRepository iSuppliesRepository;

    @Override
    public Page<Supplies> findAll(Pageable pageable) {
        return iSuppliesRepository.findAllSupplies(pageable);
    }

    @Override
    public boolean save(Supplies supplies) {
        try{
            iSuppliesRepository.save(supplies);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteById(Long id) {
        try{
            iSuppliesRepository.deletebyId(id);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public Supplies findById(Long id) {
        return iSuppliesRepository.findById(id).get();
    }
}
