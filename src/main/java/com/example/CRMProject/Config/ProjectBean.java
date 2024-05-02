package com.example.CRMProject.Config;

import com.cloudinary.Cloudinary;
import com.example.CRMProject.Model.Admission;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProjectBean {

    @Bean
    public Admission mapper(){return new Admission();}

    @Bean
    public Cloudinary getCloudinary(){
        Map map=new HashMap();
        map.put("cloud_name","dn0hzzxws");
        map.put("api_key","775514722739857");
        map.put("api_secret","iJLgXqEvmxsqjvcWKwRLqtf1riY");
        map.put("secure",true);

    return new Cloudinary(map);
    }
}
