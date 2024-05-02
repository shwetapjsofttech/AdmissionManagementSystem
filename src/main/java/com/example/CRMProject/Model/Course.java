package com.example.CRMProject.Model;

import jakarta.persistence.*;
import org.springframework.stereotype.Controller;

import java.util.Stack;

@Entity
public class Course {

    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true)
    String Cname;
    Long Fees;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public Long getFees() {
        return Fees;
    }

    public void setFees(Long fees) {
        Fees = fees;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", Cname='" + Cname + '\'' +
                ", Fees=" + Fees +
                '}';
    }

    public Course(Long id, String cname, Long fees) {
        this.id = id;
        Cname = cname;
        Fees = fees;
    }

    public Course() {
        super();
        // TODO Auto-generated constructor stub
    }
}
