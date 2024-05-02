package com.example.CRMProject.Service;

import com.example.CRMProject.Model.Vendor;

import java.util.List;

public interface VendorService {

    public Vendor saveVendor(Vendor vendor);
    public List<Vendor> findAllVendor();
    public void deleteVendor(Long id);
}
