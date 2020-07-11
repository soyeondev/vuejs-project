package com.example.vue_pjt.model.entity;

import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Table(name="customer")
@Proxy(lazy = false)
@Data
public class Customer {
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="cust_no")
    private Integer no;

    @Column(name="cust_name")
    private String custName;

    @Column(name="cust_nick")
    private String custNick;

    @Column(name="cust_img")
    private String custImg;

    @Column(name="phone")
    private String phone;

    @Column(name="addr")
    private String addr;

    @Column(name="email")
    private String email;

    @Column(name="id")
    private String id;

    @Column(name="pwd")
    private String pwd;

    @Column(name="cust_info")
    private String custInfo;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustNick() {
        return custNick;
    }

    public void setCustNick(String custNick) {
        this.custNick = custNick;
    }

    public String getCustImg() {
        return custImg;
    }

    public void setCustImg(String custImg) {
        this.custImg = custImg;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getCustInfo() {
        return custInfo;
    }

    public void setCustInfo(String custInfo) {
        this.custInfo = custInfo;
    }
}
