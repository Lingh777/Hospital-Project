package service.impl;

import entity.Appointment;
import entity.Department;
import entity.Doctor;
import entity.User;
import mapper.AppointmentMapper;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import service.IUserService;

import java.util.List;
import java.util.Map;

@Service
public class UserService implements IUserService {
    @Autowired
    @Qualifier("userMapper")
    private UserMapper userMapper;

    @Autowired
    @Qualifier("appointmentMapper")
    private AppointmentMapper appointmentMapper;


    @Override
    public int checkUser(User user){
        int result = userMapper.checkUser(user);
        if(result == 1){
            return 1;
        }
        return 0;
    }

    @Override
    public User getUserAllIfmByUID(String uID) {
        User user = userMapper.getUserAllIfmByUID(uID);
        return user;
    }

    @Override
    public List<Department> getDepartmentList() {
        List<Department> departmentList = userMapper.getDepartmentList();
        return departmentList;
    }

    @Override
    public List<Doctor> getDoctorListByDepartmentID(String departmentID) {
        List<Doctor> doctorList = userMapper.getDoctorListByDepartmentID(departmentID);
        return doctorList;
    }

    @Override
    public int makeAppointment(Map params) {
        try{
            appointmentMapper.makeAppointment(params);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }

        return 1;
    }

    @Override
    public List<Appointment> getAppointmentsByUID(String uID) {
        List<Appointment> appointmentList = appointmentMapper.getAppointmentsByUID(uID);
        return appointmentList;
    }

    @Override
    public int deleteAppointment(String appointmentID) {
        try{
            appointmentMapper.deleteAppointment(appointmentID);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }

        return 1;
    }

    @Override
    public int updateUserIfm(User user) {
        try{
            userMapper.updateUserIfm(user);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @Override
    public int updateUPwd(User user) {
        try{
            userMapper.updateUPwd(user);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        return 1;
    }
}
