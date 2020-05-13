package mapper;

import entity.Doctor;

public interface DoctorMapper {
    int checkDoctor(Doctor doctor);
    Doctor getDoctorAllIfmByDID(String dID);
}
