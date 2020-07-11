package com.example.vue_pjt.model.entity;

import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Table(name="std")
@Proxy(lazy = false)
@Data
public class Std {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="std_no")
    private Integer no;

    @Column(name="std_image")
    private String stdImage;

    @Column(name="std_name")
    private String stdName;

    @Column(name="std_intro")
    private String stdIntro;

    @Column(name="std_start")
    private String stdStart;

    @Column(name="std_end")
    private String stdEnd;

    @Column(name="std_time")
    private String stdTime;

    @Column(name="std_loc")
    private String stdLoc;

    @Column(name="std_close")
    private String stdClose;

    @Column(name="std_limit")
    private String stdLimit;

    @Column(name="std_content")
    private String stdContent;

    @Column(name="std_hits")
    private String stdHits;

    @Column(name="founder_info")
    private String founderInfo;

    @Column(name="founder_no")
    private String founderNo;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getStdImage() {
        return stdImage;
    }

    public void setStdImage(String stdImage) {
        this.stdImage = stdImage;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public String getStdIntro() {
        return stdIntro;
    }

    public void setStdIntro(String stdIntro) {
        this.stdIntro = stdIntro;
    }

    public String getStdStart() {
        return stdStart;
    }

    public void setStdStart(String stdStart) {
        this.stdStart = stdStart;
    }

    public String getStdEnd() {
        return stdEnd;
    }

    public void setStdEnd(String stdEnd) {
        this.stdEnd = stdEnd;
    }

    public String getStdTime() {
        return stdTime;
    }

    public void setStdTime(String stdTime) {
        this.stdTime = stdTime;
    }

    public String getStdLoc() {
        return stdLoc;
    }

    public void setStdLoc(String stdLoc) {
        this.stdLoc = stdLoc;
    }

    public String getStdClose() {
        return stdClose;
    }

    public void setStdClose(String stdClose) {
        this.stdClose = stdClose;
    }

    public String getStdLimit() {
        return stdLimit;
    }

    public void setStdLimit(String stdLimit) {
        this.stdLimit = stdLimit;
    }

    public String getStdContent() {
        return stdContent;
    }

    public void setStdContent(String stdContent) {
        this.stdContent = stdContent;
    }

    public String getStdHits() {
        return stdHits;
    }

    public void setStdHits(String stdHits) {
        this.stdHits = stdHits;
    }

    public String getFounderInfo() {
        return founderInfo;
    }

    public void setFounderInfo(String founderInfo) {
        this.founderInfo = founderInfo;
    }

    public String getFounderNo() {
        return founderNo;
    }

    public void setFounderNo(String founderNo) {
        this.founderNo = founderNo;
    }
}
