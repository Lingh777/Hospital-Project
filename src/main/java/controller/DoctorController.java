package controller;

import entity.Appointment;
import entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import service.impl.DoctorService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
@RequestMapping("doctor")
public class DoctorController {
    @Autowired
    @Qualifier("doctorService")
    private DoctorService doctorService;

    //测试方法
    @RequestMapping("test/login")
    public ModelAndView testCheckDoctor(Doctor doctor){
        int result = doctorService.checkDoctor(doctor);
        if(result == 1) {
            ModelAndView mv = new ModelAndView("doctorPage");
            mv.addObject("dID",doctor.getdID());
            return mv;
        }
        return new ModelAndView("error");
    }

    @RequestMapping("test/getAppointmentsByDID")
    public ModelAndView testGetAppointmentsByDID(@RequestParam("dID") String dID){
        ModelAndView mv = new ModelAndView("doctor_appointments");
        List<Appointment> appointments = doctorService.getAppointmentsByDID(dID);
        mv.addObject("appointments",appointments);
        return mv;
    }

    @RequestMapping("test/getDoctorAllIfmByDID")
    public ModelAndView testGetDoctorAllIfmByDID(@RequestParam("dID") String dID){
        ModelAndView mv = new ModelAndView(("doctor_ifm"));
        Doctor doctor = doctorService.getDoctorAllIfmByDID(dID);
        mv.addObject("doctor" , doctor);
        return mv;
    }


    //后端接口
    @RequestMapping("login")
    @ResponseBody
    public Map checkDoctor(@RequestParam("dID") String dID,@RequestParam("dPwd") String dPwd){
        //System.out.println(dID+"\t"+dPwd);
        Doctor doctor = new Doctor();
        doctor.setdID(dID);
        doctor.setdPwd(dPwd);
        Map resultMap = new HashMap();
        int count = doctorService.checkDoctor(doctor);
        if(count == 1){
            resultMap.put("result",1);
        }else{
            resultMap.put("result",0);
        }
        return resultMap;
    }

    @RequestMapping("getAppointmentsByDID")
    @ResponseBody
    public Map getAppointmentsByDID(@RequestParam("dID") String dID){
        //System.out.println(dID);
        Map resultMap = new HashMap();
        List<Appointment> appointments = doctorService.getAppointmentsByDID(dID);
        resultMap.put("appointmentList",appointments);
        return resultMap;
    }

    @RequestMapping("getDoctorAllIfmByDID")
    @ResponseBody
    public Map getDoctorAllIfmByDID(@RequestParam("dID") String dID){
        Map resultMap = new HashMap();
        Doctor doctor = doctorService.getDoctorAllIfmByDID(dID);
        resultMap.put("doctor",doctor);
        return resultMap;
    }
}
