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
import service.impl.DoctorService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//后端接口
@Controller
@CrossOrigin
@RequestMapping("doctor")
public class DoctorController {
    @Autowired
    @Qualifier("doctorService")
    private DoctorService doctorService;

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
