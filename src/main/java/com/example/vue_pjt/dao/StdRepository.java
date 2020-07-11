package com.example.vue_pjt.dao;

import com.example.vue_pjt.model.entity.Customer;
import com.example.vue_pjt.model.entity.Std;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StdRepository extends JpaRepository<Std, Integer> {
    List<Std> findAll();

    @Query(value="SELECT * FROM std WHERE std_start > LAST_DAY(:monthVal)" +
            " AND std_end <=  LAST_DAY(:monthVal + interval 1 month)",
            nativeQuery=true)
    List<Std> findByIdAndDate(@Param("monthVal") String monthVal);

}