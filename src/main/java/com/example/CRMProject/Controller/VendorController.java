package com.example.CRMProject.Controller;

import com.example.CRMProject.Model.Vendor;
import com.example.CRMProject.Service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VendorController {

    @Autowired
    VendorService vendorService;

    @PostMapping("/saveVendor")
    @ResponseBody
    public Vendor saveVendor(@RequestBody  Vendor vendor){
        return vendorService.saveVendor(vendor);
    }

    @GetMapping("/getAllVendor")
    @ResponseBody
    public List<Vendor> getAllVendor(){

        return vendorService.findAllVendor();
    }

    @DeleteMapping("/deleteVendor/{id}")
    @ResponseBody
     public void deleteVendorService(@PathVariable Long id){
        vendorService.deleteVendor(id);
    }
}
