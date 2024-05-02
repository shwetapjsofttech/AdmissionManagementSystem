package com.example.CRMProject.Service;

import com.example.CRMProject.Model.Course;
import com.example.CRMProject.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceimpl implements CourseService{


    @Autowired
    CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public Course courseGetById(Long id) {
        return  courseRepository.findById(id).get();
    }


    @Override
    public Course saveCourse(Course s1) {
        courseRepository.save(s1);
        return s1;
    }

    @Override
    public Course findByCourseName(String Cname) {
        return courseRepository.findByCname(Cname);
    }


    @Override
    public void deleteCourseById(Long id) {

        courseRepository.deleteById(id);
    }
}
