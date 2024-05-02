package com.example.CRMProject.Repository;

import com.example.CRMProject.Model.Admission;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface AdmissionRepository extends CrudRepository<Admission, Long> {

    List<Admission> findByDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    @Query("SELECT a FROM Admission a WHERE a.sid = :sid")
    Admission findBySid(@Param("sid") Long sid);

    @Transactional
    @Modifying
    @Query("DELETE FROM Admission a WHERE a.sid = :sid")
    void deleteBySid(@Param("sid") Long sid);

    List<Admission> findByDateBetweenAndScourses(Date startDate, Date endDate, String scourses);
}
