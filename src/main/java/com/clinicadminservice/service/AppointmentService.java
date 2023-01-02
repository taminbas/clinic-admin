package com.clinicadminservice.service;

import com.clinicadminservice.model.Appointment;
import java.util.Date;
import java.util.List;

public interface AppointmentService {

    List<Appointment> getAllAppointments();
    Appointment createAppointment(Appointment appointment);
    Appointment getAppointmentById(Long appointmentId);

    List<Appointment> getAppointmentByName(String pName);

    List<Appointment> getAppointmentByNameAndStatus(String pName, String status);
    List<Appointment> getAppointmentByDate(Date createdAtStart, Date createdAtEnd);
    Appointment updateAppointment(Long appointmentId, Appointment appointmentDetails);

}
