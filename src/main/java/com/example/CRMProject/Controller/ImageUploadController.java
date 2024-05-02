package com.example.CRMProject.Controller;

import com.example.CRMProject.Service.CloudnaryImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("upload")
public class ImageUploadController {

    @Autowired
    CloudnaryImageService cloudnaryImageService;

    @PostMapping
    public Map UploadImage(@RequestParam("image")MultipartFile image,@RequestParam("image2")MultipartFile image2,
    @RequestParam("image3")MultipartFile image3){
      Map upload=  cloudnaryImageService.upload(image);
      Map upload2=cloudnaryImageService.upload(image2);
      Map upload3=cloudnaryImageService.upload(image3);
      return  upload;
    }
}
