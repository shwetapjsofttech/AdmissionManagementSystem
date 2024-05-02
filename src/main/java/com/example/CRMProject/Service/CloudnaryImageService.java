package com.example.CRMProject.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;


public interface CloudnaryImageService {

    public Map upload(MultipartFile file);
}
