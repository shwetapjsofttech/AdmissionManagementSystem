package com.example.CRMProject.Controller;

import com.example.CRMProject.Model.Duration;
import com.example.CRMProject.Service.DurationServiceimp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DurationController {
    @Autowired
    DurationServiceimp durationService;

    @PostMapping("/saveDuration")
    @ResponseBody
    public Duration saveDuration(@RequestBody Duration duration){
        return durationService.saveDuration(duration);
    }

    @GetMapping("/getDurationList")
    @ResponseBody
    public List<Duration> getAllDuration(){
        return durationService.getAllDuration();
    }

    @DeleteMapping("/deleteDuration/{id}")
    @ResponseBody
    public Void DeleteDurationList(@PathVariable Long id){
        durationService.deleteDuration(id);
        return null;
    }
}
