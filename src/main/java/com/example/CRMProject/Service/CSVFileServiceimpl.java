package com.example.CRMProject.Service;

import com.example.CRMProject.Model.Admission;
import com.example.CRMProject.Repository.AdmissionRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

@Service
public class CSVFileServiceimpl implements  CSVFileService{

@Autowired
AdmissionRepository csvRepository;
    @Override
    public ByteArrayInputStream Load() {
      List<Admission> listUser= (List<Admission>) csvRepository.findAll();
      ByteArrayInputStream stream=usersToCSV(listUser);
        return stream;
    }



    private ByteArrayInputStream usersToCSV(List<Admission> user){
     CSVFormat format=    CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);
       try(ByteArrayOutputStream out=new ByteArrayOutputStream();
               CSVPrinter csvPrinter=new CSVPrinter(new PrintWriter(out), format); ) {
           for(Admission u1:user){
           List<Serializable> data=   Arrays.asList(String.valueOf(u1.getId()), u1.getSid(),u1.getName(),u1.getAmount(),u1.getScourses(),u1.getAcademy(),u1.getDate(),u1.getDuration(),u1.getRemark(),u1.getStatus1(),u1.getfMobile(),u1.getMob(),u1.getPendingAmount());
           csvPrinter.printRecord(data);
           }
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
        return null;
    }


}
