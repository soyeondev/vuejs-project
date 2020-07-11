package com.example.vue_pjt.service;

import com.example.vue_pjt.dao.CustomerRepository;
import com.example.vue_pjt.model.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    public List<Customer> getCustList(String searchVal) {
        if(StringUtils.isEmpty(searchVal) || searchVal.equals("")) {
            System.out.println("searchVal null");
            return customerRepository.findAll();
        } else {
            return customerRepository.findBySearchVal(searchVal);
        }

    }

    @Transactional
    public void updateCust(Customer customer) {
        customerRepository.save(customer);
    }

    public Customer getCustomer(Integer no) {
        return customerRepository.getOne(no);
    }

    public void deleteCust(Customer customer) {
        customerRepository.delete(customer);
    }
}
