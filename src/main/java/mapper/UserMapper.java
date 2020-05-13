package mapper;

import entity.Department;
import entity.User;

import java.util.List;

public interface UserMapper {
	int checkUser(User user);
	List<Department> getDepartmentList();
}
