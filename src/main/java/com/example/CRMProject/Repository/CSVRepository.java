package com.example.CRMProject.Repository;

import com.example.CRMProject.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface CSVRepository extends CrudRepository<User, Long> {
}
