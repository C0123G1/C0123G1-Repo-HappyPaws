package com.casestudy.happy_paws.service.impl;

import com.casestudy.happy_paws.dto.OrderDetailDAO;
import com.casestudy.happy_paws.model.Customer;
import com.casestudy.happy_paws.model.OrderDetail;
import com.casestudy.happy_paws.model.Product;
import com.casestudy.happy_paws.repository.ICustomerRepository;
import com.casestudy.happy_paws.repository.IOrderDetailRepository;
import com.casestudy.happy_paws.repository.IProductRepository;
import com.casestudy.happy_paws.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServicceImpl implements IOrderDetailService {
    @Autowired
    private IProductRepository iProductRepository;
    @Autowired
    private ICustomerRepository iCustomerRepository;
    @Autowired
    private IOrderDetailRepository iOrderDetailRepository;
    @Override
    public Page<Product> findAllProduct(Pageable pageable) {
        return iProductRepository.findAll(pageable);
    }

    @Override
    public Page<OrderDetail> findAllOrderDetailByOrderId(Pageable pageable,Long orderId) {
        return iOrderDetailRepository.findAllOrderDetailByOrderId(pageable,orderId);
    }

    @Override
    public Customer findCustomerById(Integer customerId) {
        return iCustomerRepository.findById(customerId).get();
    }

    @Override
    public Product findProductById(Long productId) {
        return iProductRepository.findById(productId).get();
    }

    @Override
    public boolean saveOrderDetail(OrderDetail orderDetail) {
        try{
            iOrderDetailRepository.save(orderDetail);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public Page<Product> searchProductOrderDetail(String name,Long orderId, Pageable pageable) {
        return iOrderDetailRepository.searchProductOrderDetail('%' + name + '%',orderId,pageable);
    }
}