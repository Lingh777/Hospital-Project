package service;

import entity.Appointment;
import entity.Doctor;

import java.util.List;

public interface IDoctorService {
    int checkDoctor(Doctor doctor);
    List<Appointment> getAppointmentsByDID(String dID);
    Doctor getDoctorAllIfmByDID(String dID);
}


