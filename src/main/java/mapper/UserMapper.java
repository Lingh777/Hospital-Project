package mapper;

import entity.Department;
import entity.Doctor;
import entity.User;

import java.util.List;

public interface UserMapper {
	int checkUser(User user);
	User getUserAllIfmByUID(String uID);
	List<Department> getDepartmentList();
	List<Doctor> getDoctorListByDepartmentID(String departmentID);
}
