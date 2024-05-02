package com.example.CRMProject.Service;

import com.example.CRMProject.Model.Vendor;
import com.example.CRMProject.Repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VedorServiceimpl implements  VendorService{


    @Autowired
    VendorRepository vendorRepository;
    @Override
    public Vendor saveVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    @Override
    public List<Vendor> findAllVendor() {
        return (List<Vendor>) vendorRepository.findAll();
    }

    @Override
    public void deleteVendor(Long id) {
        vendorRepository.deleteById(id);
    }
}
