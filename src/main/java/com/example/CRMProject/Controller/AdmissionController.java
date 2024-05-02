package com.example.CRMProject.Controller;

import com.example.CRMProject.Model.Admission;
import com.example.CRMProject.Model.Course;
import com.example.CRMProject.Service.AdmissionService;
import com.example.CRMProject.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class AdmissionController {

    @Autowired
    AdmissionService admissionService;

    @Autowired
    CourseService courseService;
public static String uploadDirectory=System.getProperty("user.dir")+"/src/main/webapp/images";
@PostMapping("/Save")
@ResponseBody
    public Admission SaveStudent(@ModelAttribute Admission admission,  @RequestParam("studentPhoto") MultipartFile studentPhoto,
                                 @RequestParam("feesReceipt") MultipartFile feesReceipt) throws IOException {

       admissionService.saveAdmission(admission,studentPhoto,feesReceipt);
        return admission;
    }

    @GetMapping("/getAdmissionStudent")
    @ResponseBody
    public List<Admission> getAllAdmissions(){

List<Admission> admissionListstudent =admissionService.getAllAdmission();

return admissionListstudent;
    }

    @GetMapping("/getAdmissionById/{id}")
    @ResponseBody
    public Admission getAdmissionById(@PathVariable Long id){
        Admission admission= admissionService.getAdmission(id);
        return admission;
    }
    @PutMapping("/UpdateAdmission/{sid}")
    @ResponseBody
    public Admission updateStudent(@RequestBody Admission admission, @PathVariable Long sid){
     Admission stuednt=   admissionService.updateAdmission(admission, sid);
        return stuednt;
    }

    @DeleteMapping("/deleteAdmission/{id}")
    @ResponseBody
    public void deleteAdmission(@PathVariable Long id){

        admissionService.deleteAdmission(id);

    }

}
