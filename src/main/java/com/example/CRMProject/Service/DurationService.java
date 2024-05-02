package com.example.CRMProject.Service;

import com.example.CRMProject.Model.Duration;

import java.util.List;

public interface DurationService {

    public Duration saveDuration(Duration duration);
    public Void deleteDuration(Long id);

    public List<Duration> getAllDuration();
}
