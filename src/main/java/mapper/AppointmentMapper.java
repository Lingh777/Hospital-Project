package mapper;

import entity.Appointment;

import java.util.List;
import java.util.Map;

public interface AppointmentMapper {
    List<Appointment> getAppointmentsByDID(String dID);
    void makeAppointment(Map params);
    List<Appointment> getAppointmentsByUID(String uID);
    void deleteAppointment(String appointmentID);
}
