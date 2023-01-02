package com.clinicadminservice.repository;

import com.clinicadminservice.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByPatientName(String pName);

    List<Appointment> findByPatientNameAndStatus(String pName, String status);

    List<Appointment> findAllByCreatedAtBetween(Date createdAtStart, Date createdAtEnd);
}
