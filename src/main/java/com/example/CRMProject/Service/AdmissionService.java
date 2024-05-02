package com.example.CRMProject.Service;

import com.example.CRMProject.Model.Admission;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface AdmissionService {

    public Admission saveAdmission(Admission admission, MultipartFile studentPhone, MultipartFile feesRecipt) throws IOException;
    public List<Admission> getAllAdmission();

    public Admission getAdmission(Long id);

    public Admission updateAdmission(Admission admission, Long sid);

    public void deleteAdmission(Long sid);

    public List<Admission> getAdmissionInBetweenDays(LocalDateTime StartData, LocalDateTime EndDate);
    List<Admission> findByDateBetweenAndScourses(Date startDate, Date endDate, String scourses);
}
