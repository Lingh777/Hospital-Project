package mapper;

import entity.Appointment;

import java.util.List;

public interface AppointmentMapper {
    List<Appointment> getAppointmentsByDID(String dID);
}
