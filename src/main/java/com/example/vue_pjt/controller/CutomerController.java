package com.example.vue_pjt.controller;

import com.example.vue_pjt.model.entity.Customer;
import com.example.vue_pjt.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/main")
@RestController
public class CutomerController {
    @Autowired
    private CustomerService customerService;

    /**
     * 고객관리 리스트
     * @param request
     */
    @RequestMapping("/getCustomer")
    public List<Customer> custList(HttpServletRequest request){
        System.out.println("custommer contoller in");

        String searchVal = request.getParameter("searchVal");

        System.out.println("searchVal: "+searchVal);

        List<Customer> customerList = customerService.getCustList(searchVal);

        return customerList;
    }

    /**
     * 고객수정 페이지로
     * @param id
     */
    @GetMapping("/goUpdate/{custNo}")
    public ResponseEntity<?> custUpdateView(@PathVariable("custNo") Integer id){
        System.out.println("customer goupdate controller in");
        Map<String, Object> map = new HashMap<>();

        // getCust
        Customer customer = customerService.getCustomer(id);
        map.put("customer", customer);

        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    /**
     * 고객정보 update
     * @param customer
     */
    @PostMapping("/update")
    public void custUpdate(@RequestBody Customer customer){
        System.out.println("customer update controller in");
        Customer updateCustomer = customerService.getCustomer(customer.getNo());

        updateCustomer.setCustName(customer.getCustName());
        updateCustomer.setCustNick(customer.getCustNick());
        updateCustomer.setPhone(customer.getPhone());
        updateCustomer.setAddr(customer.getAddr());
        updateCustomer.setEmail(customer.getEmail());
        updateCustomer.setId(customer.getId());
        updateCustomer.setPwd(customer.getPwd());

        customerService.updateCust(customer);
    }

    /**
     * 고객정보 insert
     * @param customer
     */
    @PostMapping("/insert")
    public void customerInsert(@RequestBody Customer customer){
        System.out.println("customer insert controller in");

        customer.setNo(2000);
        customerService.updateCust(customer);
    }

    /**
     * 고객정보 delete
     * @param customer
     */
    @PostMapping("/delete")
    public void customerDelete(@RequestBody Customer customer){
        System.out.println("customer delete controller in");
        Integer no = customer.getNo();

        Customer customer_del =  customerService.getCustomer(no);
        customerService.deleteCust(customer_del);
    }
}
