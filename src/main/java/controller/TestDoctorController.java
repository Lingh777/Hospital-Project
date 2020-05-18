package controller;

import entity.Appointment;
import entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.impl.DoctorService;

import java.util.List;

//测试方法
@Controller
@CrossOrigin
@RequestMapping("doctor/tset")
public class TestDoctorController {
    @Autowired
    @Qualifier("doctorService")
    private DoctorService doctorService;


    @RequestMapping("login")
    public ModelAndView testCheckDoctor(Doctor doctor){
        int result = doctorService.checkDoctor(doctor);
        if(result == 1) {
            ModelAndView mv = new ModelAndView("doctorPage");
            mv.addObject("dID",doctor.getdID());
            return mv;
        }
        return new ModelAndView("error");
    }

    @RequestMapping("getAppointmentsByDID")
    public ModelAndView testGetAppointmentsByDID(@RequestParam("dID") String dID){
        ModelAndView mv = new ModelAndView("doctor_appointments");
        List<Appointment> appointments = doctorService.getAppointmentsByDID(dID);
        mv.addObject("appointments",appointments);
        return mv;
    }

    @RequestMapping("getDoctorAllIfmByDID")
    public ModelAndView testGetDoctorAllIfmByDID(@RequestParam("dID") String dID){
        ModelAndView mv = new ModelAndView(("doctor_ifm"));
        Doctor doctor = doctorService.getDoctorAllIfmByDID(dID);
        mv.addObject("doctor" , doctor);
        return mv;
    }
}
