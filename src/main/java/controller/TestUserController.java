package controller;

import entity.Department;
import entity.Doctor;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.impl.DoctorService;
import service.impl.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//测试方法
@Controller
@CrossOrigin
@RequestMapping("user/test")
public class TestUserController {
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Autowired
    @Qualifier("doctorService")
    private DoctorService doctorService;



    @RequestMapping("login")
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

    @RequestMapping("getUserAllIfmByUID")
    public ModelAndView testGetUserAllIfmByUID(@RequestParam("uID") String uID){
        ModelAndView mv = new ModelAndView("user_ifm");
        User user = userService.getUserAllIfmByUID(uID);
        mv.addObject("user" , user);
        return mv;
    }

    @RequestMapping("getDepartmentList")
    public ModelAndView testGetDepartmentList() {
        ModelAndView mv = new ModelAndView("user_departmentList");
        List<Department> departmentList = userService.getDepartmentList();
        mv.addObject("departmentList" , departmentList);
        return mv;
    }

    @RequestMapping("getDoctorListByDepartmentID")
    public ModelAndView testGetDoctorListByDepartmentID(@RequestParam("departmentID") String departmentID){
        ModelAndView mv = new ModelAndView("user_doctorListByDepartmentID");
        List<Doctor> doctorList = userService.getDoctorListByDepartmentID(departmentID);
        mv.addObject("doctorList" , doctorList);
        return mv;
    }

    @RequestMapping("getDoctorAllIfmByDID")
    public ModelAndView testGetDoctorAllIfmByDID(@RequestParam("dID") String dID){
        ModelAndView mv = new ModelAndView(("user_doctorIfm"));
        Doctor doctor = doctorService.getDoctorAllIfmByDID(dID);
        mv.addObject("doctor" , doctor);
        return mv;
    }

    @RequestMapping("makeAppointment")
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
}
