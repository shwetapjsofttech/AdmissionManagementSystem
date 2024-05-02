package com.example.CRMProject.Service;

import com.example.CRMProject.Model.Course;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourses();
    Course courseGetById(Long id);
    Course saveCourse(Course s1);
    Course findByCourseName(String Cname);


    void deleteCourseById(Long id);
}
