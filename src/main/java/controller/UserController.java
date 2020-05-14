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
import org.springframework.web.bind.annotation.ResponseBody;
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




    //后端接口
    @RequestMapping("login")
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
}
