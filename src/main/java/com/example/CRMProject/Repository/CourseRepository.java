package com.example.CRMProject.Repository;

import com.example.CRMProject.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


public interface CourseRepository extends JpaRepository<Course,Long > {

    @Query("SELECT c FROM Course c WHERE c.Cname = :Cname")
    Course findByCname(@Param("Cname") String Cname);

}
