package com.example.CRMProject.Repository;

import com.example.CRMProject.Model.Duration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DurationRepository  extends CrudRepository<Duration, Integer> {
    void deleteById(Long id);
}
