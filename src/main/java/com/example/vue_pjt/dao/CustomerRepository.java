package com.example.vue_pjt.dao;

import com.example.vue_pjt.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findAll();

    @Modifying
    @Query(value="SELECT * FROM customer WHERE cust_name like %:keyword% OR cust_nick like %:keyword%"
            , nativeQuery=true)
    List<Customer> findBySearchVal(@Param("keyword") String keyword);

    @Query(value="SELECT * FROM tb_cust_charge WHERE id = :id AND insert_time > LAST_DAY(:monthVal)" +
            " AND insert_time <=  LAST_DAY(:monthVal + interval 1 month)",
            nativeQuery=true)
    List<Customer> findByCompanyIdAndDate(@Param("id") Integer id, @Param("monthVal") String monthVal);

    @Query(value="SELECT * FROM tb_cust_pay WHERE cust_id =:cust_id AND company_id =:company_id" ,
            nativeQuery=true)
    Customer getCustPayByCustIdAndCompanyIdNative(@Param("cust_id") Integer custId, @Param("company_id") Integer companyId);


}