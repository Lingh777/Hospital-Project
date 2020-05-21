package service.impl;

import entity.Appointment;
import entity.Doctor;
import mapper.AppointmentMapper;
import mapper.DoctorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import service.IDoctorService;

import java.util.List;

@Service
public class DoctorService implements IDoctorService {
    @Autowired
    @Qualifier("doctorMapper")
    private DoctorMapper doctorMapper;

    @Autowired
    @Qualifier("appointmentMapper")
    private AppointmentMapper appointmentMapper;

    @Override
    public int checkDoctor(Doctor doctor){
        int result = doctorMapper.checkDoctor(doctor);
        if(result == 1){
            return 1;
        }
        return 0;
    }

    @Override
    public List<Appointment> getAppointmentsByDID(String dID) {
        List<Appointment> appointments = appointmentMapper.getAppointmentsByDID(dID);
        return appointments;
    }

    @Override
    public Doctor getDoctorAllIfmByDID(String dID) {
        Doctor doctor = doctorMapper.getDoctorAllIfmByDID(dID);
        return doctor;
    }

    @Override
    public int acceptAppointment(String appointmentID) {
        try{
            appointmentMapper.acceptAppointment(appointmentID);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @Override
    public int finishAppointment(String appointmentID) {
        try{
            appointmentMapper.finishAppointment(appointmentID);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

}
