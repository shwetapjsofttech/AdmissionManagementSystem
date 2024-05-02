package com.example.CRMProject.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String vendorName;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getVendorName() {
        return vendorName;
    }
    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }
    @Override
    public String toString() {
        return "VendorAdmission [" + (id != null ? "id=" + id + ", " : "")
                + (vendorName != null ? "vendorName=" + vendorName : "") + "]";
    }
    public Vendor(Long id, String vendorName) {
        super();
        this.id = id;
        this.vendorName = vendorName;
    }
    public Vendor() {
        super();
        // TODO Auto-generated constructor stub
    }
}
