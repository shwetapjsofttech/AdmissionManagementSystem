package com.example.CRMProject.Repository;

import com.example.CRMProject.Model.Vendor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends CrudRepository<Vendor,Long> {
}
