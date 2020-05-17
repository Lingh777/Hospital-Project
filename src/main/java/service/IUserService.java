package service;

import entity.Appointment;
import entity.Department;
import entity.Doctor;
import entity.User;

import java.util.List;
import java.util.Map;

public interface IUserService {
    int checkUser(User user);
    User getUserAllIfmByUID(String uID);
    List<Department> getDepartmentList();
    List<Doctor> getDoctorListByDepartmentID(String departmentID);
    int makeAppointment(Map params);
    List<Appointment> getAppointmentsByUID(String uID);
    int deleteAppointment(String appointmentID);
    int updateUserIfm(User user);
    int updateUPwd(User user);
}
