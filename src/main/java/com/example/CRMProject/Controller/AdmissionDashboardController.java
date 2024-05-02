package com.example.CRMProject.Controller;

import com.example.CRMProject.Model.Admission;
import com.example.CRMProject.Service.AdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class AdmissionDashboardController {

    @Autowired
    AdmissionService admissionService;

    @GetMapping("/AdmissionIn365Days")
    @ResponseBody
    public int AdmissionIn365Days(){

        LocalDateTime now=LocalDateTime.now();

        LocalDateTime days365DaysAgo=now.minusDays(365);
        List<Admission> AdmissionIn365Days =admissionService.getAdmissionInBetweenDays(days365DaysAgo , now );

        int AdmissionIn365DaysSize=AdmissionIn365Days.size();
        return AdmissionIn365DaysSize;
    }

    @GetMapping("/AdmissionIn7Days")
    @ResponseBody
    public int AdmissionIn7Days(){

        LocalDateTime now=LocalDateTime.now();

        LocalDateTime days7DaysAgo=now.minusDays(7);
        List<Admission> AdmissionIn7Days =admissionService.getAdmissionInBetweenDays(days7DaysAgo , now );
        int AdmissionIn7DaysSize=AdmissionIn7Days.size();
        return AdmissionIn7DaysSize;
    }

    @GetMapping("/AdmissionIn30Days")
    @ResponseBody
    public int AdmissionIn30Days(){

        LocalDateTime now=LocalDateTime.now();

        LocalDateTime days30DaysAgo=now.minusDays(30);
        List<Admission> AdmissionIn30Days =admissionService.getAdmissionInBetweenDays(days30DaysAgo , now );
int AdmissionIn30DaysSize=AdmissionIn30Days.size();
        return AdmissionIn30DaysSize;
    }

    @GetMapping("/TotalAdmission")
    @ResponseBody
    public int TotalAdmission(){
        List<Admission> TotalAdmissions =admissionService.getAllAdmission();
        int TotalAdmissionsSize=TotalAdmissions.size();
        return TotalAdmissionsSize;
    }

    @GetMapping("/AdmissionIn365DaysRevenue")
    @ResponseBody
    public Long AdmissionIn365DaysRevenue(){

        LocalDateTime now=LocalDateTime.now();

        LocalDateTime days365DaysAgo=now.minusDays(365);
        List<Admission> AdmissionIn365Days =admissionService.getAdmissionInBetweenDays(days365DaysAgo , now );

        Long totalRevenue=(long) 0;
        for (Admission student : AdmissionIn365Days) {
            totalRevenue =(Long) totalRevenue+ student.getAmount();
        }
        return totalRevenue;
    }

    @GetMapping("/AdmissionIn7DaysRevenue")
    @ResponseBody
    public Long AdmissionIn7DaysRevenue(){

        LocalDateTime now=LocalDateTime.now();

        LocalDateTime days7DaysAgo=now.minusDays(7);
        List<Admission> AdmissionIn7Days =admissionService.getAdmissionInBetweenDays(days7DaysAgo , now );
        Long days7DaysAgoRevenue=(long) 0;
        for (Admission student : AdmissionIn7Days) {
            days7DaysAgoRevenue =(Long) days7DaysAgoRevenue+ student.getAmount();
        }
        return days7DaysAgoRevenue;
    }

    @GetMapping("/AdmissionIn30DaysRevenue")
    @ResponseBody
    public Long AdmissionIn30DaysRevenue(){

        LocalDateTime now=LocalDateTime.now();

        LocalDateTime days30DaysAgo=now.minusDays(30);
        List<Admission> AdmissionIn30Days =admissionService.getAdmissionInBetweenDays(days30DaysAgo , now );
        Long AdmissionIn30DaysRevenue=(long) 0;
        for (Admission student : AdmissionIn30Days) {
            AdmissionIn30DaysRevenue =(Long) AdmissionIn30DaysRevenue+ student.getAmount();
        }
        return AdmissionIn30DaysRevenue;
    }

    @GetMapping("/TotalAdmissionRevenue")
    @ResponseBody
    public Long TotalAdmissionRevenue(){
        List<Admission> TotalAdmissions =admissionService.getAllAdmission();
        Long TotalAdmissionsRevenue=(long) 0;
        for (Admission student : TotalAdmissions) {
            TotalAdmissionsRevenue =(Long) TotalAdmissionsRevenue+ student.getAmount();
        }
        return TotalAdmissionsRevenue;
    }


}
