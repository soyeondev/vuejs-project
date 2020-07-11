package com.example.vue_pjt.service;

import com.example.vue_pjt.dao.CustomerRepository;
import com.example.vue_pjt.dao.StdRepository;
import com.example.vue_pjt.model.entity.Customer;
import com.example.vue_pjt.model.entity.Std;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StdService {

    @Autowired
    private StdRepository stdRepository;

    public List<Std> getStdList(String monthVal) {
        if(StringUtils.isEmpty(monthVal) || monthVal.equals("")) {
            System.out.println("monthVal null");
            return stdRepository.findAll();
        } else {
            return stdRepository.findByIdAndDate(monthVal);
        }

    }

}
