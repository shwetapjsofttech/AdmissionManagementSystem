package com.example.CRMProject.Controller;


import com.example.CRMProject.Model.Admission;
import com.example.CRMProject.Model.ResponseMess;
import com.example.CRMProject.Service.AdmissionService;
import com.example.CRMProject.Service.CSVFileService;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

@Controller
public class CSVFileUpload {

    @Autowired
    CSVFileService csvFileService;

    @Autowired
    AdmissionService admissionService;

    @GetMapping("/download")
    public ResponseEntity<Resource> downloadFile() {
        String fileName = "userData.csv";
        ByteArrayInputStream fileData = csvFileService.Load();
        InputStreamResource resource = new InputStreamResource(fileData);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName)
                .contentType(MediaType.parseMediaType("application/csv"))
                .body(resource);
    }

//    @GetMapping("/download/file")
//    public void exportCSV(HttpServletResponse response) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
//        String fileName = "employee-data.csv";
//
//        response.setContentType("text/csv");
//        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "");
//
//        StatefulBeanToCsv<Files> writer = new StatefulBeanToCsvBuilder<Files>(response.getWriter())
//                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
//                .withOrderedResults(true)
//                .build();
//
//        writer.write(csvFileService.());
//
//    }


    @GetMapping("/download/admissions")
    public ResponseEntity<byte[]> downloadAdmissionsCSV() throws IOException {
        List<Admission> admissions = admissionService.getAllAdmission();
        byte[] csvBytes = generateCSV(admissions);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("filename", "admissions.csv");

        return ResponseEntity.ok()
                .headers(headers)
                .body(csvBytes);
    }

    private byte[] generateCSV(List<Admission> admissions) {
        try {
            StringWriter stringWriter = new StringWriter();
            CSVWriter csvWriter = new CSVWriter(stringWriter);

            // Write CSV header
            String[] headerRecord = {"Sid", "Id", "Name", "Mobile Number", "Date", "Courses", "Duration", "Father's Mobile",
                    "Mother's Mobile", "Amount", "Academy", "Remark", "Status", "Payment Method", "Payment Receipt",
                    "Photo", "Pending Amount"};
            csvWriter.writeNext(headerRecord);

            // Write CSV data
            for (Admission admission : admissions) {
                csvWriter.writeNext(new String[]{
                        String.valueOf(admission.getSid()),
                        String.valueOf(admission.getId()),
                        admission.getName(),
                        admission.getMob(),
                        String.valueOf(admission.getDate()),
                        admission.getScourses(),
                        admission.getDuration(),
                        String.valueOf(admission.getfMobile()),
                        String.valueOf(admission.getmMobile()),
                        String.valueOf(admission.getAmount()),
                        admission.getAcademy(),
                        admission.getRemark(),
                        admission.getStatus1(),

                        String.valueOf(admission.getPendingAmount())
                });
            }

            csvWriter.close();
            return stringWriter.toString().getBytes();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
