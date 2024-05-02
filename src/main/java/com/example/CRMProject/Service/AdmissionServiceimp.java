package com.example.CRMProject.Service;

import com.cloudinary.Cloudinary;
import com.example.CRMProject.Model.Admission;
import com.example.CRMProject.Model.Course;
import com.example.CRMProject.Repository.AdmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class AdmissionServiceimp implements AdmissionService{

    @Autowired
    AdmissionRepository admissionRepository;

    @Autowired
    CourseService courseService;

    @Autowired
    Cloudinary cloudinary;
    @Override
    public Admission saveAdmission(Admission admission, MultipartFile studentPhoto, MultipartFile feesRecipt) throws IOException {
      Map uploadPhoto=  this.cloudinary.uploader().upload(studentPhoto.getBytes(), Map.of());
        String uploadURL= (String) uploadPhoto.get("secure_url");
        admission.setStudentImage(uploadURL);

        Map feesReceiptUpload = this.cloudinary.uploader().upload(feesRecipt.getBytes(), Map.of());
        String feesReceiptUrl = (String) feesReceiptUpload.get("secure_url");
        admission.setFeesRecipt(feesReceiptUrl);
        Course c1=courseService.findByCourseName(admission.getScourses());
          if(c1.getFees()>=admission.getAmount()){
           Long pendingAmount=c1.getFees()-  admission.getAmount();
           admission.setPendingAmount(pendingAmount);
           admission.setStatus1("pending");
       }else{
           admission.setPendingAmount(null);
              admission.setStatus1("completed");
       }


        return admissionRepository.save(admission);
    }

    @Override
    public List<Admission> getAllAdmission() {
       List<Admission> listOfAdmission= (List<Admission>) admissionRepository.findAll();

        return listOfAdmission;
    }

    @Override
    public Admission getAdmission(Long id) {
        Admission admission= admissionRepository.findBySid(id);
        return admission;
    }

    @Override
    public Admission updateAdmission(Admission admission, Long sid) {
        Admission existingAdmission = admissionRepository.findBySid(sid);
        if (existingAdmission != null && admission != null) {
            try {
                existingAdmission.setName(admission.getName());
                existingAdmission.setMob(admission.getMob());
                existingAdmission.setDate(admission.getDate());
                existingAdmission.setScourses(admission.getScourses());
                existingAdmission.setDuration(admission.getDuration());
                existingAdmission.setAmount(admission.getAmount());
                existingAdmission.setAcademy(admission.getAcademy());
                existingAdmission.setRemark(admission.getRemark());
                existingAdmission.setStatus1(admission.getStatus1());
            } catch (Exception e) {
                System.out.println("Error occurred while updating admission: " + e.getMessage());
                // You might want to log the error instead of just printing it
            }
            return admissionRepository.save(existingAdmission);
        } else {
            // Handle the case when either existingAdmission or admission is null
            System.out.println("Existing admission or new admission is null.");
            return existingAdmission; // Or throw an exception, depending on your application's logic
        }
    }

    @Override
    public void deleteAdmission(Long sid) {
        admissionRepository.deleteBySid(sid);
    }

    @Override
    public List<Admission> getAdmissionInBetweenDays(LocalDateTime StartData, LocalDateTime EndDate) {
        return admissionRepository.findByDateBetween(StartData,EndDate);
    }

    @Override
    public List<Admission> findByDateBetweenAndScourses(Date startDate, Date endDate, String scourses) {
        return admissionRepository.findByDateBetweenAndScourses(startDate, endDate, scourses);
    }


}
