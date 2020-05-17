package controller;

import entity.Appointment;
import entity.Department;
import entity.Doctor;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.impl.DoctorService;
import service.impl.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    //测试方法
    @RequestMapping("test/login")
    public ModelAndView testCheckUser(User user) {
        ModelAndView mv;
        int result = userService.checkUser(user);
        if(result == 1) {
            mv = new ModelAndView("userPage");
            mv.addObject("uID",user.getuID());
            return mv;
        }else{
            mv = new ModelAndView("error");
        }
        return mv;
    }

    @RequestMapping("test/getUserAllIfmByUID")
    public ModelAndView testGetUserAllIfmByUID(@RequestParam("uID") String uID){
        ModelAndView mv = new ModelAndView("user_ifm");
        User user = userService.getUserAllIfmByUID(uID);
        mv.addObject("user" , user);
        return mv;
    }

    @RequestMapping("test/getDepartmentList")
    public ModelAndView testGetDepartmentList() {
        ModelAndView mv = new ModelAndView("user_departmentList");
        List<Department> departmentList = userService.getDepartmentList();
        mv.addObject("departmentList" , departmentList);
        return mv;
    }

    @RequestMapping("test/getDoctorListByDepartmentID")
    public ModelAndView testGetDoctorListByDepartmentID(@RequestParam("departmentID") String departmentID){
        ModelAndView mv = new ModelAndView("user_doctorListByDepartmentID");
        List<Doctor> doctorList = userService.getDoctorListByDepartmentID(departmentID);
        mv.addObject("doctorList" , doctorList);
        return mv;
    }

    @RequestMapping("test/getDoctorAllIfmByDID")
    public ModelAndView testGetDoctorAllIfmByDID(@RequestParam("dID") String dID){
        ModelAndView mv = new ModelAndView(("user_doctorIfm"));
        Doctor doctor = doctorService.getDoctorAllIfmByDID(dID);
        mv.addObject("doctor" , doctor);
        return mv;
    }

    @RequestMapping("test/makeAppointment")
    public ModelAndView testMakeAppointment(@RequestParam Map<String,String> params){
        String uID = params.get("uID");
        String dID = params.get("dID");
        String date = params.get("date");
        String appointmentID = uID+dID+date;
        Map sqlParams = new HashMap();
        sqlParams.put("appointmentID",appointmentID);
        sqlParams.put("uID",uID);
        sqlParams.put("dID",dID);
        sqlParams.put("date",date);
        ModelAndView mv = new ModelAndView("user_makeAppointment_result");
        int result = userService.makeAppointment(sqlParams);
        mv.addObject("result",result);
        return mv;
    }

    //后端接口
    @RequestMapping(value = "login")
    @ResponseBody
    public Map checkUser(@RequestParam("uID") String uID, @RequestParam("uPwd") String uPwd){
        User user = new User();
        user.setuID(uID);
        user.setuPwd(uPwd);
        Map resultMap = new HashMap();
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
        Map resultMap = new HashMap();
        User user = userService.getUserAllIfmByUID(uID);
        resultMap.put("user",user);
        return resultMap;
    }

    @RequestMapping("getDepartmentList")
    @ResponseBody
    public Map getDepartmentList() {
        Map resultMap = new HashMap();
        List<Department> departmentList = userService.getDepartmentList();
        resultMap.put("departmentList" , departmentList);
        return resultMap;
    }

    @RequestMapping("getDoctorListByDepartmentID")
    @ResponseBody
    public Map getDoctorListByDepartmentID(@RequestParam("departmentID") String departmentID){
        Map resultMap = new HashMap();
        List<Doctor> doctorList = userService.getDoctorListByDepartmentID(departmentID);
        resultMap.put("doctorList" , doctorList);
        return resultMap;
    }

    @RequestMapping("getDoctorAllIfmByDID")
    @ResponseBody
    public Map getDoctorAllIfmByDID(@RequestParam("dID") String dID){
        Map resultMap = new HashMap();
        Doctor doctor = doctorService.getDoctorAllIfmByDID(dID);
        resultMap.put("doctor" , doctor);
        return resultMap;
    }

    @RequestMapping("makeAppointment")
    @ResponseBody
    public Map makeAppointment(@RequestParam("uID") String uID , @RequestParam("dID") String dID , @RequestParam("date") String date){
        String appointmentID = uID+dID+date;
        System.out.println(appointmentID);
        Map sqlParams = new HashMap();
        sqlParams.put("appointmentID",appointmentID);
        sqlParams.put("uID",uID);
        sqlParams.put("dID",dID);
        sqlParams.put("date",date);
        int result = userService.makeAppointment(sqlParams);
        Map resultMap = new HashMap();
        resultMap.put("result",result);
        return resultMap;
    }

    @RequestMapping("getAppointmentsByUID")
    @ResponseBody
    public Map getAppointmentsByUID(@RequestParam("uID") String uID){
        Map resultMap = new HashMap();
        List<Appointment> appointmentList = userService.getAppointmentsByUID(uID);
        resultMap.put("appointmentList",appointmentList);
        return resultMap;
    }

    @RequestMapping("deleteAppointment")
    @ResponseBody
    public Map deleteAppointment(@RequestParam("appointmentID") String appointmentID){
        Map resultMap = new HashMap();
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
        Map resultMap = new HashMap();
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
        Map resultMap = new HashMap();
        int result = userService.updateUPwd(user);
        resultMap.put("result",result);
        return resultMap;
    }
}
