package com.example.vue_pjt.controller;

import com.example.vue_pjt.model.entity.Customer;
import com.example.vue_pjt.model.entity.Std;
import com.example.vue_pjt.service.CustomerService;
import com.example.vue_pjt.service.StdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/main/studer")
@RestController
public class StdController {
    @Autowired
    private StdService stdService;

    /**
     * 스터디모임 리스트
     * @param request
     */
    @RequestMapping("/getStdList")
    public List<Std> stdList(HttpServletRequest request){
        System.out.println("studer contoller in");

        String monthVal = request.getParameter("monthVal");

        List<Std> stdList = stdService.getStdList(monthVal);

        return stdList;
    }

}
