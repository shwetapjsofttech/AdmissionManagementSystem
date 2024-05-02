package com.example.CRMProject.Controller;

import com.example.CRMProject.Model.Admission;
import com.example.CRMProject.Service.AdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Controller
public class ReportingController {

    @Autowired
 AdmissionService admissionService;
    @GetMapping("/AdmissionIn365DaysData")
    @ResponseBody
    public List<Admission> AdmissionIn365DaysData(){

        LocalDateTime now=LocalDateTime.now();

        LocalDateTime days365DaysAgo=now.minusDays(365);
        List<Admission> AdmissionIn365Days =admissionService.getAdmissionInBetweenDays(days365DaysAgo , now );

        return AdmissionIn365Days;
    }

    @GetMapping("/AdmissionIn7DaysData")
    @ResponseBody
    public List<Admission> AdmissionIn7DaysData(){

        LocalDateTime now=LocalDateTime.now();

        LocalDateTime days7DaysAgo=now.minusDays(7);
        List<Admission> AdmissionIn7Days =admissionService.getAdmissionInBetweenDays(days7DaysAgo , now );

        return AdmissionIn7Days;
    }

    @GetMapping("/AdmissionIn30DaysData")
    @ResponseBody
    public List<Admission> AdmissionIn30DaysData(){

        LocalDateTime now=LocalDateTime.now();

        LocalDateTime days30DaysAgo=now.minusDays(30);
        List<Admission> AdmissionIn30Days =admissionService.getAdmissionInBetweenDays(days30DaysAgo , now );

        return AdmissionIn30Days;
    }


    @GetMapping("/GetAdmissionsInBetweenDatesAndScourse")
    @ResponseBody
    public List<Admission> GetAdmissionsInBetweenDatesAndScourse(@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                                                 @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
                                                                 @RequestParam("Scourses") String Scourses){


        List<Admission> AdmissionInBetweenDatesAndScourse =admissionService.findByDateBetweenAndScourses(startDate , endDate , Scourses);

        return AdmissionInBetweenDatesAndScourse;
    }






}
