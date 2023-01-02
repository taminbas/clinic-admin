package com.clinicadminservice.controller;

import com.clinicadminservice.exception.NoDataFoundException;
import com.clinicadminservice.model.Appointment;
import com.clinicadminservice.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping("/appointments")
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @PostMapping("/appointments")
    public ResponseEntity<Object> createAppointment(@RequestBody Appointment appointment) {
        appointment.setCreatedAt(new java.sql.Date(appointment.getCreatedAt().getTime()));
        appointment.setUpdatedAt(new java.sql.Date(appointment.getUpdatedAt().getTime()));
        appointmentService.createAppointment(appointment);
        return new ResponseEntity<>("Appointment is created successfully", HttpStatus.OK);
    }

    @GetMapping("/appointments/{id}")
    public Appointment getAppointmentById(@PathVariable(value = "id") Long appointmentId) {
        return appointmentService.getAppointmentById(appointmentId);
    }

    @GetMapping("/appointments/date")
    public List<Appointment> getAppointmentByDate(@RequestParam String createdAt) throws ParseException {

        String startDate = createdAt + " 00:00:01";
        String endDate = createdAt + " 23:59:59";
        Date currStartDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startDate);
        Date currEndDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endDate);

        return appointmentService.getAppointmentByDate(new java.sql.Date(currStartDate.getTime()), new java.sql.Date(currEndDate.getTime()));

    }

    @GetMapping("/appointments/current-date")
    public List<Appointment> getAppointmentByCurDate() throws ParseException {
        Date currentDate = new Date();
        String curStrDate = new SimpleDateFormat("yyyy-MM-dd").format(currentDate);
        String startDate = curStrDate + " 00:00:01";
        String endDate = curStrDate + " 23:59:59";
        Date currStartDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startDate);
        Date currEndDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endDate);

        return appointmentService.getAppointmentByDate(new java.sql.Date(currStartDate.getTime()), new java.sql.Date(currEndDate.getTime()));

    }

    @GetMapping("/appointments/history/{pName}")
    public List<Appointment> getAppointmentByName(@PathVariable(value = "pName") String pName) {
        List<Appointment> appList = appointmentService.getAppointmentByName(pName);
        if(appList.isEmpty()) {
            throw new NoDataFoundException("No appointments exists!!");
        }
        else {
            return appList;
        }

    }

    @GetMapping("/appointments/active")
    public List<Appointment> getAppointmentByNameAndStatus(@RequestParam String patientName, @RequestParam String status) {
        return appointmentService.getAppointmentByNameAndStatus(patientName, status);
    }

    @PutMapping("/appointments/{id}")
    public ResponseEntity<Object> updateAppointment(@PathVariable(value = "id") Long appointmentId, @RequestBody Appointment appointmentDetails) {
       appointmentService.updateAppointment(appointmentId, appointmentDetails);
       return new ResponseEntity<>("Appointment is updated successfully", HttpStatus.OK);
    }

}
