package com.example.CRMProject.Model;

import jakarta.persistence.*;
import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Arrays;
import java.util.Date;

@Entity
@Builder
public class Admission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="Sid",unique = true)
    private Long sid;


    @Column(name="name")
    private String name;
    @Column(name="Mobile_number")
    private String mob;
    @Column(name="date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @Column(name="scourses")
    private String scourses;
    @Column(name="duration")
    private String duration;
    @Column(name="fMobile")
    private Long fMobile;
    @Column(name="mMobile")
    private Long mMobile;
    @Column(name="amount")
    private Long amount;
    @Column(name="academy")
    private String academy;
    @Column(name="remark")
    private String remark;
    @Column(name="status1")
    private String status1;

    @Column(name="paymentMethod")
    private String paymentMethod;
    @Column(name="feesRecipt")
    private String feesRecipt;
    @Column(name="studentImage")
    private String studentImage;
    @Lob
    @Column(name="pendingAmount")
    private Long pendingAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getScourses() {
        return scourses;
    }

    public void setScourses(String scourses) {
        this.scourses = scourses;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Long getfMobile() {
        return fMobile;
    }

    public void setfMobile(Long fMobile) {
        this.fMobile = fMobile;
    }

    public Long getmMobile() {
        return mMobile;
    }

    public void setmMobile(Long mMobile) {
        this.mMobile = mMobile;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus1() {
        return status1;
    }

    public void setStatus1(String status1) {
        this.status1 = status1;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getFeesRecipt() {
        return feesRecipt;
    }

    public void setFeesRecipt(String feesRecipt) {
        this.feesRecipt = feesRecipt;
    }

    public String getStudentImage() {
        return studentImage;
    }

    public void setStudentImage(String studentImage) {
        this.studentImage = studentImage;
    }

    public Long getPendingAmount() {
        return pendingAmount;
    }

    public void setPendingAmount(Long pendingAmount) {
        this.pendingAmount = pendingAmount;
    }

    @Override
    public String toString() {
        return "Admission{" +
                "id=" + id +
                ", sid=" + sid +
                ", name='" + name + '\'' +
                ", mob='" + mob + '\'' +
                ", date=" + date +
                ", scourses='" + scourses + '\'' +
                ", duration='" + duration + '\'' +
                ", fMobile=" + fMobile +
                ", mMobile=" + mMobile +
                ", amount=" + amount +
                ", academy='" + academy + '\'' +
                ", remark='" + remark + '\'' +
                ", status1='" + status1 + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", feesRecipt='" + feesRecipt + '\'' +
                ", studentImage='" + studentImage + '\'' +
                ", pendingAmount=" + pendingAmount +
                '}';
    }

    public Admission(Long id, Long sid, String name, String mob, Date date, String scourses, String duration, Long fMobile, Long mMobile, Long amount, String academy, String remark, String status1, String paymentMethod, String feesRecipt, String studentImage, Long pendingAmount) {
        this.id = id;
        this.sid = sid;
        this.name = name;
        this.mob = mob;
        this.date = date;
        this.scourses = scourses;
        this.duration = duration;
        this.fMobile = fMobile;
        this.mMobile = mMobile;
        this.amount = amount;
        this.academy = academy;
        this.remark = remark;
        this.status1 = status1;
        this.paymentMethod = paymentMethod;
        this.feesRecipt = feesRecipt;
        this.studentImage = studentImage;
        this.pendingAmount = pendingAmount;
    }

    public Admission(){super();}
}
