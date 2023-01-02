package com.clinicadminservice.service;

import com.clinicadminservice.exception.ResourceNotFoundException;
import com.clinicadminservice.model.Appointment;
import com.clinicadminservice.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }


    public Appointment getAppointmentById(Long appointmentId) {
        return appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment", "id", appointmentId));
    }

    public List<Appointment> getAppointmentByDate(Date createdAtStart, Date createdAtEnd) {
        return appointmentRepository.findAllByCreatedAtBetween(createdAtStart, createdAtEnd);

    }

    public List<Appointment> getAppointmentByName(String pName) {
        return appointmentRepository.findByPatientName(pName);

    }

    public List<Appointment> getAppointmentByNameAndStatus(String pName, String status) {
        return appointmentRepository.findByPatientNameAndStatus(pName, status);

    }

    public Appointment updateAppointment(Long appointmentId, Appointment appointmentDetails) {

        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment", "id", appointmentId));

        appointment.setPatientName(appointmentDetails.getPatientName());
        appointment.setStatus(appointmentDetails.getStatus());
        appointment.setReason(appointmentDetails.getReason());
        Appointment updatedAppointment = appointmentRepository.save(appointment);
        return updatedAppointment;
    }

}
