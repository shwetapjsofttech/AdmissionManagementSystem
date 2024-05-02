package com.example.CRMProject.Service;

import com.example.CRMProject.Model.Duration;
import com.example.CRMProject.Repository.DurationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DurationServiceimp implements DurationService{

    @Autowired
    DurationRepository durationRepository;


    @Override
    public Duration saveDuration(Duration duration) {
        return durationRepository.save(duration);
    }

    @Override
    @Transactional
    public Void deleteDuration(Long id) {
         durationRepository.deleteById(id);
        return null;
    }

    @Override
    public List<Duration> getAllDuration() {
        return (List<Duration>) durationRepository.findAll();
    }
}
