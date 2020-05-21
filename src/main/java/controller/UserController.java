package controller;

import entity.Appointment;
import entity.Department;
import entity.Doctor;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.impl.DoctorService;
import service.impl.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//后端接口
@Controller
@CrossOrigin
@RequestMapping("user")
public class UserController {
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Autowired
    @Qualifier("doctorService")
    private DoctorService doctorService;


    @RequestMapping(value = "login")
    @ResponseBody
    public Map checkUser(User user){
        Map<String,Integer> resultMap = new HashMap<>();
        int count = userService.checkUser(user);
        if(count == 1){
            resultMap.put("result",1);
        }else{
            resultMap.put("result",0);
        }
        return resultMap;
    }

    @RequestMapping("getUserAllIfmByUID")
    @ResponseBody
    public Map getUserAllIfmByUID(@RequestParam("uID") String uID){
        Map<String,User> resultMap = new HashMap<>();
        User user = userService.getUserAllIfmByUID(uID);
        resultMap.put("user",user);
        return resultMap;
    }

    @RequestMapping("getDepartmentList")
    @ResponseBody
    public Map getDepartmentList() {
        Map<String,List> resultMap = new HashMap<>();
        List<Department> departmentList = userService.getDepartmentList();
        resultMap.put("departmentList" , departmentList);
        return resultMap;
    }

    @RequestMapping("getDoctorListByDepartmentID")
    @ResponseBody
    public Map getDoctorListByDepartmentID(@RequestParam("departmentID") String departmentID){
        Map<String,List> resultMap = new HashMap<>();
        List<Doctor> doctorList = userService.getDoctorListByDepartmentID(departmentID);
        resultMap.put("doctorList" , doctorList);
        return resultMap;
    }

    @RequestMapping("getDoctorAllIfmByDID")
    @ResponseBody
    public Map getDoctorAllIfmByDID(@RequestParam("dID") String dID){
        Map<String,Doctor> resultMap = new HashMap<>();
        Doctor doctor = doctorService.getDoctorAllIfmByDID(dID);
        resultMap.put("doctor" , doctor);
        return resultMap;
    }

    @RequestMapping("makeAppointment")
    @ResponseBody
    public Map makeAppointment(@RequestParam("uID") String uID , @RequestParam("dID") String dID , @RequestParam("date") String date , @RequestParam("description") String description){
        String appointmentID = uID+dID+date;
        System.out.println(appointmentID);
        Map<String,Object> sqlParams = new HashMap<>();
        sqlParams.put("appointmentID",appointmentID);
        sqlParams.put("uID",uID);
        sqlParams.put("dID",dID);
        sqlParams.put("date",date);
        sqlParams.put("description",description);
        sqlParams.put("status",0);
        int result = userService.makeAppointment(sqlParams);
        Map<String,Integer> resultMap = new HashMap<>();
        resultMap.put("result",result);
        return resultMap;
    }

    @RequestMapping("getAppointmentsByUID")
    @ResponseBody
    public Map getAppointmentsByUID(@RequestParam("uID") String uID){
        Map<String,List> resultMap = new HashMap<>();
        List<Appointment> appointmentList = userService.getAppointmentsByUID(uID);
        resultMap.put("appointmentList",appointmentList);
        return resultMap;
    }

    @RequestMapping("deleteAppointment")
    @ResponseBody
    public Map deleteAppointment(@RequestParam("appointmentID") String appointmentID){
        Map<String,Integer> resultMap = new HashMap<>();
        int result = userService.deleteAppointment(appointmentID);
        resultMap.put("result",result);
        return resultMap;
    }

    @RequestMapping("updateUserIfm")
    @ResponseBody
    public Map updateUserIfm(@RequestParam("uID") String uID , @RequestParam("uName") String uName ,@RequestParam("uTel") String uTel){
        User user = new User();
        user.setuID(uID);
        user.setuName(uName);
        user.setuTel(uTel);
        Map<String,Integer> resultMap = new HashMap<>();
        int result = userService.updateUserIfm(user);
        resultMap.put("result",result);
        return resultMap;
    }

    @RequestMapping("updateUPwd")
    @ResponseBody
    public Map updateUPwd(@RequestParam("uID") String uID , @RequestParam("uPwd") String uPwd){
        User user = new User();
        user.setuID(uID);
        user.setuPwd(uPwd);
        Map<String,Integer> resultMap = new HashMap<>();
        int result = userService.updateUPwd(user);
        resultMap.put("result",result);
        return resultMap;
    }
}

