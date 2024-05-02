package com.example.CRMProject.Controller;

import com.example.CRMProject.Model.Admission;
import com.example.CRMProject.Model.Course;
import com.example.CRMProject.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping("/AddCourse")
    @ResponseBody
    public Course CreateNewFeild(@RequestBody Course course ) {

      Course c1=  courseService.saveCourse(course);
        return  c1;
    }

    @GetMapping("/getAllCourse")
    @ResponseBody
    public List<Course> getAllCourse( ) {
        List<Course> listOfCourses=courseService.getAllCourses();
        return listOfCourses;
    }

    @DeleteMapping("/deleteById/{sid}")
    @ResponseBody
    public void deleteById( @PathVariable Long sid) {
        courseService.deleteCourseById(sid);
    }

    @GetMapping("/getCourseById/{id}")
    @ResponseBody
    public Course getAdmissionById(@PathVariable Long id){
        Course course=courseService.courseGetById(id);
        return course;
    }

}
