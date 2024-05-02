package com.example.CRMProject.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Duration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String Duration;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDuration() {
        return Duration;
    }
    public void setDuration(String duration) {
        Duration = duration;
    }
    @Override
    public String toString() {
        return "Duration [" + (id != null ? "id=" + id + ", " : "") + (Duration != null ? "Duration=" + Duration : "")
                + "]";
    }
    public Duration(Long id, String duration) {
        super();
        this.id = id;
        Duration = duration;
    }
    public Duration() {
        super();
        // TODO Auto-generated constructor stub
    }
}
